package me.kevind.inventory.item.selector.survival;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class SurvivalSelectorGUI {

    private final Inventory inv;

    public SurvivalSelectorGUI() {
        inv = Bukkit.createInventory(null, 27, "Server Selector");
        //future expansion
    }

    public Inventory getInv() {
        return inv;
    }
}
