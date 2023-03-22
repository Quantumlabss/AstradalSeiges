package io.github.Cubicl18.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCmd implements CommandInterface {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if(args.length > 1) return false;
        p.sendMessage("AstradalSieges V1.0.0(build 1.10.1-DEV)");
        p.sendMessage("What's New:");
        p.sendMessage("-Added Cannon and Ballista");
        p.sendMessage("-Weapons functionality");
        return false;
    }
}
