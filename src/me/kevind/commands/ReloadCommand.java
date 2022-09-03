package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.Users;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        if (Users.isManagement()) {
            String reloadedConfigMessage = VibeHub.getInstance().getConfig().getString("configReloaded");
            VibeHub.getInstance().reloadConfig();
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + reloadedConfigMessage));
        }else {
            String NoPermissionMessage =  VibeHub.getInstance().getConfig().getString("NoPermissionMessage");
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + NoPermissionMessage));
        }
        return false;
    }
}
