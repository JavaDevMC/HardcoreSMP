package de.einphil.hardcoresmp;
import com.maximde.pluginutils.ColorUtils;
import de.einphil.hardcoresmp.commands.SetHealthCommand;
import de.einphil.hardcoresmp.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;


public class HardcoreSMP extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerBlockPlaceListener(), this);
        getCommand("sethealth").setExecutor(new SetHealthCommand());
        createRecipe();
    }

    private void createRecipe() {
        NamespacedKey key = new NamespacedKey(this, "revive_item");
        ItemBuilder itemBuilder = new ItemBuilder(Material.STRUCTURE_VOID, 1, ColorUtils.generateGradientText(Color.ORANGE, Color.WHITE, "Wiederbelebungs Item"));
        ShapedRecipe recipe = new ShapedRecipe(key, itemBuilder.getItemStack());
        recipe.shape("SDS",
                "DND",
                "SDS");
        recipe.setIngredient('N', Material.NETHERITE_BLOCK);
        recipe.setIngredient('S', Material.WITHER_SKELETON_SKULL);
        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        getServer().addRecipe(recipe);
    }

}