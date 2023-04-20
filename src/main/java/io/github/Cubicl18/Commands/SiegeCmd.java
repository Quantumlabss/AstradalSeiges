package io.github.Cubicl18.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SiegeCmd implements CommandInterface {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        //change this later
        p.sendMessage("Sieges v1.0.0");
        p.sendMessage("use /sieges info for info");
        p.sendMessage("Developed by QuantumLabs, 20Cents and the rest of the Astradal Dev Team!");
        return false;
    }


}
