package me.kevind.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.ScoreboardManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreboardUtils {
    ScoreboardManager scoreboard = Bukkit.getScoreboardManager();
    private Player player;
    public ScoreboardUtils(Player player) {
        this.player = player;
    }
    Date date = new Date(player.getFirstPlayed());
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
    String firstplayed = sdf.format(date);


    public static void setupScoreboard() {
        ScoreboardManager scoreboard = Bukkit.getScoreboardManager();
        Objective objective = scoreboard.getNewScoreboard().registerNewObjective("sidebar", "dummy", ColorUtils.color("&9&lVibe &8| &7Hub"), RenderType.INTEGER);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(" ").setScore(6);
        objective.getScore(ColorUtils.color("&7Name: " )).setScore(5);
        objective.getScore(ColorUtils.color("&8Rank: " + PlaceholderAPI.setPlaceholders(player, "%player_name%"))).setScore(4);
        objective.getScore(ColorUtils.color("&8Joined: " + firstplayed)).setScore(3);
        objective.getScore(" ").setScore(2);
        objective.getScore("&9&lvibemarket.org").setScore(1);

    }
}
