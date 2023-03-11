package me.kevind.vibehub.commands;

import me.kevind.vibehub.VibeHub;
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
            player.openInventory(VibeHub.getCosmetics().getInv()); // TODO

            MessageUtils.message(sender, "&7Opening Cosmetics menu...");
        } else
            MessageUtils.message(sender, "You must be a player to use this command!");

        return true;
    }

}
