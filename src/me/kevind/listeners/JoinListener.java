package me.kevind.listeners;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.ItemList;
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
    private final Location loc = new Location(Bukkit.getWorld("TempHub2022"), 0.500, 65.0, 0.500, 90, 2);
    private final Location kevinloc = new Location(Bukkit.getWorld("Hub2023"), 0.500, 65.0, 0.500, 90, 2);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getPlayer().getName();
        String profileLoadedMessage = VibeHub.getInstance().getConfig().getString("profileLoadedMessage");
        String profileCreatedMessage = VibeHub.getInstance().getConfig().getString("profileCreatedMessage");
        String kevinuuid = VibeHub.getInstance().getConfig().getString("kevinuuid");
        String minauuid = VibeHub.getInstance().getConfig().getString("minauuid");

        //String ClearInventoryBypassPermission = VibeHub.getInstance().getConfig().getString("ClearInventoryBypassPermission");
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        player.setGameMode(GameMode.ADVENTURE);
        player.setInvulnerable(true);
        player.getInventory().clear();
        player.getInventory().setItem(4, ItemList.SERVER_SELECTOR);
        player.getInventory().setItem(8, ItemList.SPEED_ITEM);
        player.updateInventory();
        if (player.hasPlayedBefore())
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + profileLoadedMessage + playerName));
        else
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + profileCreatedMessage + playerName));

        player.teleport(loc);

        player.setAllowFlight(true);
        player.setFlying(true);

        if (Users.isKevin()) {
            player.teleport(kevinloc);
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7You've been detected as" + player.getName() + ". We're teleporting you to the new Hub."));
        if (Users.isMina()) {

        }
        }
    }
}
