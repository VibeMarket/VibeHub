package me.kevind.vibehub.gui;

import me.kevind.vibehub.VibeHub;
import me.kevind.vibehub.utils.ItemMaker;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class Gui implements Listener {

    private static final Map<Class<? extends Gui>, Gui> guis = new HashMap<>();
    private final Map<ItemStack, Action> actionMap = new HashMap<>();
    private final Inventory inventory;

    public Gui(int rows, String name) {
        inventory = Bukkit.createInventory(null, rows * 9, name);

        Bukkit.getPluginManager().registerEvents(this, VibeHub.getInstance());

        guis.put(getClass(), this);
    }

    public static Gui get(Class<? extends Gui> clazz) {
        return guis.get(clazz);
    }

    protected void setItem(int row, int column, ItemStack item, Action action) {
        int slot = 9 * (row - 1) + (column - 1);

        inventory.setItem(slot, item);
        actionMap.put(item, action);
    }

    protected void fillRemaining() {
        for (int i = 0; i < inventory.getSize(); i++)
            if (inventory.getItem(i) == null)
                inventory.setItem(i, new ItemMaker(Material.GRAY_STAINED_GLASS_PANE).name(" ").build());
    }

    public Inventory getInventory() {
        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!inventory.equals(event.getClickedInventory()))
            return;

        event.setCancelled(true);

        ItemStack item = event.getCurrentItem();

        if (item == null)
            return;

        if (event.getWhoClicked() instanceof Player player && actionMap.containsKey(item))
            actionMap.get(item).run(player, event.getClick());
    }

}
