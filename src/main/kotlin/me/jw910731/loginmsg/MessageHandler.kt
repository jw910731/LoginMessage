package me.jw910731.loginmsg

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class MessageHandler internal constructor(private val pluginInst : LoginMessage) : Listener {
    @EventHandler fun onPlayerJoin(event:PlayerJoinEvent){
        val player = event.player
        val message = pluginInst.getMotd()
        if(message != null){
            player.sendMessage(message)
        }
    }
}
