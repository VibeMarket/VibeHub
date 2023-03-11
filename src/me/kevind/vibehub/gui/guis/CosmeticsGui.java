package me.kevind.vibehub.gui.guis;

import me.kevind.vibehub.VibeHub;
import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;

public final class CosmeticsGui extends Gui {

    public CosmeticsGui() {
        super(3, "Cosmetics");

        setItem(2, 5, ItemList.ARMORS, (player, click) -> {
            player.openInventory(VibeHub.getArmorsGUI().getInv()); // TODO
        });

        setItem(2, 9, ItemList.CLOSE_MENU, (player, click) -> {
            player.closeInventory();
            MessageUtils.message(player, "&7Closing menu...");
        });

        fillRemaining();
    }

}
