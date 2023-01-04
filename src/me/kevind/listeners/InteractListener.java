package me.kevind.listeners;

import me.kevind.main.VibeHub;
import me.kevind.utils.ItemList;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.PHYSICAL))
            return;
        if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemList.SERVER_SELECTOR)) {
            e.setCancelled(true);
            e.getPlayer().openInventory(VibeHub.getSelectorGUI().getInv());
        }
        if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemList.SPEED_ITEM)) {
            e.setCancelled(true);
            e.getPlayer().openInventory(VibeHub.getSpeedGUI().getInv());
        }
    }
}
