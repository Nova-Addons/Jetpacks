package xyz.xenondevs.nova.jetpacks.ability

import net.minecraft.core.particles.ParticleTypes
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.entity.Player
import xyz.xenondevs.commons.provider.Provider
import xyz.xenondevs.nmsutils.particle.ParticleBuilder
import xyz.xenondevs.nova.item.behavior.Chargeable
import xyz.xenondevs.nova.jetpacks.ui.JetpackOverlay
import xyz.xenondevs.nova.player.ability.Ability
import xyz.xenondevs.nova.player.ability.AbilityManager
import xyz.xenondevs.nova.ui.overlay.actionbar.ActionbarOverlayManager
import xyz.xenondevs.nova.util.broadcast
import xyz.xenondevs.nova.util.item.novaMaterial
import xyz.xenondevs.nova.util.minecraftServer
import xyz.xenondevs.nova.util.serverTick

class JetpackFlyAbility(player: Player, flySpeed: Provider<Float>, energyPerTick: Provider<Long>) : Ability(player) {
    
    private val flySpeed: Float by flySpeed
    private val energyPerTick: Long by energyPerTick
    
    private val wasFlying = player.isFlying
    private val wasAllowFlight = player.allowFlight
    private val previousFlySpeed = player.flySpeed
    
    private val overlay = JetpackOverlay()
    private val jetpackItem by lazy { player.equipment?.chestplate }
    private val novaItem by lazy { jetpackItem?.novaMaterial?.novaItem }
    
    init {
        player.isFlying = false
        player.flySpeed = this.flySpeed
        
        ActionbarOverlayManager.registerOverlay(player, overlay)
    }
    
    override fun handleRemove() {
        player.allowFlight = wasAllowFlight
        player.isFlying = wasFlying
        player.flySpeed = previousFlySpeed
        
        ActionbarOverlayManager.unregisterOverlay(player, overlay)
    }
    
    override fun handleTick() {
        val jetpackItem = jetpackItem
        val novaItem = novaItem
        if (jetpackItem == null || novaItem == null) {
            AbilityManager.takeAbility(player, this)
            return
        }
        
        val chargeable = novaItem.getBehavior(Chargeable::class)!!
        val energyLeft = chargeable.getEnergy(jetpackItem)
        overlay.percentage = energyLeft / chargeable.options.maxEnergy.toDouble()
        
        if (energyLeft > energyPerTick) {
            if (player.isFlying) {
                chargeable.addEnergy(jetpackItem, -energyPerTick)
                if (serverTick % 3 == 0) {
                    val location = player.location
                    playSound(location)
                    spawnParticles(location)
                }
            } else {
                player.allowFlight = true
            }
        } else if (player.isFlying) {
            player.isFlying = false
            player.allowFlight = false
        }
    }
    
    override fun reload() {
        player.flySpeed = flySpeed
    }
    
    private fun playSound(location: Location) {
        location.world!!.playSound(location, Sound.BLOCK_FIRE_EXTINGUISH, 0.2f, 5f)
    }
    
    private fun spawnParticles(location: Location) {
        location.pitch = 0f
        location.y += 0.5
        location.yaw -= 160
        spawnParticle(location.clone().add(location.direction.multiply(0.5)))
        location.yaw -= 70
        spawnParticle(location.clone().add(location.direction.multiply(0.5)))
    }
    
    private fun spawnParticle(location: Location) {
        val packet = ParticleBuilder(ParticleTypes.FLAME, location).offsetY(-0.5f).build()
        minecraftServer.playerList.broadcast(location, 32.0, packet)
    }
    
}