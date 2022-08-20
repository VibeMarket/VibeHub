package me.kevind.inventory;

import me.kevind.utils.ItemList;
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
        inv.setItem(0, ItemList.SURVIVAL_SERVER);
        inv.setItem(4, ItemList.SKYBLOCK_SERVER);
        inv.setItem(8, ItemList.CREATIVE_SERVER);
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
