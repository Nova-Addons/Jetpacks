package xyz.xenondevs.nova.jetpacks.ui

import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ComponentBuilder
import xyz.xenondevs.nova.ui.overlay.actionbar.ActionbarOverlay
import xyz.xenondevs.nova.ui.overlay.character.MoveCharacters

class JetpackOverlay : ActionbarOverlay {
    
    override var components: Array<BaseComponent> = getCurrentComponents()
        private set
    
    var percentage: Double = 0.0
        set(value) {
            require(value in 0.0..1.0)
            if (field == value) return
            field = value
            components = getCurrentComponents()
        }
    
    private fun getCurrentComponents(): Array<BaseComponent> {
        val stage = (percentage * 38).toInt()
        
        return ComponentBuilder()
            .append(MoveCharacters.getMovingComponent(95))
            .append(('\uF000'.code + stage).toChar().toString())
            .font("jetpacks:energy_bar")
            .create()
    }
    
}