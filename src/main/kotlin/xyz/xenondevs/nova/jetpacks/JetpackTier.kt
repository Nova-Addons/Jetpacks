package xyz.xenondevs.nova.jetpacks

import xyz.xenondevs.nova.item.NovaItem
import xyz.xenondevs.nova.jetpacks.ability.JetpackFlyAbility
import xyz.xenondevs.nova.jetpacks.registry.Abilities
import xyz.xenondevs.nova.jetpacks.registry.Attachments
import xyz.xenondevs.nova.jetpacks.registry.Items
import xyz.xenondevs.nova.player.ability.AbilityType
import xyz.xenondevs.nova.player.attachment.AttachmentType

enum class JetpackTier(
    lazyAbilityType: () -> AbilityType<JetpackFlyAbility>,
    lazyAttachmentType: () -> AttachmentType<*>,
    lazyMaterials: () -> List<NovaItem>
) {
    
    BASIC({ Abilities.BASIC_JETPACK_FLY }, { Attachments.BASIC_JETPACK }, { listOf(Items.BASIC_JETPACK, Items.ARMORED_BASIC_JETPACK) }),
    ADVANCED({ Abilities.ADVANCED_JETPACK_FLY }, { Attachments.ADVANCED_JETPACK }, { listOf(Items.ADVANCED_JETPACK, Items.ARMORED_BASIC_JETPACK) }),
    ELITE({ Abilities.ELITE_JETPACK_FLY }, { Attachments.ELITE_JETPACK }, { listOf(Items.ELITE_JETPACK, Items.ARMORED_ELITE_JETPACK) }),
    ULTIMATE({ Abilities.ULTIMATE_JETPACK_FLY }, { Attachments.ULTIMATE_JETPACK }, { listOf(Items.ULTIMATE_JETPACK, Items.ARMORED_ULTIMATE_JETPACK) });
    
    val abilityType by lazy(lazyAbilityType)
    val attachmentType by lazy(lazyAttachmentType)
    val materials by lazy(lazyMaterials)
    
}