package io.github.Cubicl18.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandHandler implements CommandExecutor {

    //store commands
    private static HashMap<String, CommandInterface> commands = new HashMap<String, CommandInterface>();

    //Register Method
    public void register(String name, CommandInterface cmd) {
        //put commands in hashmap
        commands.put(name, cmd);
    }
    //if string exists
    public boolean exists(String name) {
        //return hashmap
        return commands.containsKey(name);

    }
    //gather method from executor
    public CommandInterface getExecutor(String name) {
        //returns command in hashmap
        return commands.get(name);
    }

    //template
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(sender instanceof Player) {


            if(args.length == 0) {
                getExecutor("sieges").onCommand(sender, cmd, commandLabel, args);
                return true;
            }

            if (exists(args[0])) {
                getExecutor(args[0]).onCommand(sender, cmd, commandLabel, args);
                return true;
            } else {
                sender.sendMessage("This command does not exist!");
                return true;

            }
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
            return true;
        }
    }





}
