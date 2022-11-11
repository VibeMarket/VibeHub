package me.kevind.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodChangeEvent implements Listener {
    @EventHandler
    public void onLoseHunger(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        player.setSaturation(20);
        player.setFoodLevel(20);
    }
}