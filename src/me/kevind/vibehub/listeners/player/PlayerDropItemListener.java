package me.kevind.vibehub.listeners.player;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public final class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItemListener(PlayerDropItemEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE))
            event.getItemDrop().remove();
        else
            event.setCancelled(true);
    }

}
