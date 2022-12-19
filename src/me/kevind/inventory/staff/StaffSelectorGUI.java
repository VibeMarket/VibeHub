package me.kevind.inventory.staff;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class StaffSelectorGUI {
    private final Inventory inv;

    public StaffSelectorGUI() {
        inv = Bukkit.createInventory(null, 27, "Server Selector");
        inv.setItem(12, ItemList.SURVIVAL_SERVER);
        inv.setItem(13, ItemList.SKYBLOCK_SERVER);
        inv.setItem(14, ItemList.CREATIVE_SERVER);
        inv.setItem(8, ItemList.DEVELOPMENT_SERVER);
        inv.setItem(26, ItemList.BUILD_SERVER);
    }

    public Inventory getInv() {
        return inv;
    }
}
