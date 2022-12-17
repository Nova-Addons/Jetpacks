package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.item.behavior.Chargeable
import xyz.xenondevs.nova.item.behavior.Wearable
import xyz.xenondevs.nova.jetpacks.JetpackTier
import xyz.xenondevs.nova.jetpacks.Jetpacks
import xyz.xenondevs.nova.jetpacks.item.JetpackBehavior
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerItem
import xyz.xenondevs.nova.player.equipment.ArmorType

object Items {
    
    val BASIC_JETPACK = registerItem(Jetpacks, "basic_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.BASIC))
    val ADVANCED_JETPACK = registerItem(Jetpacks, "advanced_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.ADVANCED))
    val ELITE_JETPACK = registerItem(Jetpacks, "elite_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.ELITE))
    val ULTIMATE_JETPACK = registerItem(Jetpacks, "ultimate_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.ULTIMATE))
    
    val ARMORED_BASIC_JETPACK = registerItem(Jetpacks, "armored_basic_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.BASIC))
    val ARMORED_ADVANCED_JETPACK = registerItem(Jetpacks, "armored_advanced_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.ADVANCED))
    val ARMORED_ELITE_JETPACK = registerItem(Jetpacks, "armored_elite_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.ELITE))
    val ARMORED_ULTIMATE_JETPACK = registerItem(Jetpacks, "armored_ultimate_jetpack", Chargeable, Wearable(ArmorType.CHESTPLATE), JetpackBehavior(JetpackTier.ULTIMATE))
    
    fun init() = Unit
    
}