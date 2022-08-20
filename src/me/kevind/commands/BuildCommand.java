package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.ItemList;
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
        String prefix =  VibeHub.getInstance().getConfig().getString("prefix");
        if (args[0].equalsIgnoreCase("on")) {
        if (player.hasPermission("vibe.build")) {
            player.setGameMode(GameMode.CREATIVE);
            player.getInventory().clear();
            player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
            player.getInventory().setItem(4, new ItemStack(Material.COMPASS));
            player.updateInventory();
            player.sendMessage(ColorUtils.color(prefix + "&aTurned on build mode."));
        }else {
            player.sendMessage(ColorUtils.color(NoPermissionMessage));
        }
        }if (args[0].equalsIgnoreCase("off")) {
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
            if (player.hasPermission("vibe.serverselector")) {
                player.getInventory().setItem(8, ItemList.SERVER_SELECTOR);
            }
            player.updateInventory();
            player.sendMessage(ColorUtils.color(prefix + "&cTurned off build mode. You'll need to re-log to get the server selector."));
        }
        return false;
    }
}
