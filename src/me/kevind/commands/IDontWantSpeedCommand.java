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
            String IDontWantSpeedMessage = VibeHub.getInstance().getConfig().getString("IDontWantSpeedMessage");
            for (PotionEffect effect : player.getActivePotionEffects())
                player.removePotionEffect(effect.getType());
            player.sendMessage(ColorUtils.color(IDontWantSpeedMessage));
        }else {
            sender.sendMessage(ColorUtils.color("You need to be a player!"));
        }
        return false;
    }
}
