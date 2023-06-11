package xyz.xenondevs.nova.jetpacks

import xyz.xenondevs.nova.addon.Addon
import xyz.xenondevs.nova.update.ProjectDistributor

object Jetpacks : Addon() {
    
    override val projectDistributors = listOf(ProjectDistributor.hangar("xenondevs/Jetpacks"))
    
}