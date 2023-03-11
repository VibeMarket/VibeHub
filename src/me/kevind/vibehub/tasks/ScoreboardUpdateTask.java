package me.kevind.vibehub.tasks;

import me.kevind.vibehub.utils.ScoreboardUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class ScoreboardUpdateTask implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers())
            ScoreboardUtils.updateScoreboard(player);
    }

}
