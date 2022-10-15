package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ItemInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;
        String kevinuuid = VibeHub.getInstance().getConfig().getString("kevinuuid");
        String nopermission = VibeHub.getInstance().getConfig().getString("NoPermissionMessage");
        if (sender instanceof Player) {
            if (player.hasPermission("vibe.iteminfo")) {
                player.sendMessage(ColorUtils.color("&7Item Information: &9" + player.getActiveItem().getType() + "\n" + "&7Amount: &9" + player.getActiveItem().getAmount() + "\n" + "&7Enchantments: &9" + player.getActiveItem().getEnchantments() + "\n&7Rarity: &9" + player.getActiveItem().getRarity() + "\n&7Max Stack Size: &9" + player.getActiveItem().getMaxStackSize()));
            } else {
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + nopermission));
            }
        }else if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a player to use this command.");
        }
        return false;
    }
}
