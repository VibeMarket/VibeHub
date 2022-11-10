package me.kevind.listeners;

import me.kevind.utils.ItemList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {
    @EventHandler
    public void onPlayerDropItemListener(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().contains(ItemList.ENDERPEARL)) {
            event.setCancelled(true);
        }
        if (player.getInventory().contains(ItemList.SPEED_ITEM)) {
            event.setCancelled(true);
        }
        if (player.getInventory().contains(ItemList.TIME_SELECTOR)) {
            event.setCancelled(true);
        }
        if (player.getInventory().contains(ItemList.SERVER_SELECTOR)) {
            event.setCancelled(true);
        }
    }
}
