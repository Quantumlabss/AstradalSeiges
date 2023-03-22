package io.github.Cubicl18.weapons;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.entity.Dummy;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Ballista implements Listener {
    public static ItemStack ballista;
    public void init() {
        createBallista();


    }
    //create trebuchet Item
    public static void createBallista() {
        ItemStack item = new ItemStack(Material.BAT_SPAWN_EGG, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Ballista");
        List<String> lore = new ArrayList<>();
        lore.add("Ballista Weapon");
        lore.add("Right Click Ground To Spawn!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        ballista = item;

        //Shapeless Recipe
        ShapelessRecipe ballistarecipe = new ShapelessRecipe(NamespacedKey.minecraft("ballistarecipe"), item);
        ballistarecipe.addIngredient(2, Material.COBBLESTONE);
        ballistarecipe.addIngredient(1, Material.ARROW);
        ballistarecipe.addIngredient(1, Material.STRING);
        //Bukkit.getServer().addRecipe(ballistarecipe);
        Bukkit.addRecipe(ballistarecipe);


    }
    //spawn
    @EventHandler
    public void spawnBallista(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        ActiveModel activeModel = ModelEngineAPI.createActiveModel("ballista");
        Dummy dummy = ModelEngineAPI.createDummy();
        ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(dummy);
        modeledEntity.addModel(activeModel, true);

        modeledEntity.showToPlayer(p);
    }
    public void fireBallista(PlayerInteractEntityEvent fireb) {
        Player p = fireb.getPlayer();
        if (fireb.getRightClicked() instanceof Dummy) {
            if (p.getInventory().getItemInMainHand().getType() == Material.POLISHED_BLACKSTONE && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Ballista Ammo")) {
                //remove 1 ammo item from player

                //fire projectile




            }



        }
    }

}
