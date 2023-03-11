package me.kevind.vibehub.commands;

import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class ActionbarCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 0) {
            MessageUtils.message(sender, "&cPlease specify arguments.");
            return true;
        }

        if (args[0].equalsIgnoreCase("on"))
            MessageUtils.message(sender, "&7Turned &a&lon &7the action bar.");

        if (args[0].equalsIgnoreCase("off"))
            MessageUtils.message(sender, "&7Turned &c&loff &7the action bar.");

        return false;
    }

}
