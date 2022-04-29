package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.jetpacks.JETPACKS
import xyz.xenondevs.nova.jetpacks.item.JETPACK_ITEM
import xyz.xenondevs.nova.material.NovaMaterialRegistry

object Items {
    
    val JETPACK = NovaMaterialRegistry.registerDefaultItem(JETPACKS, "jetpack", JETPACK_ITEM)
    
    fun init() = Unit
    
}