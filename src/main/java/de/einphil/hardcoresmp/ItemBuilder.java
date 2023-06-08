package de.einphil.hardcoresmp;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private SkullMeta skullMeta;
    private PotionMeta potionMeta;

    public ItemBuilder(){
        this(Material.AIR);
    }

    public ItemBuilder(Material material){
        this(material, 1);
    }

    public ItemBuilder(Material material, int amount) {
        this(material, amount, 0);
    }

    public ItemBuilder(Material material, int amount, int data) {
        this.itemStack = new ItemStack(material, amount, (byte)data);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder(Material material, int amount, String displayName) {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = itemStack.getItemMeta();
        this.itemMeta.setDisplayName(displayName);
        applyItemMeta();
    }

    public ItemBuilder(Material material, int amount, String displayName, String... lore) {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = itemStack.getItemMeta();
        this.itemMeta.setDisplayName(displayName);
        this.itemMeta.setLore(Arrays.asList(lore));
        applyItemMeta();
    }

    public ItemBuilder(ItemStack itemStack){
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }


    public void addEnchantments(Enchantment... enchantments) {
        for(Enchantment enchantment : enchantments) {
            itemMeta.addEnchant(enchantment, 1, true);
        }
        applyItemMeta();
    }

    public void addEnchantment(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, true);
        applyItemMeta();
    }

    public void addItemFlags(ItemFlag... itemFlag) {
        itemMeta.addItemFlags(itemFlag);
        applyItemMeta();
    }

    public void addAllItemFlags() {
        itemMeta.addItemFlags(ItemFlag.values());
        applyItemMeta();
    }

    public void setUnbreakable(boolean unbreakable) {
        itemMeta.setUnbreakable(unbreakable);
        applyItemMeta();
    }

    public void setLore(String... lore) {
        this.itemMeta.setLore(Arrays.asList(lore));
        applyItemMeta();
    }

    public void setLocalizedName(String localizedName) {
        this.itemMeta.setLocalizedName(localizedName);
        applyItemMeta();
    }

    public String getLocalizedName() {
        return this.itemMeta.getLocalizedName();
    }

    private void applyItemMeta() {
        this.itemStack.setItemMeta(this.itemMeta);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

    public String getDisplayName() {
        return itemMeta.getDisplayName();
    }

    public void setItemMeta(ItemMeta itemMeta) {
        this.itemMeta = itemMeta;
    }

    public SkullMeta getSkullMeta() {
        return skullMeta;
    }

    public void setSkullMeta(SkullMeta skullMeta) {
        this.skullMeta = skullMeta;
    }

    public PotionMeta getPotionMeta() {
        return potionMeta;
    }

    public void setPotionMeta(PotionMeta potionMeta) {
        this.potionMeta = potionMeta;
    }
}
