package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.item.NovaItem
import xyz.xenondevs.nova.item.behavior.Chargeable
import xyz.xenondevs.nova.item.behavior.Wearable
import xyz.xenondevs.nova.jetpacks.JetpackTier
import xyz.xenondevs.nova.jetpacks.Jetpacks
import xyz.xenondevs.nova.jetpacks.item.JetpackBehavior
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerDefaultItem
import xyz.xenondevs.nova.player.equipment.ArmorType

private fun jetpackBehaviors(
    tier: JetpackTier,
): NovaItem {
    return NovaItem(Wearable(ArmorType.CHESTPLATE), Chargeable, JetpackBehavior(tier))
}

object Items {
    
    val BASIC_JETPACK = registerDefaultItem(Jetpacks, "basic_jetpack", jetpackBehaviors(JetpackTier.BASIC))
    val ADVANCED_JETPACK = registerDefaultItem(Jetpacks, "advanced_jetpack", jetpackBehaviors(JetpackTier.ADVANCED))
    val ELITE_JETPACK = registerDefaultItem(Jetpacks, "elite_jetpack", jetpackBehaviors(JetpackTier.ELITE))
    val ULTIMATE_JETPACK = registerDefaultItem(Jetpacks, "ultimate_jetpack", jetpackBehaviors(JetpackTier.ULTIMATE))
    
    val ARMORED_BASIC_JETPACK = registerDefaultItem(Jetpacks, "armored_basic_jetpack", jetpackBehaviors(JetpackTier.BASIC))
    val ARMORED_ADVANCED_JETPACK = registerDefaultItem(Jetpacks, "armored_advanced_jetpack", jetpackBehaviors(JetpackTier.ADVANCED))
    val ARMORED_ELITE_JETPACK = registerDefaultItem(Jetpacks, "armored_elite_jetpack", jetpackBehaviors(JetpackTier.ELITE))
    val ARMORED_ULTIMATE_JETPACK = registerDefaultItem(Jetpacks, "armored_ultimate_jetpack", jetpackBehaviors(JetpackTier.ULTIMATE))
    
    fun init() = Unit
    
}