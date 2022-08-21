package me.kevind.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemList {
    public static final ItemStack SERVER_SELECTOR = new ItemMaker(Material.NETHER_STAR).name("&a&lServer Selector &7(Right Click)").lore("Teleport to the other servers!").build();
    public static final ItemStack SURVIVAL_SERVER = new ItemMaker(Material.GRASS_BLOCK).name("&a&lSurvival").lore("&7Teleport to the survival server").build();
    public static final ItemStack CREATIVE_SERVER = new ItemMaker(Material.BIRCH_WOOD).name("&6&lCreative").lore("&7Teleport to the creative server").build();
    public static final ItemStack SKYBLOCK_SERVER = new ItemMaker(Material.OAK_WOOD).name("&b&lSkyblock").lore("&7Teleport to the skyblock server").build();
}
