package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        String NoPermissionMessage = VibeHub.getInstance().getConfig().getString("messages.NoPermissionMessage");
        if (sender instanceof Player) {
            player.openInventory(VibeHub.getSpeedGUI().getInv());
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Opening speed gui..."));
        } else {
            player.sendMessage("You must be a player to use this command.");
        }
        return false;
    }
}
