package me.kevind.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class CosmeticsGUI{
    private final Inventory inv;
    public CosmeticsGUI() {
        inv = Bukkit.createInventory(null, 27, "Cosmetics");
    }
    public Inventory getInv() {return inv;};
}
