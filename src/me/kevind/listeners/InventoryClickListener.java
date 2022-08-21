package me.kevind.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.kevind.main.VibeHub;
import me.kevind.utils.ItemList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();
            e.setCancelled(true);

            if (e.getClickedInventory().equals(VibeHub.getSelectorGUI().getInv())) {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");

                if (e.getCurrentItem().isSimilar(ItemList.SURVIVAL_SERVER))
                    out.writeUTF("survival");
                else if (e.getCurrentItem().isSimilar(ItemList.CREATIVE_SERVER))
                    out.writeUTF("creative");
                else if (e.getCurrentItem().isSimilar(ItemList.SKYBLOCK_SERVER))
                    out.writeUTF("skyblock");

                player.sendPluginMessage(VibeHub.getInstance(), "BungeeCord", out.toByteArray());
            }
        }
    }
}
