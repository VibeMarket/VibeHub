package me.kevind.vibehub.gui.guis;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class SpeedGui extends Gui {

    public SpeedGui() {
        super(1, "Set Speed");

        setItem(1, 1, ItemList.SPEED_3, (player, click) -> {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));

            MessageUtils.message(player, "&aYou've been given Speed 3");
        });

        setItem(1, 2, ItemList.SPEED_6, (player, click) -> {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 5));

            MessageUtils.message(player, "&aYou've been given Speed 6");
        });

        setItem(1, 3, ItemList.SPEED_9, (player, click) -> {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 8));

            MessageUtils.message(player, "&aYou've been given Speed 9");
        });

        setItem(1, 9, ItemList.NO_SPEED, (player, click) -> {
            player.removePotionEffect(PotionEffectType.SPEED);

            MessageUtils.message(player, "&cDisabled speed");
        });

        fillRemaining();
    }

}
