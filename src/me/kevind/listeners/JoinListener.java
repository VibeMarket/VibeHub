package me.kevind.listeners;

import me.kevind.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location loc = new Location(Bukkit.getWorld("TempHub2022"), 0.500, 65.0, 0.500, 90, 2);
        player.teleport(loc);
        //give the player flight
        player.setAllowFlight(true);
        player.setFlying(true);
        //give speed 3 <3
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        player.updateInventory();
        if (player.hasPlayedBefore()) {
            player.sendMessage(ColorUtils.color("&9&lVibeツ &8» &aProfile loaded. Welcome back " + player.getPlayer().getName() + "!"));
        }else {
            player.sendMessage(ColorUtils.color("&9&lVibeツ &8» &aProfile created. Welcome " + player.getPlayer().getName()));
        }
    }
}
