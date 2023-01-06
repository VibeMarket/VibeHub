package me.kevind.cosmetics.armor;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public final class Straight {
    public static ItemStack createStraightHelmet() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta)  helmet.getItemMeta();
        meta.setColor(Color.fromRGB(255, 0, 0)); // Red
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        helmet.setItemMeta(meta);
        return helmet;
    }
}
