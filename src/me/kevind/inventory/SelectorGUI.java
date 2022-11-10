package me.kevind.inventory;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SelectorGUI {
    private Inventory inv;

    public SelectorGUI() {
        inv = Bukkit.createInventory(null, 27, "Server Selector");
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_PURPLE_GLASS);
        }
        for (int i = 9; i < 18; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_GLASS);
        }
        for (int i = 18; i < 27; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_PURPLE_GLASS);
        }
        inv.setItem(12, ItemList.SURVIVAL_SERVER);
        inv.setItem(13, ItemList.SKYBLOCK_SERVER);
        inv.setItem(14, ItemList.CREATIVE_SERVER);
        inv.setItem(26, ItemList.BUILD_SERVER);
    }

    public Inventory getInv() {
        return inv;
    }
}
