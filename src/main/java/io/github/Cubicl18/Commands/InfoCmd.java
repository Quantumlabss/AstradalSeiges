package io.github.Cubicl18.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class InfoCmd implements CommandInterface {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player p = (Player) sender;
        if(args.length > 1) return false;
        p.sendMessage("AstradalSieges Version 1.0.0");
        p.sendMessage("What's New:");
        p.sendMessage("-Added Cannon");
        p.sendMessage("-Added Ballista");
        p.sendMessage("-Added Catapult");
        p.sendMessage("-Added Trebuchet");
        return false;
    }
}
