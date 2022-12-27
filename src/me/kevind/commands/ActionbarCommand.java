package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.tasks.ActionbarTask;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ActionbarCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) sender;
        if (args[0] == null) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&cPlease specify arguments."));
        }
        if (args[0].equalsIgnoreCase("on")) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Turned &a&lon &7the action bar."));

        }
        if (args[0].equalsIgnoreCase("off")) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Turned &c&loff &7the action bar."));
        }
        return false;
    }
}
