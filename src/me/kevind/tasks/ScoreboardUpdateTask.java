package me.kevind.tasks;

import me.kevind.utils.ScoreboardUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardUpdateTask extends BukkitRunnable {
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ScoreboardUtils.updateScoreboard(player);
        }
    }
}
