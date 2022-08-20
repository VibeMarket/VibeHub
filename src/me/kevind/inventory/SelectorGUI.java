package me.kevind.inventory;

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
        inv = Bukkit.createInventory(null, 9, "Server Selector");
        inv.setItem(0, createGuiItem(Material.GRASS_BLOCK, "Test", "weeee"));
        inv.setItem(4, createGuiItem(Material.OAK_WOOD, "Testing2", "weeee"));
        inv.setItem(9, createGuiItem(Material.BIRCH_WOOD, "Testing3", "weeee"));
    }

    public Inventory getInv() {
        return inv;
    }

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
}
