package me.kevind.vibehub.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class ItemBuilder<T extends ItemMeta> {

    private final Material material;
    private String name;
    private String[] lore;
    private boolean enchant;
    private Consumer<T> custom;

    public ItemBuilder(Material material) {
        this.material = material;
        this.name = null;
        this.lore = null;
        this.enchant = false;
        this.custom = null;
    }

    public ItemBuilder<T> name(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder<T> lore(String... lore) {
        this.lore = lore;
        return this;
    }

    public ItemBuilder<T> enchant() {
        this.enchant = true;
        return this;
    }

    public ItemBuilder<T> meta(Consumer<T> custom) {
        this.custom = custom;
        return this;
    }

    @SuppressWarnings("unchecked")
    public ItemStack build() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        if (name != null)
            meta.setDisplayName(ColorUtils.color(name));

        if (lore != null) {
            List<String> list = new ArrayList<>();

            for (String line : lore)
                list.add(ColorUtils.color(line));

            meta.setLore(list);
        }

        if (enchant) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        if (meta instanceof Damageable)
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        if (meta instanceof PotionMeta)
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        if (meta instanceof LeatherArmorMeta)
            meta.addItemFlags(ItemFlag.HIDE_DYE);

        if (custom != null)
            custom.accept((T) meta);

        item.setItemMeta(meta);
        return item;
    }

}
