package me.kevind.vibehub.gui.guis;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.gui.guis.cosmetics.ArmorsGui;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;

public final class CosmeticsGui extends Gui {

    public CosmeticsGui() {
        super(1, "Cosmetics");

        setItem(1, 5, ItemList.ARMORS, (player, click) -> {
            player.openInventory(Gui.get(ArmorsGui.class).getInventory());
        });
        setItem(1, 9, ItemList.CLOSE_MENU, (player, click) -> {
            player.closeInventory();
            MessageUtils.message(player, "&7Closing menu...");
        });

        fillRemaining();
    }

}
