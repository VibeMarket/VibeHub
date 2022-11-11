package me.kevind.listeners.player;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPermission("vibe.build"))) {
            event.setBuild(false);
            event.setCancelled(true);
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7You cannot place blocks here."));
        }else {
            event.setBuild(true);
            event.setCancelled(false);
        }
    }
}
