package me.kevind.listeners.inventory;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.ItemList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player player) {

            if (e.getClickedInventory() == null) {
                return;
            }

            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }

            if (e.getClickedInventory().equals(VibeHub.getSelectorGUI().getInv()) || e.getClickedInventory().equals(VibeHub.getStaffselector().getInv())) {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");

                if (e.getCurrentItem().isSimilar(ItemList.SURVIVAL_SERVER))
                    out.writeUTF("survival");
                else if (e.getCurrentItem().isSimilar(ItemList.CREATIVE_SERVER))
                    out.writeUTF("creative");
                else if (e.getCurrentItem().isSimilar(ItemList.SKYBLOCK_SERVER))
                    out.writeUTF("skyblock");
                else if (e.getCurrentItem().isSimilar(ItemList.BUILD_SERVER))
                    out.writeUTF("staff");
                else if (e.getCurrentItem().isSimilar(ItemList.DEVELOPMENT_SERVER))
                    out.writeUTF("dev");
                e.setCancelled(true);
                player.sendPluginMessage(VibeHub.getInstance(), "BungeeCord", out.toByteArray());
            }
            if (e.getClickedInventory().equals(VibeHub.getSpeedGUI().getInv())) {
                if (e.getCurrentItem().isSimilar(ItemList.SPEED_3)) {
                    for (PotionEffect effect : player.getActivePotionEffects())
                        player.removePotionEffect(effect.getType());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
                    player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&aYou've been given Speed 3"));
                }
                if (e.getCurrentItem().isSimilar(ItemList.SPEED_6)) {
                    for (PotionEffect effect : player.getActivePotionEffects())
                        player.removePotionEffect(effect.getType());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 5));
                    player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&aYou've been given Speed 6"));
                }
                if (e.getCurrentItem().isSimilar(ItemList.SPEED_9)) {
                    for (PotionEffect effect : player.getActivePotionEffects())
                        player.removePotionEffect(effect.getType());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 8));
                    player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&aYou've been given Speed 9"));
                }
                if (e.getCurrentItem().isSimilar(ItemList.NO_SPEED)) {
                    for (PotionEffect effect : player.getActivePotionEffects())
                        player.removePotionEffect(effect.getType());
                    player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&cDisabled speed"));
                }
                e.setCancelled(true);
            }
            if (e.getClickedInventory().equals(VibeHub.getTimeGUI().getInv())) {
                if (e.getCurrentItem().isSimilar(ItemList.DAY_TIME)) {
                    player.setPlayerTime(6000, true);
                    player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Set your time to &eDay&7."));
                }
                if (e.getCurrentItem().isSimilar(ItemList.NIGHT_TIME)) {
                    player.setPlayerTime(14000, true);
                    player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Set your time to &8Night&7."));
                }
                e.setCancelled(true);
            }
        }
    }
}
