package me.jw910731.loginmsg.command

import me.jw910731.loginmsg.LoginMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class MotdCommand internal constructor(private val pluginInst : LoginMessage) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage(pluginInst.getMotd()?:"No message is set!")
        return true
    }
}
