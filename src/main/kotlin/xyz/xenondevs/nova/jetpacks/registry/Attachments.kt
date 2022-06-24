package xyz.xenondevs.nova.jetpacks.registry

import xyz.xenondevs.nova.jetpacks.Jetpacks
import xyz.xenondevs.nova.material.ItemNovaMaterial
import xyz.xenondevs.nova.player.attachment.AttachmentType
import xyz.xenondevs.nova.player.attachment.AttachmentTypeRegistry
import xyz.xenondevs.nova.player.attachment.HideDownAttachment

object Attachments {
    
    private fun registerJetpackAttachment(name: String, material: ItemNovaMaterial): AttachmentType<*> =
        AttachmentTypeRegistry.register(Jetpacks, name) {
            HideDownAttachment(40f, it, material.clientsideProvider.get())
        }
    
    val BASIC_JETPACK = registerJetpackAttachment("basic_jetpack", Items.BASIC_JETPACK)
    val ADVANCED_JETPACK = registerJetpackAttachment("advanced_jetpack", Items.ADVANCED_JETPACK)
    val ELITE_JETPACK = registerJetpackAttachment("elite_jetpack", Items.ELITE_JETPACK)
    val ULTIMATE_JETPACK = registerJetpackAttachment("ultimate_jetpack", Items.ULTIMATE_JETPACK)
    
    fun init() = Unit
    
}