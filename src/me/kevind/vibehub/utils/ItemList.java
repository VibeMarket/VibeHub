package me.kevind.vibehub.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public final class ItemList {

    // Hotbar items
    public static ItemStack TIME_SELECTOR;
    public static ItemStack COSMETICS_SELECTOR;
    public static ItemStack SERVER_SELECTOR;
    public static ItemStack ENDERPEARL;
    public static ItemStack SPEED_SELECTOR;

    // General Gui items
    public static ItemStack CLOSE_MENU;
    public static ItemStack GO_BACK;

    // Time Gui items
    public static ItemStack DAY_TIME;
    public static ItemStack NIGHT_TIME;

    // Cosmetics Gui items
    public static ItemStack PARTICLES;
    public static ItemStack ARMORS;

    // Particles Gui items
    public static ItemStack FLAME_PARTICLE;

    // Armors Gui items
    public static ItemStack RAINBOW_ARMOR;
    public static ItemStack STRAIGHT_ARMOR;
    public static ItemStack BI_ARMOR;
    public static ItemStack PAN_ARMOR;
    public static ItemStack ASEXUAL_ARMOR;
    public static ItemStack LESBIAN_ARMOR;

    // Server selector Gui items
    public static ItemStack SURVIVAL_SERVER;
    public static ItemStack SKYBLOCK_SERVER;
    public static ItemStack CREATIVE_SERVER;
    public static ItemStack BUILD_SERVER;
    public static ItemStack DEVELOPMENT_SERVER;
    public static ItemStack LIMBO_SERVER;

    // Speed Gui items
    public static ItemStack SPEED_3;
    public static ItemStack SPEED_6;
    public static ItemStack SPEED_9;
    public static ItemStack NO_SPEED;

    public static void load() {
        String survivalVersion = ConfigUtils.get(String.class, "versions.survival");
        String skyblockVersion = ConfigUtils.get(String.class, "versions.skyblock");
        String creativeVersion = ConfigUtils.get(String.class, "versions.creative");
        String buildVersion = ConfigUtils.get(String.class, "versions.build");
        String devVersion = ConfigUtils.get(String.class, "versions.dev");
        String limboVersion = ConfigUtils.get(String.class, "versions.limbo");

        // Hotbar items
        TIME_SELECTOR = new ItemBuilder<>(Material.CLOCK)
                .name("&e&lTime Selector &7(Right Click)")
                .lore("&7Set your personal time.")
                .build();

        COSMETICS_SELECTOR = new ItemBuilder<>(Material.CHEST)
                .name("&6&lCosmetics &7(Right Click)")
                .lore("&7Click to open the Cosmetics menu!")
                .build();

        SERVER_SELECTOR = new ItemBuilder<>(Material.NETHER_STAR)
                .name("&a&lServer Selector &7(Right Click)")
                .lore("&7Teleport to the other servers!")
                .build();

        ENDERPEARL = new ItemBuilder<>(Material.ENDER_PEARL)
                .name("&d&lEnderpearl &7(Right Click)")
                .lore("&7Throw me to ride!")
                .build();

        SPEED_SELECTOR = new ItemBuilder<>(Material.SUGAR)
                .name("&c&lSpeed Selector &7(Right Click)")
                .lore("&7Set your speed!")
                .build();

        // General Gui items
        CLOSE_MENU = new ItemBuilder<>(Material.BARRIER)
                .name("&c&lClose menu")
                .lore("&7Click to close this menu!")
                .build();

        GO_BACK = new ItemBuilder<>(Material.BARRIER)
                .name("&c&lGo back")
                .lore("&7Click to go back!")
                .build();

        // Time Gui items
        DAY_TIME = new ItemBuilder<>(Material.CLOCK)
                .name("&eDay")
                .lore("&7Sets your time to day")
                .build();

        NIGHT_TIME = new ItemBuilder<>(Material.CLOCK)
                .name("&8Night")
                .lore("&7Sets your time to night")
                .build();

        // Cosmetics Gui items
        PARTICLES = new ItemBuilder<>(Material.NETHER_STAR)
                .name("&f&lParticles &7(Right Click)")
                .lore("&7Click to go to the particles section")
                .build();

        ARMORS = new ItemBuilder<>(Material.LEATHER_HELMET)
                .name("&9&lArmors")
                .lore("&7Click to go to the armors section")
                .build();

        // Particles Gui items
        FLAME_PARTICLE = new ItemBuilder<>(Material.FIRE_CHARGE)
                .name("&c&lFlame Particle &7(Right Click)")
                .lore("&7Left click to spawn.", "&7Right click to remove.")
                .build();

        // Armors Gui items
        RAINBOW_ARMOR = new ItemBuilder<LeatherArmorMeta>(Material.LEATHER_CHESTPLATE)
                .name("&c&l&oR&6&l&oa&e&l&oi&a&l&on&3&l&ob&9&l&oo&5&l&ow &6&l&oA&e&l&or&a&l&om&3&l&oo&9&l&or")
                .lore("&7Left click to equip", "&7Right click to unequip")
                .meta(meta -> meta.setColor(Color.fromRGB(176, 46, 38)))
                .build();

        STRAIGHT_ARMOR = new ItemBuilder<LeatherArmorMeta>(Material.LEATHER_CHESTPLATE)
                .name("&fStra&0ight &7Armor")
                .lore("&7Left click to equip", "&7Right click to unequip")
                .meta(meta -> meta.setColor(Color.fromRGB(29, 29, 33)))
                .build();

        BI_ARMOR = new ItemBuilder<LeatherArmorMeta>(Material.LEATHER_CHESTPLATE)
                .name("&dBi&5sex&9ual &7Armor")
                .lore("&7Left click to equip", "&7Right click to unequip")
                .meta(meta -> meta.setColor(Color.fromRGB(137, 50, 184)))
                .build();

        PAN_ARMOR = new ItemBuilder<LeatherArmorMeta>(Material.LEATHER_CHESTPLATE)
                .name("&dPan&esex&bual &7Armor")
                .lore("&7Left click to equip", "&7Right click to unequip")
                .meta(meta -> meta.setColor(Color.fromRGB(254, 216, 61)))
                .build();

        ASEXUAL_ARMOR = new ItemBuilder<LeatherArmorMeta>(Material.LEATHER_CHESTPLATE)
                .name("&0As&7ex&fua&5l &7Armor")
                .lore("&7Left click to equip", "&7Right click to unequip")
                .meta(meta -> meta.setColor(Color.fromRGB(157, 157, 151)))
                .build();

        LESBIAN_ARMOR = new ItemBuilder<LeatherArmorMeta>(Material.LEATHER_CHESTPLATE)
                .name("&6Les&fb&cian &7Armor")
                .lore("&7Left click to equip", "&7Right click to unequip")
                .meta(meta -> meta.setColor(Color.fromRGB(249, 128, 29)))
                .build();

        // Server selector Gui items
        SURVIVAL_SERVER = new ItemBuilder<>(Material.GRASS_BLOCK)
                .name("&a&lSurvival")
                .lore("&7Version: &9" + survivalVersion, "&7Teleport to the survival server")
                .build();

        SKYBLOCK_SERVER = new ItemBuilder<>(Material.OAK_WOOD)
                .name("&b&lSkyblock")
                .lore("&7Version: &9" + skyblockVersion, "&7Teleport to the skyblock server")
                .build();

        CREATIVE_SERVER = new ItemBuilder<>(Material.BIRCH_WOOD)
                .name("&6&lCreative")
                .lore("&7Version: &9" + creativeVersion, "&7Teleport to the creative server")
                .build();

        BUILD_SERVER = new ItemBuilder<>(Material.DIAMOND_PICKAXE)
                .name("&c&lBuild")
                .lore("&7Version: &9" + buildVersion,
                        "&7Teleport to the Build server.",
                        "&7You are staff so you can see this server.")
                .build();

        DEVELOPMENT_SERVER = new ItemBuilder<>(Material.COMMAND_BLOCK)
                .name("&d&lDevelopment")
                .lore("&7Version: &9" + devVersion, "&7Teleport to the Development server.")
                .build();

        LIMBO_SERVER = new ItemBuilder<>(Material.WOODEN_AXE)
                .name("&e&lLimbo")
                .lore("&7Version: &9" + limboVersion,
                        "&7Click to teleport to the Limbo server.",
                        "&7If Vibe is under maintenance, this is where players get sent.")
                .build();

        // Speed Gui items
        SPEED_3 = new ItemBuilder<>(Material.SUGAR)
                .name("&c&lSpeed 3")
                .lore("&7Give yourself Speed 3")
                .build();

        SPEED_6 = new ItemBuilder<>(Material.SUGAR)
                .name("&c&lSpeed 6")
                .lore("&7Give yourself Speed 6")
                .build();

        SPEED_9 = new ItemBuilder<>(Material.SUGAR)
                .name("&c&lSpeed 9")
                .lore("&7Give yourself Speed 9")
                .build();

        NO_SPEED = new ItemBuilder<>(Material.BARRIER)
                .name("&c&lDisable Speed")
                .lore("&7Disable speed")
                .build();
    }

}
