package me.kevind.listeners.inventory;

import me.kevind.main.VibeHub;
import me.kevind.utils.ItemList;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Action action = e.getAction();
        if (e.getAction().equals(Action.PHYSICAL))
            return;
        if (!e.getPlayer().hasPermission("vibe.staff") && e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemList.SERVER_SELECTOR)) {
            e.setCancelled(true);
            e.getPlayer().openInventory(VibeHub.getSelectorGUI().getInv());
        }else if(e.getPlayer().hasPermission("vibe.staff") && e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemList.SERVER_SELECTOR)) {
            e.setCancelled(true);
            e.getPlayer().openInventory(VibeHub.getStaffselector().getInv());
        }
        if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemList.SPEED_ITEM)) {
            e.setCancelled(true);
            e.getPlayer().openInventory(VibeHub.getSpeedGUI().getInv());
        }
        if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(ItemList.TIME_SELECTOR)) {
            e.setCancelled(true);
            e.getPlayer().openInventory(VibeHub.getTimeGUI().getInv());
        }
        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            e.getPlayer().getInventory().getItem(7).setAmount(16);
        }
    }
}
