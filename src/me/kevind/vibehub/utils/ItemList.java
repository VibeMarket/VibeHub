package me.kevind.vibehub.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public final class ItemList {

    private static final String survivalversion = ConfigUtils.get(String.class, "versions.survival");
    private static final String skyblockversion = ConfigUtils.get(String.class, "versions.skyblock");
    private static final String creativeversion = ConfigUtils.get(String.class, "versions.creative");
    private static final String staffversion = ConfigUtils.get(String.class, "versions.build");
    private static final String devversion = ConfigUtils.get(String.class, "versions.dev");
    private static final String limboversion = ConfigUtils.get(String.class, "versions.limbo");

    //Servers
    public static final ItemStack SERVER_SELECTOR = new ItemMaker(Material.NETHER_STAR).name("&a&lServer Selector &7(Right Click)").lore("&7Teleport to the other servers!").build();

    // Items & Clickable things
    public static final ItemStack SPEED_ITEM = new ItemMaker(Material.SUGAR).name("&c&lSpeed Selector &7(Right Click)").lore("&7Set your speed!").build();
    public static final ItemStack SPEED_3 = new ItemMaker(Material.SUGAR).name("&c&lSpeed 3").lore("&7Give yourself Speed 3").build();
    public static final ItemStack SPEED_6 = new ItemMaker(Material.SUGAR).name("&c&lSpeed 6").lore("&7Give yourself Speed 6").build();
    public static final ItemStack SPEED_9 = new ItemMaker(Material.SUGAR).name("&c&lSpeed 9").lore("&7Give yourself Speed 9").build();
    public static final ItemStack NO_SPEED = new ItemMaker(Material.BARRIER).name("&c&lDisable Speed").lore("&7Disable speed").build();
    public static final ItemStack ENDERPEARL = new ItemMaker(Material.ENDER_PEARL).name("&d&lEnderpearl &7(Right Click)").lore("&7Throw me to ride!").build();
    public static final ItemStack TIME_SELECTOR = new ItemMaker(Material.CLOCK).name("&e&lTime Selector &7(Right Click)").lore("&7Set your personal time.").build();
    public static final ItemStack PLACEHOLDER_BLUE_GLASS = new ItemMaker(Material.BLUE_STAINED_GLASS_PANE).name(" ").build();
    public static final ItemStack PLACEHOLDER_GLASS = new ItemMaker(Material.GRAY_STAINED_GLASS_PANE).name(" ").build();
    public static final ItemStack DAY_TIME = new ItemMaker(Material.CLOCK).name("&eDay").lore("&7Sets your time to day").build();
    public static final ItemStack NIGHT_TIME = new ItemMaker(Material.CLOCK).name("&8Night").build();
    public static final ItemStack COSMETICS_ITEM = new ItemMaker(Material.CHEST).name("&6&lCosmetics &7(Right Click)").lore("&7Click to open the Cosmetics menu!").build();
    public static final ItemStack ARMORS = new ItemMaker(Material.LEATHER_HELMET).name("&9&lArmors").lore("&7Click to go to the armors section").build();
    public static final ItemStack PARTICLES = new ItemMaker(Material.NETHER_STAR).name("&f&lParticles &7(Right Click)").lore("&7Click to go to the particles section").build();
    public static final ItemStack RAINBOW_ARMOR = new ItemMaker(Material.RED_WOOL).name("&c&l&oR&6&l&oa&e&l&oi&a&l&on&3&l&ob&9&l&oo&5&l&ow &6&l&oA&e&l&or&a&l&om&3&l&oo&9&l&or").lore("&7Left click to equip", "&7Right click to unequip").build();
    public static final ItemStack STRAIGHT_ARMOR = new ItemMaker(Material.BLACK_WOOL).name("&fStra&0ight &7Armor").lore("&7Left click to equip", "&7Right click to unequip").build();
    public static final ItemStack BI_ARMOR = new ItemMaker(Material.PURPLE_WOOL).name("&dBi&5sex&9ual &7Armor").lore("&7Left click to equip", "&7Right click to unequip").build();
    public static final ItemStack PAN_ARMOR = new ItemMaker(Material.YELLOW_WOOL).name("&dPan&esex&bual &7Armor").lore("&7Left click to equip", "&7Right click to unequip").build();
    public static final ItemStack ASEXUAL_ARMOR = new ItemMaker(Material.LIGHT_GRAY_WOOL).name("&0As&7ex&fua&5l &7Armor").lore("&7Left click to equip", "&7Right click to unequip").build();
    public static final ItemStack LESBIAN_ARMOR = new ItemMaker(Material.ORANGE_WOOL).name("&6Les&fb&cian &7Armor").lore("&7Left click to equip", "&7Right click to unequip").build();
    public static final ItemStack GO_BACK = new ItemMaker(Material.BARRIER).name("&c&lGo back").lore("&7Click to go back!").build();
    public static final ItemStack CLOSE_MENU = new ItemMaker(Material.BARRIER).name("&c&lClose menu").build();
    public static final ItemStack FLAME_PARTICLE = new ItemMaker(Material.FIRE_CHARGE).name("&c&lFlame Particle &7(Right Click)").lore("&7Left click to spawn.", "&7Right click to remove.").build();
    public static final ItemStack SURVIVAL_SERVER = new ItemMaker(Material.GRASS_BLOCK).name("&a&lSurvival").lore("&7Version: &9" + survivalversion, "&7Teleport to the survival server").build();
    public static final ItemStack SKYBLOCK_SERVER = new ItemMaker(Material.OAK_WOOD).name("&b&lSkyblock").lore("&7Version: &9" + skyblockversion, "&7Teleport to the skyblock server").build();
    public static final ItemStack CREATIVE_SERVER = new ItemMaker(Material.BIRCH_WOOD).name("&6&lCreative").lore("&7Version: &9" + creativeversion, "&7Teleport to the creative server").build();
    public static final ItemStack BUILD_SERVER = new ItemMaker(Material.DIAMOND_PICKAXE).name("&c&lBuild").lore("&7Version: &9" + staffversion, "&7Teleport to the Build server.", "&7You are staff so you can see this server.").flags(ItemFlag.HIDE_ATTRIBUTES).build();
    public static final ItemStack DEVELOPMENT_SERVER = new ItemMaker(Material.COMMAND_BLOCK).name("&d&lDevelopment").lore("&7Version: &9" + devversion).build();
    public static final ItemStack LIMBO_SERVER = new ItemMaker(Material.WOODEN_AXE).name("&e&lLimbo").lore("&7Version: &9" + limboversion, "&7If Vibe is under maintenance, this is where players get sent.", "&7Click to teleport to the Limbo server.").flags(ItemFlag.HIDE_ATTRIBUTES).build();

}