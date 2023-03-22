package io.github.Cubicl18.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class ItemManager {
    //itemstacks
   public static ItemStack trebuchetAmmo;
   public static ItemStack catapultAmmo;
   public static ItemStack cannonAmmo;

   //init items
   public static void init() {
      trebuchetAmmo();
      catapultAmmo();
      cannonAmmo();
   }

   //Items
   public static void trebuchetAmmo() {
       ItemStack item = new ItemStack(Material.FIRE_CHARGE, 1);
       ItemMeta meta = item.getItemMeta();
       meta.setDisplayName("Trebuchet Ammo");
       List<String> lore = new ArrayList<>();
       lore.add("used with the Trebuchet");
       lore.add("Right Click a trebuchet to fire!");
       meta.setLore(lore);
       item.setItemMeta(meta);
       trebuchetAmmo = item;

       //Shapeless Recipe
       ShapelessRecipe treb = new ShapelessRecipe(NamespacedKey.minecraft("trebammo"), item);
       treb.addIngredient(2, Material.GUNPOWDER);
       treb.addIngredient(1, Material.COBBLED_DEEPSLATE);
       Bukkit.getServer().addRecipe(treb);
       getLogger().info("Trebuchet Ammo Recipe Loaded");

   }
    public static void catapultAmmo() {
        ItemStack item = new ItemStack(Material.GILDED_BLACKSTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Catapult Ammo");
        List<String> lore = new ArrayList<>();
        lore.add("used with the Catapult");
        lore.add("Right Click a Catapult to fire!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        catapultAmmo = item;

        //Shapeless Recipe
        ShapelessRecipe catam = new ShapelessRecipe(NamespacedKey.minecraft("catammo"), item);
        catam.addIngredient(2, Material.GUNPOWDER);
        catam.addIngredient(2, Material.COBBLESTONE);
        //Bukkit.getServer().addRecipe(catam);
        Bukkit.addRecipe(catam);
        getLogger().info("Catapult Ammo Recipe Loaded");


    }
    public static void cannonAmmo() {
        ItemStack item = new ItemStack(Material.POLISHED_BLACKSTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Cannon Ammo");
        List<String> lore = new ArrayList<>();
        lore.add("used with the Cannon");
        lore.add("Right Click a Cannon to fire!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        cannonAmmo = item;

        //Shapeless Recipe
        ShapelessRecipe can = new ShapelessRecipe(NamespacedKey.minecraft("canammo"), item);
        can.addIngredient(2, Material.GUNPOWDER);
        can.addIngredient(1, Material.ARROW);
        //Bukkit.getServer().addRecipe(can);
        Bukkit.addRecipe(can);
        getLogger().info("Cannon Recipe Loaded");

    }


}
