package me.kevind.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodChangeEvent implements Listener {
    @EventHandler
    public void onLoseHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
