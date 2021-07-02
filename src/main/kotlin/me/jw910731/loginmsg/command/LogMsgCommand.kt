package me.jw910731.loginmsg.command

import me.jw910731.loginmsg.LoginMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor

class LogMsgCommand internal constructor (private val pluginInst : LoginMessage) : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(args.isEmpty()){
            sender.sendMessage("Login Message: A plugin that send message when login!")
            return true
        }
        if(args[0] == "reload"){
            if(!sender.hasPermission("logmsg.admin")){
                sender.sendMessage("[LoginMessage] You don't have permission to do this")
                return true
            }
            pluginInst.reloadConfig()
            sender.sendMessage("[LoginMessage] Config reloaded")
            return true
        }
        return false
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {
        if(!sender.hasPermission("logmsg.admin")){
            return null
        }
        if(args.size != 1){
            return null
        }
        return mutableListOf("reload")
    }
}
