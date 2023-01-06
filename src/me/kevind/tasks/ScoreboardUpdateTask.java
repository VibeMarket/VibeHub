package me.kevind.tasks;

import me.kevind.VibeHub;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.FastBoard;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ScoreboardUpdateTask {
    public static void updateBoard(FastBoard board) {
        Date date = new Date(board.getPlayer().getFirstPlayed());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String firstplayed = sdf.format(date);
        User user = VibeHub.luckperms.getUserManager().getUser(board.getPlayer().getUniqueId());
        board.updateLines(
                " ",
                ChatColor.GRAY + "Name: " + ChatColor.WHITE + board.getPlayer().getName(),
                ChatColor.GRAY + "Rank: " + ChatColor.WHITE + ColorUtils.color(user.getCachedData().getMetaData().getPrefix()),
                ChatColor.GRAY + "Ping: " + ChatColor.WHITE + board.getPlayer().getPing() + "ms",
                ChatColor.GRAY + "Joined: " + ChatColor.WHITE + firstplayed,
                " ",
                ColorUtils.color("&9&lvibemarket.org")
        );
    }
}
