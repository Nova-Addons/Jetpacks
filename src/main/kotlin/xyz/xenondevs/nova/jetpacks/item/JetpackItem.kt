package xyz.xenondevs.nova.jetpacks.item

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import xyz.xenondevs.nova.data.config.NovaConfig
import xyz.xenondevs.nova.item.NovaItem
import xyz.xenondevs.nova.item.behavior.Chargeable
import xyz.xenondevs.nova.item.behavior.ItemBehavior
import xyz.xenondevs.nova.item.behavior.Wearable
import xyz.xenondevs.nova.jetpacks.registry.Abilities
import xyz.xenondevs.nova.jetpacks.registry.Items.JETPACK
import xyz.xenondevs.nova.player.ability.AbilityManager
import xyz.xenondevs.nova.player.attachment.Attachment
import xyz.xenondevs.nova.player.attachment.AttachmentManager
import xyz.xenondevs.nova.player.equipment.ArmorEquipEvent
import xyz.xenondevs.nova.player.equipment.ArmorType
import xyz.xenondevs.nova.player.equipment.EquipMethod

private val MAX_ENERGY = NovaConfig["jetpacks:jetpack"].getLong("capacity")!!

val JETPACK_ITEM = NovaItem(Chargeable(MAX_ENERGY), Wearable(ArmorType.CHESTPLATE), JetpackBehavior)

object JetpackBehavior : ItemBehavior() {
    
    override fun handleEquip(player: Player, itemStack: ItemStack, equipped: Boolean, event: ArmorEquipEvent) {
        if (event.equipMethod == EquipMethod.BREAK) {
            event.isCancelled = true
        } else setJetpack(player, equipped)
    }
    
    fun setJetpack(player: Player, state: Boolean) {
        if (state) {
            Attachment("Jetpack", player.uniqueId, JETPACK.createItemStack(), true)
            AbilityManager.giveAbility(player, Abilities.JETPACK_FLY)
        } else {
            AttachmentManager.getAttachment(player.uniqueId, "Jetpack")?.remove()
            AbilityManager.takeAbility(player, Abilities.JETPACK_FLY)
        }
    }
    
}