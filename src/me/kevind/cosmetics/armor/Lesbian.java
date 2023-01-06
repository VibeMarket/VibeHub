package me.kevind.cosmetics.armor;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Lesbian {
    public static final ItemStack createLesbianHelmet() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) helmet.getItemMeta();
        meta.setColor(Color.fromRGB(255, 0, 0)); // Red
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        helmet.setItemMeta(meta);
        return helmet;
    }
    public static final ItemStack createLesbianChesplate() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setColor(Color.fromRGB(255, 0, 0)); // Red
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestplate.setItemMeta(meta);
        return chestplate;
    }
    public static final ItemStack createLesbianLeggings() {
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) leggings.getItemMeta();
        meta.setColor(Color.fromRGB(255, 0, 0)); // Red
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        leggings.setItemMeta(meta);
        return leggings;
    }
    public static final ItemStack createLesbianBoots() {
        ItemStack boots = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) boots.getItemMeta();
        meta.setColor(Color.fromRGB(255, 0, 0)); // Red
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        boots.setItemMeta(meta);
        return boots;
    }
}
