package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        String reloadconfigpermission = VibeHub.getInstance().getConfig().getString("permissions.ReloadConfigPermission");
        if (player.hasPermission(reloadconfigpermission)) {
            String reloadedConfigMessage = VibeHub.getInstance().getConfig().getString("messages.ConfigReloaded");
            VibeHub.getInstance().reloadConfig();
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + reloadedConfigMessage));
        }else {
            String NoPermissionMessage =  VibeHub.getInstance().getConfig().getString("messages.NoPermissionMessage");
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + NoPermissionMessage));
        }
        return false;
    }
}
