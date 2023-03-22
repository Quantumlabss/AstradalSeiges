package io.github.Cubicl18.weapons;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.entity.BaseEntity;
import com.ticxo.modelengine.api.entity.BukkitEntity;
import com.ticxo.modelengine.api.entity.Dummy;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import com.ticxo.modelengine.api.nms.entity.fake.DummyRangeEntity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Cannon implements Listener {
    public static ItemStack cannon;
    public void init() {
        createCannon();


    }
    //create trebuchet Item
    public static void createCannon() {
        ItemStack item = new ItemStack(Material.BAT_SPAWN_EGG, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Cannon");
        List<String> lore = new ArrayList<>();
        lore.add("Cannon Weapon");
        lore.add("Right Click Ground To Spawn!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        cannon = item;

        //Shapeless Recipe
        ShapelessRecipe cannonrecipe = new ShapelessRecipe(NamespacedKey.minecraft("cannonrecipe"), item);
        cannonrecipe.addIngredient(2, Material.COBBLESTONE);
        cannonrecipe.addIngredient(1, Material.ARROW);
        cannonrecipe.addIngredient(1, Material.STRING);
        //Bukkit.getServer().addRecipe(cannonrecipe);
        Bukkit.addRecipe(cannonrecipe);


    }
    //spawn
    @EventHandler
    public void spawnCannon(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        ActiveModel activeModel = ModelEngineAPI.createActiveModel("cannon");
        Dummy cannonEntity = ModelEngineAPI.createDummy();
        ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(cannonEntity);
        modeledEntity.addModel(activeModel, true);

        modeledEntity.showToPlayer(p);
    }
    public void fireCannon(PlayerInteractEntityEvent fire) {
        Player p = fire.getPlayer();



        if (fire.getRightClicked() instanceof Dummy) {
            if (p.getInventory().getItemInMainHand().getType() == Material.POLISHED_BLACKSTONE && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Cannon Ammo")) {
                //remove 1 ammo item from player



                //fire projectile


                











            }



        }
    }




}
