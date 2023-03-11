package me.kevind.vibehub.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public final class MessageUtils {

    public static void message(CommandSender sender, String string) {
        String prefix = ConfigUtils.get(String.class, "messages.Prefix");

        sender.sendMessage(ColorUtils.color(prefix + string));
    }

    public static void broadcast(String string) {
        String prefix = ConfigUtils.get(String.class, "messages.Prefix");

        Bukkit.broadcastMessage(ColorUtils.color(prefix + string));
    }

}
