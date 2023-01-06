package me.kevind.commands;

import me.kevind.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class CosmeticsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
                player.openInventory(VibeHub.getCosmetics().getInv());
                MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&7Opening Cosmetics menu...");
            }else {
            MessageUtils.sendMessage(sender, "You must be a player to use this command!");
        }

        return false;
    }
    }
