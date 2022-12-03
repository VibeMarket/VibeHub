package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        String NoPermissionMessage = VibeHub.getInstance().getConfig().getString("messages.NoPermissionMessage");
        if (sender instanceof Player) {
            if (player.hasPermission("vibe.staff")) {
                player.openInventory(VibeHub.getStaffselector().getInv());
            }else {
                player.openInventory(VibeHub.getSelectorGUI().getInv());
            }
        } else {
            player.sendMessage(NoPermissionMessage);
        }
        return false;
    }
}
