package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        String NoPermissionMessage =  VibeHub.getInstance().getConfig().getString("NoPermissionMessage");
        if (args[1] == "on") {
        if (player.hasPermission("vibe.build")) {
            player.setGameMode(GameMode.CREATIVE);
            player.getInventory().clear();
            player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
            player.getInventory().setItem(4, new ItemStack(Material.COMPASS));
            player.getInventory().setItem(8, new ItemStack(Material.STICK));
            player.updateInventory();
            player.sendMessage("&9&lVibeツ &8» &aTurned on build mode.");
        }else {
            player.sendMessage(ColorUtils.color(NoPermissionMessage));
        }
        }if (args[0] == "off") {
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
            player.updateInventory();
            player.sendMessage("&9&lVibeツ &8» &cTurned off build mode.");
        }
        return false;
    }
}
