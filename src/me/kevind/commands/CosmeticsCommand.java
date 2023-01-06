package me.kevind.commands;

import me.kevind.VibeHub;
import me.kevind.utils.ColorUtils;
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
            if (player.getUniqueId().toString().equalsIgnoreCase("a948c50c-ede2-4dfa-9b6c-688daf22197c")) {
                player.openInventory(VibeHub.getCosmetics().getInv());
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Opening cosmetics selector..."));
            }else {
                player.sendMessage(ColorUtils.color("&cThis command can only be used by Kevin."));
            }

        }
        return false;
    }
}