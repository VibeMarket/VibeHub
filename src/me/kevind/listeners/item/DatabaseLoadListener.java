package me.kevind.listeners.item;

import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import me.kevind.VibeHub;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class DatabaseLoadListener implements Listener {
    @EventHandler
    public void onDBLoad(DatabaseLoadEvent e) {
        HeadDatabaseAPI api = new HeadDatabaseAPI();
        try {
            ItemStack item = api.getItemHead("7129");
            VibeHub.getInstance().getLogger().info(api.getItemID(item));
        } catch (NullPointerException nullPointerException) {
            VibeHub.getInstance().getLogger().info("Could not find the head you were looking for");
        }
    }
}
