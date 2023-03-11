package me.kevind.vibehub.commands;

import me.kevind.vibehub.utils.ConfigUtils;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;

public final class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 0) {
            String incorrectUsage = ConfigUtils.get(String.class, "messages.IncorrectUsage");

            MessageUtils.message(sender, incorrectUsage + "&aon &7or &coff");
            return true;
        }

        if (sender instanceof Player player && sender.hasPermission("vibe.build")) {
            PlayerInventory inventory = player.getInventory();

            if (args[0].equalsIgnoreCase("on")) {
                inventory.clear();
                inventory.addItem(new ItemStack(Material.WOODEN_AXE));
                inventory.setItem(4, new ItemStack(Material.COMPASS));
                inventory.setItem(8, ItemList.SPEED_ITEM);

                player.updateInventory();
                player.setGameMode(GameMode.CREATIVE);

                MessageUtils.message(sender, ConfigUtils.get(String.class, "messages.BuildEnabled"));
            }

            if (args[0].equalsIgnoreCase("off")) {
                inventory.clear();
                inventory.setItem(4, ItemList.SERVER_SELECTOR);
                inventory.setItem(8, ItemList.SPEED_ITEM);
                inventory.setItem(0, ItemList.TIME_SELECTOR);
                inventory.setItem(7, ItemList.ENDERPEARL);
                inventory.setHeldItemSlot(4);

                player.updateInventory();
                player.setGameMode(GameMode.ADVENTURE);

                MessageUtils.message(sender, ConfigUtils.get(String.class, "messages.BuildDisabled"));
            }
        } else
            MessageUtils.message(sender, ConfigUtils.get(String.class, "messages.NoPermissionMessage"));

        return true;
    }
}
