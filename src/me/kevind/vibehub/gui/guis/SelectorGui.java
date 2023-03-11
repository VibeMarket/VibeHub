package me.kevind.vibehub.gui.guis;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.utils.BungeeUtils;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;

public final class SelectorGui extends Gui {

    public SelectorGui() {
        super(3, "Server Selector");

        setItem(2, 4, ItemList.SURVIVAL_SERVER, (player, click) -> {
            MessageUtils.message(player, "&7Sending you to &6&lSurvival&7.");
            BungeeUtils.connect(player, "survival");
        });
        setItem(2, 5, ItemList.SKYBLOCK_SERVER, (player, click) -> {
            MessageUtils.message(player, "&7Sending you to &6&lSkyblock&7.");
            BungeeUtils.connect(player, "skyblock");
        });
        setItem(2, 6, ItemList.CREATIVE_SERVER, (player, click) -> {
            MessageUtils.message(player, "&7Sending you to &6&lCreative&7.");
            BungeeUtils.connect(player, "creative");
        });

        fillRemaining();
    }

}
