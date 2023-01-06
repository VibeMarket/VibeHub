package me.kevind.listeners.inventory;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.kevind.cosmetics.armor.*;
import me.kevind.cosmetics.particles.Flame;
import me.kevind.VibeHub;
import me.kevind.utils.ArmorUtils;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.ItemList;
import me.kevind.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class InventoryClickListener implements Listener {

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
                else if (e.getCurrentItem().isSimilar(ItemList.LIMBO_SERVER))
                    out.writeUTF("limbo");
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
            //cosmetics main gui
            if (e.getClickedInventory().equals(VibeHub.getCosmetics().getInv())) {
                if (e.getCurrentItem().isSimilar(ItemList.ARMORS)) {
                    player.openInventory(VibeHub.getArmorsGUI().getInv());
                }
                if (e.getCurrentItem().isSimilar(ItemList.PARTICLES)) {
                    player.openInventory(VibeHub.getParticlesGUI().getInv());
                }
                e.setCancelled(true);
            }
            //cosmetics armor gui
            if (e.getClickedInventory().equals(VibeHub.getArmorsGUI().getInv())) {
                if (e.getCurrentItem().isSimilar(ItemList.RAINBOW_ARMOR)) {
                    if (e.isLeftClick()) {
                        player.getInventory().setHelmet(Rainbow.createRainbowHelmet());
                        player.getInventory().setChestplate(Rainbow.createRainbowChestplate());
                        player.getInventory().setLeggings(Rainbow.createRainbowLeggings());
                        player.getInventory().setBoots(Rainbow.createRainbowBoots());
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Equipped &c&l&oR&6&l&oa&e&l&oi&a&l&on&3&l&ob&9&l&oo&5&l&ow &6&l&oA&e&l&or&a&l&om&3&l&oo&9&l&or");
                    } else if (e.isRightClick()) {
                        ArmorUtils.clearArmor(player);
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Cleared your armor slots!");
                    }
                }
                if (e.getCurrentItem().isSimilar(ItemList.STRAIGHT_ARMOR)) {
                    if (e.isLeftClick()) {
                        player.getInventory().setHelmet(Straight.createStraightHelmet());
                        player.getInventory().setChestplate(Straight.createStraightChestplate());
                        player.getInventory().setLeggings(Straight.createStraightLeggings());
                        player.getInventory().setBoots(Straight.createStraightBoots());
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Equipped &fStraight &7armor");
                    } else if (e.isRightClick()) {
                        ArmorUtils.clearArmor(player);
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Cleared your armor slots!");
                    }
                }
                if (e.getCurrentItem().isSimilar(ItemList.BI_ARMOR)) {
                    if (e.isLeftClick()) {
                        player.getInventory().setHelmet(Bisexual.createBiHelmet());
                        player.getInventory().setChestplate(Bisexual.createBiChesplate());
                        player.getInventory().setLeggings(Bisexual.createBiLeggings());
                        player.getInventory().setBoots(Bisexual.createBiBoots());
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Equipped &dBi&5sex&9ual &7armor");
                    } else if (e.isRightClick()) {
                        ArmorUtils.clearArmor(player);
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Cleared your armor slots!");
                    }
                }
                    if (e.getCurrentItem().isSimilar(ItemList.PAN_ARMOR)) {
                        if (e.isLeftClick()) {
                            player.getInventory().setHelmet(Pansexual.createPanHelmet());
                            player.getInventory().setChestplate(Pansexual.createPanChesplate());
                            player.getInventory().setLeggings(Pansexual.createPanLeggings());
                            player.getInventory().setBoots(Pansexual.createPanBoots());
                            MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Equipped &dPan&esex&bual &7armor");
                        } else if (e.isRightClick()) {
                            ArmorUtils.clearArmor(player);
                            MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Cleared your armor slots!");
                        }
                    }
                if (e.getCurrentItem().isSimilar(ItemList.Asexual_Armor)) {
                    if (e.isLeftClick()) {
                        player.getInventory().setHelmet(Asexual.createAsexualHelmet());
                        player.getInventory().setChestplate(Asexual.createAsexualChesplate());
                        player.getInventory().setLeggings(Asexual.createAsexualLeggings());
                        player.getInventory().setBoots(Asexual.createAsexualBoots());
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Equipped &0As&7ex&fua&5l &7armor");
                    } else if (e.isRightClick()) {
                        ArmorUtils.clearArmor(player);
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Cleared your armor slots!");
                    }
                }
                if (e.getCurrentItem().isSimilar(ItemList.LESBIAN_ARMOR)) {
                    if (e.isLeftClick()) {
                        player.getInventory().setHelmet(Lesbian.createLesbianHelmet());
                        player.getInventory().setChestplate(Lesbian.createLesbianChesplate());
                        player.getInventory().setLeggings(Lesbian.createLesbianLeggings());
                        player.getInventory().setBoots(Lesbian.createLesbianBoots());
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Equipped &6Les&fb&cian &7armor");
                    } else if (e.isRightClick()) {
                        ArmorUtils.clearArmor(player);
                        MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Cleared your armor slots!");
                    }
                }

                        if (e.getCurrentItem().isSimilar(ItemList.GO_BACK)) {
                            player.openInventory(VibeHub.getCosmetics().getInv());
                        }
                        e.setCancelled(true);
                    //cosmetics particles gui
                    if (e.getClickedInventory().equals(VibeHub.getParticlesGUI().getInv())) {
                        if (e.getCurrentItem().isSimilar(ItemList.GO_BACK)) {
                            player.openInventory(VibeHub.getCosmetics().getInv());
                        }
                        if (e.getCurrentItem().isSimilar(ItemList.FLAME_PARTICLE)) {
                            if (e.isLeftClick()) {
                                Flame.createParticle(player);
                                MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Equipped &c&lFlame &7particle");
                            }
                            if (e.isRightClick()) {
                                Flame.removeParticle(player);
                                MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Cleared particles.");
                            }
                        }
                        e.setCancelled(true);
                    }
            }
        }
    }
}
