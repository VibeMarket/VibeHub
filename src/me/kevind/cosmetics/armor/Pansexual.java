package me.kevind.cosmetics.armor;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public final class Pansexual {
    public static ItemStack createPanHelmet() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) helmet.getItemMeta();
        meta.setColor(Color.fromRGB(255, 33, 140)); // Magenta
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        helmet.setItemMeta(meta);
        return helmet;
    }
    public static ItemStack createPanChesplate() {
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setColor(Color.fromRGB(255, 216, 0)); // Yellow
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestplate.setItemMeta(meta);
        return chestplate;
    }
    public static ItemStack createPanLeggings() {
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) leggings.getItemMeta();
        meta.setColor(Color.fromRGB(33, 177, 255)); // Cyan
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        leggings.setItemMeta(meta);
        return leggings;
    }
    public static ItemStack createPanBoots() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) boots.getItemMeta();
        meta.setColor(Color.fromRGB(255, 33, 140)); // Red
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        boots.setItemMeta(meta);
        return boots;
    }
}
