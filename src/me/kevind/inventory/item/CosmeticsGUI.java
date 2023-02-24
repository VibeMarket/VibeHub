package me.kevind.inventory.item;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public final class CosmeticsGUI {
    private final Inventory inv;

    public CosmeticsGUI() {
        inv = Bukkit.createInventory(null, 27, "Cosmetics");
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_BLUE_GLASS);
        }
        for (int i = 9; i < 18; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_GLASS);
        }
        for (int i = 18; i < 27; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_BLUE_GLASS);
        }
        inv.setItem(13, ItemList.ARMORS);
        //inv.setItem(9, ItemList.PARTICLES);
        inv.setItem(17, ItemList.CLOSE_MENU);
    }

    public Inventory getInv() {
        return inv;
    }

}
