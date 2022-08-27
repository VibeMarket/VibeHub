package me.kevind.tasks;

import me.kevind.utils.ColorUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;



public class ActionBarTask extends BukkitRunnable {
    TextComponent ip = new TextComponent(ColorUtils.color("&9vibemarket.org"));
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, ip);
        }
    }
}
