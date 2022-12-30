package me.kevind.tasks;

import me.kevind.listeners.player.JoinListener;
import me.kevind.utils.FastBoard;
import org.bukkit.scheduler.BukkitRunnable;

public final class ScoreboardTask extends BukkitRunnable {
    @Override
    public void run() {
        for (FastBoard board : JoinListener.boards.values()) {
            ScoreboardUpdateTask.updateBoard(board);
        }
    }
}
