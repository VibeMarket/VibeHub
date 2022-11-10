package me.kevind.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemList {
    public static final ItemStack SERVER_SELECTOR = new ItemMaker(Material.NETHER_STAR).name("&a&lServer Selector &7(Right Click)").lore("&7Teleport to the other servers!").build();
    public static final ItemStack SURVIVAL_SERVER = new ItemMaker(Material.GRASS_BLOCK).name("&a&lSurvival").lore("&7Teleport to the survival server").build();
    public static final ItemStack CREATIVE_SERVER = new ItemMaker(Material.BIRCH_WOOD).name("&6&lCreative").lore("&7Teleport to the creative server").build();
    public static final ItemStack SKYBLOCK_SERVER = new ItemMaker(Material.OAK_WOOD).name("&b&lSkyblock").lore("&7Teleport to the skyblock server").build();
    public static final ItemStack SPEED_ITEM = new ItemMaker(Material.BLAZE_ROD).name("&c&lSpeed Selector &7(Right Click)").lore("&7Set your speed!").build();
    public static final ItemStack SPEED_3 = new ItemMaker(Material.BLAZE_ROD).name("&c&lSpeed 3").lore("&7Give yourself Speed 3").build();
    public static final ItemStack SPEED_6 = new ItemMaker(Material.BLAZE_ROD).name("&c&lSpeed 6").lore("&7Give yourself Speed 6").build();
    public static final ItemStack SPEED_9 = new ItemMaker(Material.BLAZE_ROD).name("&c&lSpeed 9").lore("&7Give yourself Speed 9").build();
    public static final ItemStack NO_SPEED = new ItemMaker(Material.BARRIER).name("&c&lDisable Speed").lore("&7Disable speed").build();
    public static final ItemStack ENDERBUTT = new ItemMaker(Material.ENDER_PEARL).name("&cEnderbutt &7(Right Click)").lore("Throw me to teleport!!").build();
    public static final ItemStack BUILD_SERVER = new ItemMaker(Material.COMMAND_BLOCK).name("&c&lBuild").lore("&7Staff only... sorry :)\n&cNot yet ready.").build();
    public static final ItemStack TIME_SELECTOR = new ItemMaker(Material.CLOCK).name("&e&lTime Selector &7(Right Click)").lore("&7Set your personal time.").build();
    public static final ItemStack PLACEHOLDER_PURPLE_GLASS = new ItemMaker(Material.PURPLE_STAINED_GLASS_PANE).name(" ").build();
    public static final ItemStack PLACEHOLDER_GLASS = new ItemMaker(Material.GRAY_STAINED_GLASS_PANE).name(" ").build();
    public static final ItemStack DAY_TIME = new ItemMaker(Material.CLOCK).name("&eDay").lore("&7Sets your time to day").build();
    public static final ItemStack NIGHT_TIME = new ItemMaker(Material.CLOCK).name("&8Night").build();
}
