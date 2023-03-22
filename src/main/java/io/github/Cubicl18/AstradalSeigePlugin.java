package io.github.Cubicl18;

import io.github.Cubicl18.Commands.*;
import io.github.Cubicl18.Items.ItemManager;
import io.github.Cubicl18.weapons.Ballista;
import io.github.Cubicl18.weapons.Cannon;
import io.github.Cubicl18.weapons.Catapult;
import io.github.Cubicl18.weapons.Trebuchet;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AstradalSeigePlugin extends JavaPlugin {

    public void registerCommands() {
        CommandHandler handler = new CommandHandler();
        handler.register("sieges", new SiegeCmd());

        handler.register("info", new InfoCmd());
        getCommand("sieges").setExecutor(handler);
        //spawnWeapon Commands(need to set perms for only Devs and Mods)
        handler.register("spawnTrebuchet", new spawnTrebuchetCmd());
        getCommand("sieges").setExecutor(handler);
        handler.register("spawnCannon", new spawnCannonCmd());
        getCommand("sieges").setExecutor(handler);
        handler.register("spawnBallista", new spawnBallistaCmd());
        getCommand("sieges").setExecutor(handler);

    }

    @Override
    public void onEnable() {
        this.registerCommands();
        ItemManager.init();
        getLogger().info("AstradalSieges Commands Loaded Successfully!");
        Bukkit.getServer().getPluginManager().registerEvents(new Cannon(), this);
        //Bukkit.getServer().getPluginManager().registerEvents(new Trebuchet(), this);
        //Bukkit.getServer().getPluginManager().registerEvents(new Ballista(), this);
        //Bukkit.getServer().getPluginManager().registerEvents(new Catapult(), this);
        getLogger().info("events loaded successfully");

        getLogger().info("AstradalSieges Plugin Loaded--V1.0.0(BuildDev1.9.0)");

    }
    @Override
    public void onDisable() {

        getLogger().info("AstradalSieges Disabled");
    }
}
