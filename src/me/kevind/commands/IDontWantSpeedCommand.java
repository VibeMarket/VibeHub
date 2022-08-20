package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class IDontWantSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&cThis command has moved to /vspeed off"));
        }else {
            sender.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "You need to be a player!"));
        }
        return false;
    }
}
