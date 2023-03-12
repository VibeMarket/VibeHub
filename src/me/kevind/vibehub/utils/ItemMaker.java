package me.kevind.vibehub.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.*;

@Deprecated
public final class ItemMaker {

    private final Material material;
    private int amount;
    private String name;
    private Color color;
    private GameProfile profile;
    private List<String> lore;
    private List<ItemFlag> itemFlags;
    private Map<Enchantment, Integer> enchantments;
    private boolean unbreakable;

    public ItemMaker(Material material) {
        this.material = material;
        this.amount = 1;
        this.unbreakable = false;
    }

    public ItemMaker name(String name) {
        this.name = ColorUtils.color(name);
        return this;
    }

    public ItemMaker lore(String... lore) {
        for (int i = 0; i < lore.length; i++)
            lore[i] = ColorUtils.color(lore[i]);

        this.lore = Arrays.asList(lore);
        return this;
    }

    public ItemMaker amount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemMaker unbreakable() {
        this.unbreakable = true;
        return this;
    }

    public ItemMaker color(Color color) {
        this.color = color;
        return this;
    }

    public ItemMaker head(GameProfile profile) {
        this.profile = profile;
        return this;
    }

    public ItemMaker head(String texture) {
        this.profile = new GameProfile(UUID.randomUUID(), null);
        this.profile.getProperties().put("textures", new Property("textures", texture));
        return this;
    }

    public ItemMaker flags(ItemFlag... flags) {
        this.itemFlags = Arrays.asList(flags);
        return this;
    }

    public ItemMaker enchant(Enchantment enchantment, int level) {
        if (enchantments == null)
            enchantments = new HashMap<>();

        enchantments.put(enchantment, level);
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            if (name != null)
                meta.setDisplayName(name);

            if (lore != null)
                meta.setLore(lore);

            if (itemFlags != null)
                for (ItemFlag flag : itemFlags)
                    meta.addItemFlags(flag);

            if (enchantments != null)
                for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet())
                    meta.addEnchant(entry.getKey(), entry.getValue(), true);

            meta.setUnbreakable(unbreakable);
            item.setItemMeta(meta);

            if (meta instanceof LeatherArmorMeta leatherArmorMeta) {
                if (color != null)
                    leatherArmorMeta.setColor(color);

                item.setItemMeta(leatherArmorMeta);
            }

            if (meta instanceof SkullMeta skullMeta) {
                if (profile != null) {
                    try {
                        Field field = skullMeta.getClass().getDeclaredField("profile");
                        field.setAccessible(true);
                        field.set(skullMeta, profile);

                        item.setItemMeta(skullMeta);
                    } catch (NoSuchFieldException | IllegalAccessException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }

        return item;
    }
}