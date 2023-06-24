package xyz.xenondevs.nova.jetpacks.registry

import org.bukkit.GameMode
import xyz.xenondevs.nova.addon.registry.AbilityTypeRegistry
import xyz.xenondevs.nova.data.config.NovaConfig
import xyz.xenondevs.nova.data.config.configReloadable
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.jetpacks.Jetpacks
import xyz.xenondevs.nova.jetpacks.ability.JetpackFlyAbility
import xyz.xenondevs.nova.util.data.getFloat

private val IGNORED_GAME_MODES = configReloadable {
    val modesRaw = NovaConfig["jetpacks:config"].getStringList("ignored_game_mode")
    GameMode.values().filter { gameMode -> modesRaw.any { it.equals(gameMode.name, ignoreCase = true) } }
}
private val BASIC_FLY_SPEED = configReloadable { NovaConfig["jetpacks:basic_jetpack"].getFloat("fly_speed") }
private val BASIC_ENERGY_PER_TICK = configReloadable { NovaConfig["jetpacks:basic_jetpack"].getLong("energy_per_tick") }
private val ADVANCED_FLY_SPEED = configReloadable { NovaConfig["jetpacks:advanced_jetpack"].getFloat("fly_speed") }
private val ADVANCED_ENERGY_PER_TICK = configReloadable { NovaConfig["jetpacks:advanced_jetpack"].getLong("energy_per_tick") }
private val ELITE_FLY_SPEED = configReloadable { NovaConfig["jetpacks:elite_jetpack"].getFloat("fly_speed") }
private val ELITE_ENERGY_PER_TICK = configReloadable { NovaConfig["jetpacks:elite_jetpack"].getLong("energy_per_tick") }
private val ULTIMATE_FLY_SPEED = configReloadable { NovaConfig["jetpacks:ultimate_jetpack"].getFloat("fly_speed") }
private val ULTIMATE_ENERGY_PER_TICK = configReloadable { NovaConfig["jetpacks:ultimate_jetpack"].getLong("energy_per_tick") }

@Init
object Abilities : AbilityTypeRegistry by Jetpacks.registry {
    
    val BASIC_JETPACK_FLY = registerAbilityType("basic_jetpack_fly") { JetpackFlyAbility(it, BASIC_FLY_SPEED, BASIC_ENERGY_PER_TICK, IGNORED_GAME_MODES) }
    val ADVANCED_JETPACK_FLY = registerAbilityType("advanced_jetpack_fly") { JetpackFlyAbility(it, ADVANCED_FLY_SPEED, ADVANCED_ENERGY_PER_TICK, IGNORED_GAME_MODES) }
    val ELITE_JETPACK_FLY = registerAbilityType("elite_jetpack_fly") { JetpackFlyAbility(it, ELITE_FLY_SPEED, ELITE_ENERGY_PER_TICK, IGNORED_GAME_MODES) }
    val ULTIMATE_JETPACK_FLY = registerAbilityType("ultimate_jetpack_fly") { JetpackFlyAbility(it, ULTIMATE_FLY_SPEED, ULTIMATE_ENERGY_PER_TICK, IGNORED_GAME_MODES) }
    
}