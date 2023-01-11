package me.kevind.utils;

import me.kevind.VibeHub;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public final class MessageUtils {
    public static void sendMessage(CommandSender sender, String s) {
        sender.sendMessage(ColorUtils.color(s));
    }

    public static void broadcastMessage(String s) {
        Bukkit.broadcastMessage(ColorUtils.color(VibeHub.getPrefix() + s));
    }
    public static void sendMessageWithPrefix(CommandSender sender, String s) {
        sender.sendMessage(ColorUtils.color(VibeHub.getPrefix() + s));
    }
}
