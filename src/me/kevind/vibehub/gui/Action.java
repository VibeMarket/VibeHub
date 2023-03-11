package me.kevind.vibehub.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public interface Action {

    void run(Player player, ClickType click);

}
