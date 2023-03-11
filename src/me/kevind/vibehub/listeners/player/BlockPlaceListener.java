package me.kevind.vibehub.listeners.player;

import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BlockPlaceListener implements Listener {

    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("vibe.build")) {
            event.setCancelled(true);

            MessageUtils.message(player, "&7You cannot place blocks here.");
        }
    }

}
