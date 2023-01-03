package me.kevind.inventory.cosmetics;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class ParticlesGUI {
    private final Inventory inv;
    public ParticlesGUI() {
        inv = Bukkit.createInventory(null, 27, "Particles");
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_BLUE_GLASS);
        }
        for (int i = 9; i < 18; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_GLASS);
        }
        for (int i = 18; i < 27; i++) {
            inv.setItem(i, ItemList.PLACEHOLDER_BLUE_GLASS);
        }
        inv.setItem(9, ItemList.TEST_PARTICLE);
    }
    public Inventory getInv() {
        return inv;
    }
}
