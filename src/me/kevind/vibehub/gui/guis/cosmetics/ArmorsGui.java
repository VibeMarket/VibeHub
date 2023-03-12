package me.kevind.vibehub.gui.guis.cosmetics;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.gui.guis.CosmeticsGui;
import me.kevind.vibehub.gui.guis.staff.StaffCosmeticsGui;
import me.kevind.vibehub.utils.ArmorType;
import me.kevind.vibehub.utils.ArmorUtils;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.inventory.PlayerInventory;

public final class ArmorsGui extends Gui {

    public ArmorsGui() {
        super(1, "Armors");

        setItem(1, 1, ItemList.RAINBOW_ARMOR, (player, click) -> {
            PlayerInventory inventory = player.getInventory();

            if (click.isLeftClick()) {
                inventory.setHelmet(ArmorUtils.leather(ArmorType.HELMET, 255, 0, 0));
                inventory.setChestplate(ArmorUtils.leather(ArmorType.CHESTPLATE, 255, 127, 0));
                inventory.setLeggings(ArmorUtils.leather(ArmorType.LEGGINGS, 255, 255, 0));
                inventory.setBoots(ArmorUtils.leather(ArmorType.BOOTS, 0, 255, 0));

                MessageUtils.message(player, "&7Equipped &c&l&oR&6&l&oa&e&l&oi&a&l&on&3&l&ob&9&l&oo&5&l&ow &6&l&oA&e&l&or&a&l&om&3&l&oo&9&l&or");
            } else if (click.isRightClick()) {
                inventory.setArmorContents(null);

                MessageUtils.message(player, "&7Cleared your armor slots!");
            }
        });
        setItem(1, 2, ItemList.STRAIGHT_ARMOR, (player, click) -> {
            PlayerInventory inventory = player.getInventory();

            if (click.isLeftClick()) {
                inventory.setHelmet(ArmorUtils.leather(ArmorType.HELMET, 0, 0, 0));
                inventory.setChestplate(ArmorUtils.leather(ArmorType.CHESTPLATE, 255, 255, 255));
                inventory.setLeggings(ArmorUtils.leather(ArmorType.LEGGINGS, 0, 0, 0));
                inventory.setBoots(ArmorUtils.leather(ArmorType.BOOTS, 255, 255, 255));

                MessageUtils.message(player, "&7Equipped &fStra&0ight &7armor");
            } else if (click.isRightClick()) {
                inventory.setArmorContents(null);

                MessageUtils.message(player, "&7Cleared your armor slots!");
            }
        });
        setItem(1, 3, ItemList.BI_ARMOR, (player, click) -> {
            PlayerInventory inventory = player.getInventory();

            if (click.isLeftClick()) {
                inventory.setHelmet(ArmorUtils.leather(ArmorType.HELMET, 255, 0, 255));
                inventory.setChestplate(ArmorUtils.leather(ArmorType.CHESTPLATE, 150, 123, 182));
                inventory.setLeggings(ArmorUtils.leather(ArmorType.LEGGINGS, 25, 41, 88));
                inventory.setBoots(ArmorUtils.leather(ArmorType.BOOTS, 255, 0, 255));

                MessageUtils.message(player, "&7Equipped &dBi&5sex&9ual &7armor");
            } else if (click.isRightClick()) {
                inventory.setArmorContents(null);

                MessageUtils.message(player, "&7Cleared your armor slots!");
            }
        });
        setItem(1, 4, ItemList.PAN_ARMOR, (player, click) -> {
            PlayerInventory inventory = player.getInventory();

            if (click.isLeftClick()) {
                inventory.setHelmet(ArmorUtils.leather(ArmorType.HELMET, 255, 33, 140));
                inventory.setChestplate(ArmorUtils.leather(ArmorType.CHESTPLATE, 255, 216, 0));
                inventory.setLeggings(ArmorUtils.leather(ArmorType.LEGGINGS, 33, 177, 255));
                inventory.setBoots(ArmorUtils.leather(ArmorType.BOOTS, 255, 33, 140));

                MessageUtils.message(player, "&7Equipped &dPan&esex&bual &7armor");
            } else if (click.isRightClick()) {
                inventory.setArmorContents(null);

                MessageUtils.message(player, "&7Cleared your armor slots!");
            }
        });
        setItem(1, 5, ItemList.ASEXUAL_ARMOR, (player, click) -> {
            PlayerInventory inventory = player.getInventory();

            if (click.isLeftClick()) {
                inventory.setHelmet(ArmorUtils.leather(ArmorType.HELMET, 0, 0, 0));
                inventory.setChestplate(ArmorUtils.leather(ArmorType.CHESTPLATE, 163, 163, 163));
                inventory.setLeggings(ArmorUtils.leather(ArmorType.LEGGINGS, 255, 255, 255));
                inventory.setBoots(ArmorUtils.leather(ArmorType.BOOTS, 128, 0, 128));

                MessageUtils.message(player, "&7Equipped &0As&7ex&fua&5l &7armor");
            } else if (click.isRightClick()) {
                inventory.setArmorContents(null);

                MessageUtils.message(player, "&7Cleared your armor slots!");
            }
        });
        setItem(1, 6, ItemList.LESBIAN_ARMOR, (player, click) -> {
            PlayerInventory inventory = player.getInventory();

            if (click.isLeftClick()) {
                inventory.setHelmet(ArmorUtils.leather(ArmorType.HELMET, 213, 45, 0));
                inventory.setChestplate(ArmorUtils.leather(ArmorType.CHESTPLATE, 239, 118, 39));
                inventory.setLeggings(ArmorUtils.leather(ArmorType.LEGGINGS, 255, 154, 86));
                inventory.setBoots(ArmorUtils.leather(ArmorType.BOOTS, 209, 98, 164));

                MessageUtils.message(player, "&7Equipped &6Les&fb&cian &7armor");
            } else if (click.isRightClick()) {
                inventory.setArmorContents(null);

                MessageUtils.message(player, "&7Cleared your armor slots!");
            }
        });
        setItem(1, 9, ItemList.GO_BACK, (player, click) -> {
            if (player.hasPermission("vibe.staff"))
                player.openInventory(Gui.get(StaffCosmeticsGui.class));
            else
                player.openInventory(Gui.get(CosmeticsGui.class));
        });

        fillRemaining();
    }

}
