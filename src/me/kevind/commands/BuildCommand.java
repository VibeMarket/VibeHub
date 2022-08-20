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
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        String NoPermissionMessage =  VibeHub.getInstance().getConfig().getString("NoPermissionMessage");

        if (player.hasPermission("vibe.build")) {
            player.setGameMode(GameMode.CREATIVE);
            player.getInventory().clear();
            player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
            player.updateInventory();
        }else {
            player.sendMessage(ColorUtils.color(NoPermissionMessage));
        }
        return false;
    }
}
