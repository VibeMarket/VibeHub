package me.kevind.vibehub.listeners.player;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.gui.guis.CosmeticsGui;
import me.kevind.vibehub.gui.guis.SelectorGui;
import me.kevind.vibehub.gui.guis.SpeedGui;
import me.kevind.vibehub.gui.guis.TimeGui;
import me.kevind.vibehub.gui.guis.staff.StaffCosmeticsGui;
import me.kevind.vibehub.gui.guis.staff.StaffSelectorGui;
import me.kevind.vibehub.utils.ItemList;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public final class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack main = inventory.getItemInMainHand();
        boolean staff = player.hasPermission("vibe.staff");

        if (main.isSimilar(ItemList.TIME_SELECTOR)) {
            event.setCancelled(true);
            player.openInventory(Gui.get(TimeGui.class));
        }

        if (main.isSimilar(ItemList.COSMETICS_SELECTOR)) {
            event.setCancelled(true);

            if (staff)
                player.openInventory(Gui.get(StaffCosmeticsGui.class));
            else
                player.openInventory(Gui.get(CosmeticsGui.class));
        }

        if (main.isSimilar(ItemList.SERVER_SELECTOR)) {
            event.setCancelled(true);

            if (staff)
                player.openInventory(Gui.get(StaffSelectorGui.class));
            else
                player.openInventory(Gui.get(SelectorGui.class));
        }

        if (main.isSimilar(ItemList.ENDERPEARL)) {
            event.setCancelled(true);
            player.launchProjectile(EnderPearl.class);
        }

        if (main.isSimilar(ItemList.SPEED_SELECTOR)) {
            event.setCancelled(true);
            player.openInventory(Gui.get(SpeedGui.class));
        }
    }

}
