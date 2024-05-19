package me.kevind.vibehub.commands;

import me.kevind.vibehub.utils.MessageUtils;
import me.kevind.vibehub.utils.ScoreboardUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class ScoreboardCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            MessageUtils.message(sender, "&cPlease specify arguments.");
            return true;
        }

        if (args[0].equalsIgnoreCase("on")) {
            MessageUtils.message(sender, "&7Turned &a&lon &7the scoreboard.");
            ScoreboardUtils.addScoreboard(player);
        }

        if (args[0].equalsIgnoreCase("off")) {
            MessageUtils.message(sender, "&7Turned &c&loff &7the scoreboard.");
            ScoreboardUtils.clearScoreboard(player);
        }
        return true;
    }

}
