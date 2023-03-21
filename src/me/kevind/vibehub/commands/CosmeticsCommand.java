package me.kevind.vibehub.commands;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.gui.guis.CosmeticsGui;
import me.kevind.vibehub.gui.guis.staff.StaffCosmeticsGui;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class CosmeticsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player player) {
            if (sender.hasPermission("vibe.staff"))
                player.openInventory(Gui.get(StaffCosmeticsGui.class));
            else
                player.openInventory(Gui.get(CosmeticsGui.class));

            MessageUtils.message(sender, "&7Opening Cosmetics menu...");
        } else
            MessageUtils.message(sender, "You must be a player to use this command!");

        return true;
    }

}
