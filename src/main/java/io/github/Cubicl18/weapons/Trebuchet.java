package io.github.Cubicl18.weapons;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.entity.Dummy;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import com.ticxo.modelengine.api.nms.entity.fake.DummyRangeEntity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.projectiles.ProjectileSource;

import java.util.ArrayList;
import java.util.List;

public class Trebuchet implements Listener {
    public static ItemStack trebuchet;
    public void init() {
        createTrebuchet();


    }
    //create trebuchet Item
    public static void createTrebuchet() {
        ItemStack item = new ItemStack(Material.BAT_SPAWN_EGG, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Trebuchet");
        List<String> lore = new ArrayList<>();
        lore.add("Trebuchet Weapon");
        lore.add("Right Click Ground To Spawn!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        trebuchet = item;

        //Shapeless Recipe
        ShapelessRecipe trebuchetrecipe = new ShapelessRecipe(NamespacedKey.minecraft("trebuchetrecipe"), item);
        trebuchetrecipe.addIngredient(2, Material.COBBLESTONE);
        trebuchetrecipe.addIngredient(1, Material.ARROW);
        //Bukkit.getServer().addRecipe(trebuchetrecipe);
        Bukkit.addRecipe(trebuchetrecipe);


    }
    //spawn trebuchet
    @EventHandler
    public void spawnTrebuchet(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        ActiveModel activeModel = ModelEngineAPI.createActiveModel("trebuchet");
        Dummy dummy = ModelEngineAPI.createDummy();
        ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(dummy);
        modeledEntity.addModel(activeModel, true);

        modeledEntity.showToPlayer(p);
    }

    //Fire



}











