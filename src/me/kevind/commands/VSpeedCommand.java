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
        String vspeedinvalidargs = VibeHub.getInstance().getConfig().getString("messages.VSpeedInvalidArgs");
        String NoPermissionMessage =  VibeHub.getInstance().getConfig().getString("messages.NoPermissionMessage");
        if (sender instanceof Player) {
            if (args[0].equalsIgnoreCase("on")) {
                String IWantSpeedMessage = VibeHub.getInstance().getConfig().getString("messages.IWantSpeedMessage");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + IWantSpeedMessage));
            }if (args[0].equalsIgnoreCase("off")) {
                String IDontWantSpeedMessage = VibeHub.getInstance().getConfig().getString("messages.IDontWantSpeedMessage");
                for (PotionEffect effect : player.getActivePotionEffects())
                    player.removePotionEffect(effect.getType());
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + IDontWantSpeedMessage));
            }if (args[0] == null) {
                player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + vspeedinvalidargs));
            }
        }else {
            player.sendMessage(NoPermissionMessage);
        }
        return false;
    }
}
