package xyz.xenondevs.nova.jetpacks

import xyz.xenondevs.nova.addon.Addon
import xyz.xenondevs.nova.jetpacks.registry.Abilities
import xyz.xenondevs.nova.jetpacks.registry.Attachments
import xyz.xenondevs.nova.jetpacks.registry.Items
import java.util.logging.Logger

lateinit var LOGGER: Logger

object Jetpacks : Addon() {
    
    override fun init() {
        LOGGER = logger
        
        Items.init()
        Abilities.init()
        Attachments.init()
    }
    
    override fun onEnable() = Unit
    
    override fun onDisable() = Unit
    
}