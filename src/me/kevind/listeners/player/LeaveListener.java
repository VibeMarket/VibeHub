package me.kevind.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

public final class LeaveListener implements Listener {
    @EventHandler
    public void onLeaveEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        player.setAllowFlight(false);
        player.setFlying(false);
        for (PotionEffect effect : player.getActivePotionEffects())
            player.removePotionEffect(effect.getType());
    }
}
