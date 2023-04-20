package io.github.Cubicl18.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import io.github.Cubicl18.AstradalSeigePlugin;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class ItemManager {
    //ItemStacks
    public static ItemStack cannonItem;
    public static ItemStack cannonBall;
//Init items and recipes
    public static void ItemInit() {
        createCannonItem();
        createCannonBall();



    }
    static Plugin plugin = AstradalSeigePlugin.getPlugin(AstradalSeigePlugin.class);
    //Items

    public static void createCannonItem() {
        ItemStack item = new ItemStack(Material.TURTLE_EGG);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Cannon");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Right Click Ground To Spawn");
        lore.add(ChatColor.DARK_BLUE + "Take Down Your Enemies!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        cannonItem = item;
        NamespacedKey cannonKey = new NamespacedKey(plugin, "cannonKey");

        //Recipe
        ShapedRecipe cannonRecipe = new ShapedRecipe(cannonKey, item);
        cannonRecipe.shape("asa", "gii", "wwG");
        cannonRecipe.setIngredient('s', Material.STRING);
        cannonRecipe.setIngredient('g', Material.GUNPOWDER);
        cannonRecipe.setIngredient('i', Material.IRON_BLOCK);
        cannonRecipe.setIngredient('w', Material.OAK_PLANKS);
        cannonRecipe.setIngredient('G', Material.GOLD_INGOT);
        cannonRecipe.setIngredient('a', Material.AIR);
        getServer().addRecipe(cannonRecipe);

    }
    public static void createCannonBall() {
        ItemStack item = new ItemStack(Material.FIREWORK_STAR);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "CannonBall");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Right Click Cannon to Fire!");
        lore.add(ChatColor.DARK_BLUE + "Take Down Your Enemies!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        cannonBall = item;




        //Recipe
        NamespacedKey cannonbKey = new NamespacedKey(plugin, "cannonbKey");

        ShapedRecipe CannonBall = new ShapedRecipe(cannonbKey, item);
        CannonBall.shape("gcg", "cic", "gcg");
        CannonBall.setIngredient('i', Material.IRON_INGOT);
        CannonBall.setIngredient('g', Material.GUNPOWDER);
        CannonBall.setIngredient('c', Material.COBBLESTONE);
        getServer().addRecipe(CannonBall);

    }
    //catapult

    //Trebuchet


    //ballista



}
