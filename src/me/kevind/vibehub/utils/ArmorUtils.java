package me.kevind.vibehub.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public final class ArmorUtils {

    public static ItemStack leather(ArmorType type, int red, int green, int blue) {
        ItemStack item;

        switch (type) {
            case HELMET -> item = new ItemStack(Material.LEATHER_HELMET);
            case CHESTPLATE -> item = new ItemStack(Material.LEATHER_CHESTPLATE);
            case LEGGINGS -> item = new ItemStack(Material.LEATHER_LEGGINGS);
            case BOOTS -> item = new ItemStack(Material.LEATHER_BOOTS);
            default -> { return null; }
        }

        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        assert meta != null;

        meta.setColor(Color.fromRGB(red, green, blue));
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.addItemFlags(
                ItemFlag.HIDE_POTION_EFFECTS,
                ItemFlag.HIDE_DYE,
                ItemFlag.HIDE_ENCHANTS,
                ItemFlag.HIDE_ATTRIBUTES
        );
        item.setItemMeta(meta);

        return item;
    }

}
