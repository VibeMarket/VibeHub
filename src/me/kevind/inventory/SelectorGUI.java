package me.kevind.inventory;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class SelectorGUI {
    private final Inventory inv;

    public SelectorGUI() {
        inv = Bukkit.createInventory(null, 27, "Server Selector");
        inv.setItem(12, ItemList.SURVIVAL_SERVER);
        inv.setItem(13, ItemList.SKYBLOCK_SERVER);
        inv.setItem(14, ItemList.CREATIVE_SERVER);
    }

    public Inventory getInv() {
        return inv;
    }
}
