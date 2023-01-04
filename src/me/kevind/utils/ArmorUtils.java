package me.kevind.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class ArmorUtils {
    public static final  void clearArmor(Player player) {
        player.getInventory().setArmorContents(new ItemStack[4]);
    }
}
