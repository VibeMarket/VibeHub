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
    private Location loc = new Location(Bukkit.getWorld("TempHub2022"), 0.500, 65.0, 0.500, 90, 2);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getPlayer().getName();
        String profileLoadedMessage = VibeHub.getInstance().getConfig().getString("profileLoadedMessage");
        String profileCreatedMessage = VibeHub.getInstance().getConfig().getString("profileCreatedMessage");
        //String ClearInventoryBypassPermission = VibeHub.getInstance().getConfig().getString("ClearInventoryBypassPermission");

        player.teleport(loc);

        player.setAllowFlight(true);
        player.setFlying(true);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        player.setGameMode(GameMode.ADVENTURE);

        player.getInventory().clear();
        //player.getInventory().setItem(4, ItemList.SERVER_SELECTOR);
        player.updateInventory();

        if (player.hasPlayedBefore())
            player.sendMessage(ColorUtils.color(profileLoadedMessage + playerName));
        else
            player.sendMessage(ColorUtils.color(profileCreatedMessage + playerName));
        //if kevin, op.
        if (player.getUniqueId().equals("a948c50c-ede2-4dfa-9b6c-688daf22197c") && !player.isOp())
            player.setOp(true);
            player.sendMessage(ColorUtils.color("&9&lVibeツ &8» &aHello!" + player.getPlayer().getName() + "!" + "Your UUID is set to be opped, we've opped you automatically."));
         //if mina, op.
        if (player.getUniqueId().equals("40ef6ecc-b56f-41f9-bfb1-ec7b7300bfa4") && !player.isOp()) {
            player.setOp(true);
            player.sendMessage(ColorUtils.color("&9&lVibeツ &8» &aHello" + player.getPlayer().getName() + "!" + "Your UUID is set to be opped, we've opped you automatically."));
        }
    }
}
