package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.jetpacks.JETPACKS
import xyz.xenondevs.nova.jetpacks.ability.JetpackFlyAbility
import xyz.xenondevs.nova.player.ability.AbilityTypeRegistry

object Abilities {
    
    val JETPACK_FLY = AbilityTypeRegistry.registerAbility(JETPACKS, "jetpack_fly", ::JetpackFlyAbility)
    
    fun init() = Unit
    
}