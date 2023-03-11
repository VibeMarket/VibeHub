package me.kevind.vibehub.commands;

import me.kevind.vibehub.utils.ConfigUtils;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("vibe.reloadconfig")) {
            ConfigUtils.reload();
            MessageUtils.message(sender, ConfigUtils.get(String.class, "messages.ConfigReloaded"));
        } else
            MessageUtils.message(sender, ConfigUtils.get(String.class, "messages.NoPermissionMessage"));

        return true;
    }

}
