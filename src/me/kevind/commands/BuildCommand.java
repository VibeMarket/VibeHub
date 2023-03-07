package me.kevind.commands;

import me.kevind.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.ItemList;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        String incorrectusage = VibeHub.getInstance().getConfig().getString("messages.IncorrectUsage");
        String NoPermissionMessage = VibeHub.getInstance().getConfig().getString("messages.NoPermissionMessage");
        String BuildEnabled = VibeHub.getInstance().getConfig().getString("messages.BuildEnabled");
        String BuildDisabled = VibeHub.getInstance().getConfig().getString("messages.BuildDisabled");
        if (args[0] == null) {
            player.sendMessage(ColorUtils.color(incorrectusage + "&aon &7or &coff"));
            return true;
        }
        if (args[0].equalsIgnoreCase("on")) {
            if (player.hasPermission("vibe.build")) {
                player.setGameMode(GameMode.CREATIVE);
                player.getInventory().clear();
                player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
                player.getInventory().setItem(4, new ItemStack(Material.COMPASS));
                player.getInventory().setItem(8, ItemList.SPEED_ITEM);
                player.updateInventory();
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + BuildEnabled));
            } else {
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + NoPermissionMessage));
            }
        }
        if (args[0].equalsIgnoreCase("off")) {
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
            player.getInventory().setItem(4, ItemList.SERVER_SELECTOR);
            player.getInventory().setItem(8, ItemList.SPEED_ITEM);
            player.getInventory().setItem(0, ItemList.TIME_SELECTOR);
            player.getInventory().setItem(7, ItemList.ENDERPEARL);
            player.getInventory().getItem(7).setAmount(16);
            player.getInventory().setHeldItemSlot(4);
            player.updateInventory();
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + BuildDisabled));
        }
        return false;
    }
}
