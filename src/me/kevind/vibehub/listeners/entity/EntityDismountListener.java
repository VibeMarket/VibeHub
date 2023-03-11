package me.kevind.vibehub.listeners.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public final class EntityDismountListener implements Listener {

    @EventHandler
    public void onEntityDismount(EntityDismountEvent event) {
        Entity dismounted = event.getDismounted();

        if (dismounted.getType().equals(EntityType.ENDER_PEARL))
            dismounted.remove();
    }

}
