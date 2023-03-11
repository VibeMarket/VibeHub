package me.kevind.vibehub.gui.guis.staff;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.utils.BungeeUtils;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;

public final class StaffSelectorGui extends Gui {

    public StaffSelectorGui() {
        super(4, "Server Selector");

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
        setItem(3, 4, ItemList.BUILD_SERVER, (player, click) -> {
            MessageUtils.message(player, "&7Sending you to &6&lBuild&7.");
            BungeeUtils.connect(player, "staff");
        });
        setItem(3, 5, ItemList.DEVELOPMENT_SERVER, (player, click) -> {
            MessageUtils.message(player, "&7Sending you to &6&lDevelopment&7.");
            BungeeUtils.connect(player, "dev");
        });
        setItem(3, 6, ItemList.LIMBO_SERVER, (player, click) -> {
            MessageUtils.message(player, "&7Sending you to &6&lLimbo&7.");
            BungeeUtils.connect(player, "limbo");
        });

        fillRemaining();
    }

}
