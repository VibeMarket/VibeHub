package me.kevind.vibehub.tasks;

import me.kevind.vibehub.utils.ColorUtils;
import me.kevind.vibehub.utils.ConfigUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class ActionbarTask implements Runnable {

    @Override
    public void run() {
        String serverIp = ConfigUtils.get(String.class, "messages.ServerIP");

        for (Player player : Bukkit.getOnlinePlayers())
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ColorUtils.color(serverIp)));
    }

}
