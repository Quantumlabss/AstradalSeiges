package io.github.Cubicl18.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SiegeCmd implements CommandInterface {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        //change this later
        p.sendMessage("SiegeCommand Test!");
        return false;
    }


}
