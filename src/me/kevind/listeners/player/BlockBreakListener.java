package me.kevind.listeners.player;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPermission("vibe.build"))) {
            event.setCancelled(true);
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7You cannot break blocks here."));
        } else {
            event.setCancelled(false);
        }
    }
}
