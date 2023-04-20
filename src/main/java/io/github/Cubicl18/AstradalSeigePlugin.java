package io.github.Cubicl18;


import com.fren_gor.ultimateAdvancementAPI.AdvancementTab;
import com.fren_gor.ultimateAdvancementAPI.UltimateAdvancementAPI;
import com.fren_gor.ultimateAdvancementAPI.advancement.RootAdvancement;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.advancement.display.AdvancementFrameType;
import io.github.Cubicl18.Commands.*;
import io.github.Cubicl18.Listeners.EventManager;
import io.github.Cubicl18.advs.AdvancementTabNamespaces;
import io.github.Cubicl18.advs.astradalsieges.Big_gun;
import io.github.Cubicl18.advs.astradalsieges.Fire;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.Cubicl18.Items.ItemManager;

public class AstradalSeigePlugin extends JavaPlugin {
    public static UltimateAdvancementAPI api;
    public AdvancementTab astradalsieges;
    FileConfiguration config = this.getConfig();






    public void registerCommands() {
        CommandHandler handler = new CommandHandler();
        handler.register("sieges", new SiegeCmd());

        handler.register("info", new InfoCmd());
        getCommand("sieges").setExecutor(handler);




    }
    public void initializeTabs() {
        api = UltimateAdvancementAPI.getInstance(this);
        astradalsieges = api.createAdvancementTab(AdvancementTabNamespaces.astradalsieges_NAMESPACE);
        RootAdvancement oak_sapling0 = new RootAdvancement(astradalsieges, "astradalbegin", new AdvancementDisplay(Material.ANVIL, "The War Begins", AdvancementFrameType.TASK, true, true, 0f, 0f , "The War Begins", "build Siege Weapons ", "and defeat your enemies!"),"textures/block/amethyst_block.png",1);
        Big_gun big_gun = new Big_gun(oak_sapling0);
        Fire fire = new Fire(big_gun);
        astradalsieges.registerAdvancements(oak_sapling0 ,big_gun ,fire );
    }






    @Override
    public void onEnable() {
        //Config
        this.saveDefaultConfig();
        String cannonid = getConfig().getString("modelids.cannonid");
        String trebuchetid = getConfig().getString("modelids.trebuchetid");
        String ballistaid = getConfig().getString("modelids.ballistaid");
        String catapultid = getConfig().getString("modelids.catapultid");
        this.getConfig().set("modelids.cannonid", cannonid);
        this.getConfig().set("modelids.trebuchetid", trebuchetid);
        this.getConfig().set("modelids.ballistaid", ballistaid);
        this.getConfig().set("modelids.catapultid", catapultid);




        //register voids
        

        this.registerCommands();
        this.initializeTabs();
        //everything else
        ItemManager.ItemInit();
        getLogger().info("Items Loaded Successfully!");
        PluginDescriptionFile pdf = this.getDescription(); //Gets plugin.yml
        pdf.getVersion(); //Gets the version
        getLogger().info("AstradalSieges Commands Loaded Successfully!");
        getServer().getPluginManager().registerEvents(new EventManager(), this);
        getLogger().info("events loaded successfully");

        getLogger().info("Astradal Config Loaded!");

        getLogger().info("Astradal Advancements Loaded!");


        getLogger().info("AstradalSieges Plugin Loaded" + this.getDescription().getVersion());

    }

    @Override
    public void onDisable() {

        getLogger().info("AstradalSieges Disabled! check console for info");
    }

}
