package me.kevind.vibehub.inventory.item.selector.survival;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public final class SurvivalSelectorGUI {

    private final Inventory inv;

    public SurvivalSelectorGUI() {
        inv = Bukkit.createInventory(null, 27, "Server Selector");
        //future expansion
    }

    public Inventory getInv() {
        return inv;
    }
}
