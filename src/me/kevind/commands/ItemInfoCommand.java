package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class ItemInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;
        String nopermission = VibeHub.getInstance().getConfig().getString("NoPermissionMessage");
        if (sender instanceof Player) {
            if (player.hasPermission("vibe.iteminfo")) {
                player.sendMessage(ColorUtils.color("&7Item Information: &9" + player.getInventory().getItemInMainHand().getType().name() + "\n" + "&7Amount: &9" + player.getItemInUse().getAmount() + "\n" + "&7Enchantments: &9" + player.getItemInUse().getEnchantments() + "\n&7Max Stack Size: &9" + player.getItemInUse().getMaxStackSize()));
            } else {
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + nopermission));
            }
        } else if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a player to use this command.");
        }
        return false;
    }
}