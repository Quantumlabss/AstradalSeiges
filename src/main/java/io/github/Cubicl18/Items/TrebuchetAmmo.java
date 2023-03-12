package io.github.Cubicl18.Items;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TrebuchetAmmo extends JavaPlugin {
    public void onEnable() {
        ItemStack trebuchetAmmo = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = trebuchetAmmo.getItemMeta();
        meta.setDisplayName("TrebuchetAmmo");
        trebuchetAmmo.setItemMeta(meta);

        //recipe
        NamespacedKey key = new NamespacedKey((Plugin) this, "TrebuchetAmmo");
        ShapedRecipe recipe = new ShapedRecipe(key, trebuchetAmmo);
        recipe.shape(" G ", " A ", " G ");
        //G: gunpowder, A: Arrow
        recipe.setIngredient('G', Material.GUNPOWDER);
        recipe.setIngredient('A', Material.ARROW);

        Bukkit.addRecipe(recipe);

        getLogger().info("ammo loaded");


    }

    public void onDisable() {

    }

}
