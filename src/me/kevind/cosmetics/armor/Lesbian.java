package me.kevind.cosmetics.armor;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public final class Lesbian {
    public static ItemStack createLesbianHelmet() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) helmet.getItemMeta();
        meta.setColor(Color.fromRGB(213, 45, 0)); // Dark Orange
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        helmet.setItemMeta(meta);
        return helmet;
    }
    public static ItemStack createLesbianChesplate() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setColor(Color.fromRGB(239, 118, 39)); // Orange
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestplate.setItemMeta(meta);
        return chestplate;
    }
    public static ItemStack createLesbianLeggings() {
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) leggings.getItemMeta();
        meta.setColor(Color.fromRGB(255, 154, 86)); // Light Orange
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        leggings.setItemMeta(meta);
        return leggings;
    }
    public static ItemStack createLesbianBoots() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) boots.getItemMeta();
        meta.setColor(Color.fromRGB(209, 98, 164)); // Pink
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        boots.setItemMeta(meta);
        return boots;
    }
}
