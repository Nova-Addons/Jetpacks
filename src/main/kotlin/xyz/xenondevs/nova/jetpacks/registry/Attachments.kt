package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.jetpacks.JETPACKS
import xyz.xenondevs.nova.player.attachment.AttachmentTypeRegistry
import xyz.xenondevs.nova.player.attachment.HideDownAttachment

object Attachments {
    
    val JETPACK_ATTACHMENT = AttachmentTypeRegistry.register(JETPACKS, "jetpack") {
        HideDownAttachment(40f, it, Items.JETPACK.clientsideProvider.get())
    }
    
    fun init() = Unit
    
}