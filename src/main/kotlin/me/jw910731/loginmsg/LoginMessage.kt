package me.jw910731.loginmsg

import me.jw910731.loginmsg.command.LogMsgCommand
import me.jw910731.loginmsg.command.MotdCommand
import org.bukkit.ChatColor
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level


class LoginMessage: JavaPlugin() {
    val messageHandler = MessageHandler(this)
    override fun onEnable() {
        // handle config
        saveDefaultConfig()

        // register command
        getCommand("motd")!!.setExecutor(MotdCommand(this))
        getCommand("logmsg")!!.setExecutor(LogMsgCommand(this))

        // register event listener
        server.pluginManager.registerEvents(MessageHandler(this), this)

        // log plugin load message
        logger.info("Plugin Loaded.")
    }

    fun getMotd() : String? {
        val motdConf = config.get("motd") ?: return null
        val msg : String = when(motdConf){
            is List<*> -> motdConf.joinToString(separator = "\n")
            else -> motdConf.toString()
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
