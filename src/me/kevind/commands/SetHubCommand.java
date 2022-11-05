package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String NoPermissionMessage =  VibeHub.getInstance().getConfig().getString("messages.NoPermissionMessage");
        String hubsetmessage  =  VibeHub.getInstance().getConfig().getString("messages.HubSetMessage");
        Player player = (Player) sender;
        if (player.hasPermission("vibe.sethub")) {
            //grab the players x, y, z, yaw, pitch and world name then set the respective values in the config & reload the configuration.
            VibeHub.getInstance().getConfig().set("coordinates.hub.world", player.getLocation().getWorld().getName());
            VibeHub.getInstance().getConfig().set("coordinates.hub.x", player.getLocation().getX());
            VibeHub.getInstance().getConfig().set("coordinates.hub.y", player.getLocation().getBlockY());
            VibeHub.getInstance().getConfig().set("coordinates.hub.z", player.getLocation().getZ());
            VibeHub.getInstance().getConfig().set("coordinates.hub.yaw", player.getLocation().getYaw());
            VibeHub.getInstance().getConfig().set("coordinates.hub.pitch", player.getLocation().getPitch());
            VibeHub.getInstance().saveConfig();
            VibeHub.getInstance().reloadConfig();
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + hubsetmessage));
        }else {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + NoPermissionMessage));
        }
        return false;
    }
}
