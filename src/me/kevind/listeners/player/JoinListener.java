package me.kevind.listeners.player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.FastBoard;
import me.kevind.utils.ItemList;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JoinListener implements Listener {
    String world = VibeHub.getInstance().getConfig().getString("coordinates.hub.world");
    Double x = Double.valueOf(VibeHub.getInstance().getConfig().getString("coordinates.hub.x"));
    Double y = Double.valueOf(VibeHub.getInstance().getConfig().getString("coordinates.hub.y"));
    Double z = Double.valueOf(VibeHub.getInstance().getConfig().getString("coordinates.hub.z"));
    float yaw = Float.parseFloat(VibeHub.getInstance().getConfig().getString("coordinates.hub.yaw"));
    float pitch = Float.parseFloat(VibeHub.getInstance().getConfig().getString("coordinates.hub.pitch"));

    private final Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    public static final Map<UUID, FastBoard> boards = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FastBoard board = new FastBoard(player);
        Date date = new Date(player.getFirstPlayed());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String firstplayed = sdf.format(date);
        String profileLoadedMessage = VibeHub.getInstance().getConfig().getString("messages.ProfileLoadedMessage");
        String profileCreatedMessage = VibeHub.getInstance().getConfig().getString("messages.ProfileCreatedMessage");
        User user = VibeHub.luckperms.getUserManager().getUser(player.getUniqueId());
        //String ClearInventoryBypassPermission = VibeHub.getInstance().getConfig().getString("ClearInventoryBypassPermission");
        //Add potion effect, set gamemode, don't let the player take damage, set the health and saturation to 20, clear the inventory then give the player the server selector & speed item.
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        player.setGameMode(GameMode.ADVENTURE);
        player.setInvulnerable(true);
        player.setCollidable(false);
        player.setSaturation(20);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.getInventory().clear();
        player.getInventory().setItem(4, ItemList.SERVER_SELECTOR);
        player.getInventory().setItem(8, ItemList.SPEED_ITEM);
        player.getInventory().setItem(0, ItemList.TIME_SELECTOR);
        player.getInventory().setItem(7, ItemList.ENDERPEARL);
        player.getInventory().getItem(7).setAmount(16);
        player.getInventory().setHeldItemSlot(4);
        player.updateInventory();

        //Scoreboard creation
        board.updateTitle(ColorUtils.color("&9&lVibe &8| &7Hub"));
        board.updateLines(
                " ",
                ChatColor.GRAY + "Name: " + ChatColor.WHITE + player.getName(),
                ChatColor.GRAY + "Rank: " + ChatColor.WHITE + ColorUtils.color(user.getCachedData().getMetaData().getPrefix()),
                ChatColor.GRAY + "Ping: " + ChatColor.WHITE + player.getPing() + "ms",
                ChatColor.GRAY + "Joined: " + ChatColor.WHITE + firstplayed,
                " ",
                ColorUtils.color("&9&lvibemarket.org")
        );
        boards.put(player.getUniqueId(), board);

        if (player.hasPlayedBefore()) {
            profileLoadedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), profileLoadedMessage);
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + profileLoadedMessage));
        } else {
            profileCreatedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), profileCreatedMessage);
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + profileCreatedMessage));
        }
        //Teleport the player to the hub on join
        player.teleport(loc);
        //Allow the player to fly
        player.setAllowFlight(true);

    }
}
