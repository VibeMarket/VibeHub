package me.kevind.listeners.player;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public final class EntityDismountListener implements Listener {
    @EventHandler
    public void onEntityDismount(EntityDismountEvent event) {
        if (event.getDismounted().getType().equals(EntityType.ENDER_PEARL)) {
            event.getDismounted().remove();
        }
    }
}
