package me.kevind.vibehub.gui.guis.staff;

import me.kevind.vibehub.VibeHub;
import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;

public final class StaffCosmeticsGui extends Gui {

    public StaffCosmeticsGui() {
        super(1, "Cosmetics");

        setItem(1, 1, ItemList.PARTICLES, (player, click) -> {
            player.openInventory(VibeHub.getParticlesGUI().getInv()); // TODO
        });

        setItem(1, 5, ItemList.ARMORS, (player, click) -> {
            player.openInventory(VibeHub.getArmorsGUI().getInv()); // TODO
        });

        setItem(1, 9, ItemList.CLOSE_MENU, (player, click) -> {
            player.closeInventory();
            MessageUtils.message(player, "&7Closing menu...");
        });

        fillRemaining();
    }

}
