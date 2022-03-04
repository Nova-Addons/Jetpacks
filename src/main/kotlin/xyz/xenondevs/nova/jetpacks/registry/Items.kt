package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.jetpacks.JETPACKS
import xyz.xenondevs.nova.jetpacks.item.JetpackItem
import xyz.xenondevs.nova.material.NovaMaterialRegistry

object Items {
    
    val JETPACK = NovaMaterialRegistry.registerDefaultItem(JETPACKS, "jetpack", JetpackItem)
    
    fun init() = Unit
    
}