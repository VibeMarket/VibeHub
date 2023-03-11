package me.kevind.vibehub.listeners.player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kevind.vibehub.utils.ConfigUtils;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;
import me.kevind.vibehub.utils.ScoreboardUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.ScoreboardManager;

public final class PlayerJoinListener implements Listener {

    private final String world = ConfigUtils.get(String.class, "coordinates.hub.world");
    private final double x = ConfigUtils.get(Double.class, "coordinates.hub.x");
    private final double y = ConfigUtils.get(Double.class, "coordinates.hub.y");
    private final double z = ConfigUtils.get(Double.class, "coordinates.hub.z");
    private final double yaw = ConfigUtils.get(Double.class, "coordinates.hub.yaw");
    private final double pitch = ConfigUtils.get(Double.class, "coordinates.hub.pitch");

    private final Location spawn = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);
    private final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.teleport(spawn);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        player.setGameMode(GameMode.ADVENTURE);
        player.setInvulnerable(true);
        player.setAllowFlight(true);
        player.setCollidable(false);

        player.setHealth(20);
        player.setFoodLevel(20);

        PlayerInventory inventory = player.getInventory();
        inventory.clear();
        inventory.setItem(0, ItemList.TIME_SELECTOR);
        inventory.setItem(1, ItemList.COSMETICS_ITEM);
        inventory.setItem(4, ItemList.SERVER_SELECTOR);
        inventory.setItem(7, ItemList.ENDERPEARL);
        inventory.setItem(8, ItemList.SPEED_ITEM);
        inventory.setHeldItemSlot(4);
        player.updateInventory();

        if (scoreboardManager != null) {
            player.setScoreboard(scoreboardManager.getNewScoreboard());

            ScoreboardUtils.setupScoreboard(player);
            ScoreboardUtils.setupEntityCollision(player);
        }

        String message = ConfigUtils.get(String.class, player.hasPlayedBefore() ?
                "messages.ProfileLoadedMessage" :
                "messages.ProfileCreatedMessage");

        MessageUtils.message(player, PlaceholderAPI.setPlaceholders(player, message));
    }
}
