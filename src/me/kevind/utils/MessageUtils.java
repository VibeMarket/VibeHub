package me.kevind.utils;

import org.bukkit.entity.Player;

public class MessageUtils {
    public static void sendMessage(Player player, String s) {
        player.sendMessage(ColorUtils.color(s));
    }
}
