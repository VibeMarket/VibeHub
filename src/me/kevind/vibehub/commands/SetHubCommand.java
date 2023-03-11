package me.kevind.vibehub.commands;

import me.kevind.vibehub.utils.ConfigUtils;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class SetHubCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player player) {
            if (sender.hasPermission("vibe.sethub")) {
                Location location = player.getLocation();

                ConfigUtils.set(Objects.requireNonNull(location.getWorld()).getName(), "coordinates.hub.world");
                ConfigUtils.set(location.getX(), "coordinates.hub.x");
                ConfigUtils.set(location.getY(), "coordinates.hub.y");
                ConfigUtils.set(location.getZ(), "coordinates.hub.z");
                ConfigUtils.set(location.getYaw(), "coordinates.hub.yaw");
                ConfigUtils.set(location.getPitch(), "coordinates.hub.pitch");
                ConfigUtils.save();
                ConfigUtils.reload();

                MessageUtils.message(sender, ConfigUtils.get(String.class, "messages.HubSetMessage"));
            } else
                MessageUtils.message(sender, ConfigUtils.get(String.class, "messages.NoPermissionMessage"));
        } else
            MessageUtils.message(sender, "You must be a player to use this command!");

        return true;
    }

}