package me.kevind.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageUtils {
    public static void sendMessage(CommandSender sender, String s) {
        sender.sendMessage(ColorUtils.color(s));
    }
    public static void broadcastMessage(CommandSender sender, String s) {
        Bukkit.broadcastMessage(ColorUtils.color(s));
    }
}
