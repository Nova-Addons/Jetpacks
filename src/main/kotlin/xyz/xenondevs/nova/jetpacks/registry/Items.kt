package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.data.config.NovaConfig
import xyz.xenondevs.nova.data.config.ValueReloadable
import xyz.xenondevs.nova.data.config.configReloadable
import xyz.xenondevs.nova.item.NovaItem
import xyz.xenondevs.nova.item.behavior.Chargeable
import xyz.xenondevs.nova.item.behavior.Wearable
import xyz.xenondevs.nova.jetpacks.JetpackTier
import xyz.xenondevs.nova.jetpacks.Jetpacks
import xyz.xenondevs.nova.jetpacks.item.JetpackBehavior
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerDefaultItem
import xyz.xenondevs.nova.player.equipment.ArmorType

private val BASIC_CAPACITY = configReloadable { NovaConfig["jetpacks:basic_jetpack"].getLong("capacity") }
private val ADVANCED_CAPACITY = configReloadable { NovaConfig["jetpacks:advanced_jetpack"].getLong("capacity") }
private val ELITE_CAPACITY = configReloadable { NovaConfig["jetpacks:elite_jetpack"].getLong("capacity") }
private val ULTIMATE_CAPACITY = configReloadable { NovaConfig["jetpacks:ultimate_jetpack"].getLong("capacity") }

private fun jetpackBehaviors(
    capacity: ValueReloadable<Long>,
    tier: JetpackTier,
    armor: Double = 0.0, armorToughness: Double = 0.0
): NovaItem {
    return NovaItem(Chargeable(capacity), Wearable(ArmorType.CHESTPLATE, armor, armorToughness), JetpackBehavior(tier))
}

object Items {
    
    val BASIC_JETPACK = registerDefaultItem(Jetpacks, "basic_jetpack", jetpackBehaviors(BASIC_CAPACITY, JetpackTier.BASIC))
    val ADVANCED_JETPACK = registerDefaultItem(Jetpacks, "advanced_jetpack", jetpackBehaviors(ADVANCED_CAPACITY, JetpackTier.ADVANCED))
    val ELITE_JETPACK = registerDefaultItem(Jetpacks, "elite_jetpack", jetpackBehaviors(ELITE_CAPACITY, JetpackTier.ELITE))
    val ULTIMATE_JETPACK = registerDefaultItem(Jetpacks, "ultimate_jetpack", jetpackBehaviors(ULTIMATE_CAPACITY, JetpackTier.ULTIMATE))
    
    val ARMORED_BASIC_JETPACK = registerDefaultItem(Jetpacks, "armored_basic_jetpack", jetpackBehaviors(BASIC_CAPACITY, JetpackTier.BASIC, 3.0))
    val ARMORED_ADVANCED_JETPACK = registerDefaultItem(Jetpacks, "armored_advanced_jetpack", jetpackBehaviors(ADVANCED_CAPACITY, JetpackTier.ADVANCED, 6.0))
    val ARMORED_ELITE_JETPACK = registerDefaultItem(Jetpacks, "armored_elite_jetpack", jetpackBehaviors(ELITE_CAPACITY, JetpackTier.ELITE, 8.0, 2.0))
    val ARMORED_ULTIMATE_JETPACK = registerDefaultItem(Jetpacks, "armored_ultimate_jetpack", jetpackBehaviors(ULTIMATE_CAPACITY, JetpackTier.ULTIMATE, 8.0, 3.0))
    
    fun init() = Unit
    
}