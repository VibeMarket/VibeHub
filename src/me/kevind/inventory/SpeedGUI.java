package me.kevind.inventory;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class SpeedGUI {
    private final Inventory inv;

    public SpeedGUI() {
        inv = Bukkit.createInventory(null, 9, "Set Speed");
        inv.setItem(0, ItemList.SPEED_3);
        inv.setItem(1, ItemList.SPEED_6);
        inv.setItem(2, ItemList.SPEED_9);
        inv.setItem(8, ItemList.NO_SPEED);
    }

    public Inventory getInv() {
        return inv;
    }
}
