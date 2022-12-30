package me.kevind.inventory;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public final class TimeGUI {
    private final Inventory inv;

    public TimeGUI() {
        inv = Bukkit.createInventory(null, 9, "Time Selector");
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_GLASS);
        }
        inv.setItem(3, ItemList.DAY_TIME);
        inv.setItem(5, ItemList.NIGHT_TIME);
    }

    public Inventory getInv() {
        return inv;
    }
}
