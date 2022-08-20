package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IWantSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String IWantSpeedMessage = VibeHub.getInstance().getConfig().getString("IWantSpeedMessage");
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
            player.sendMessage(ColorUtils.color(IWantSpeedMessage));
        }else {
            sender.sendMessage(ColorUtils.color("&cYou need to be a player to do that."));
        }
        return false;
    }
}
