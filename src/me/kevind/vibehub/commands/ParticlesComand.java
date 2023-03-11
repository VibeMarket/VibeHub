package me.kevind.vibehub.commands;

import me.kevind.vibehub.VibeHub;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class ParticlesComand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (player.getUniqueId().toString().equalsIgnoreCase("a948c50c-ede2-4dfa-9b6c-688daf22197c")) {
                player.openInventory(VibeHub.getParticlesGUI().getInv()); // TODO

                MessageUtils.message(sender, "&7Opening particle selector...");
            } else
                MessageUtils.message(sender, "&cThis command can only be used by Kevin.");
        }

        return true;
    }

}
