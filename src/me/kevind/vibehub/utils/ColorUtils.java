package me.kevind.vibehub.utils;

import org.bukkit.ChatColor;

public final class ColorUtils {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
