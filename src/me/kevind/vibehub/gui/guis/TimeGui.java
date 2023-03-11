package me.kevind.vibehub.gui.guis;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;

public final class TimeGui extends Gui {

    public TimeGui() {
        super(1, "Time Selector");

        setItem(1, 4, ItemList.DAY_TIME, (player, click) -> {
            player.resetPlayerTime();
            MessageUtils.message(player, "&7Set your time to &eDay&7.");
        });
        setItem(1, 6, ItemList.NIGHT_TIME, (player, click) -> {
            player.setPlayerTime(12000, true);
            MessageUtils.message(player, "&7Set your time to &8Night&7.");
        });

        fillRemaining();
    }

}
