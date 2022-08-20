package me.kevind.commands;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        String NoPermissionMessage =  VibeHub.getInstance().getConfig().getString("NoPermissionMessage");
        String prefix =  VibeHub.getInstance().getConfig().getString("prefix");
        if (sender instanceof Player) {
            if (args[0].equalsIgnoreCase("on")) {
                String IWantSpeedMessage = VibeHub.getInstance().getConfig().getString("IWantSpeedMessage");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
                player.sendMessage(ColorUtils.color(IWantSpeedMessage));
            }if (args[0].equalsIgnoreCase("off")) {
                String IDontWantSpeedMessage = VibeHub.getInstance().getConfig().getString("IDontWantSpeedMessage");
                for (PotionEffect effect : player.getActivePotionEffects())
                    player.removePotionEffect(effect.getType());
                player.sendMessage(ColorUtils.color(IDontWantSpeedMessage));
            }if (args[0] == null) {
                player.sendMessage(ColorUtils.color(prefix + "&cInvalid arguments! Correct usage is /vspeed on & /vspeed off"));
            }
        }else {
            player.sendMessage(NoPermissionMessage);
        }
        return false;
    }
}
