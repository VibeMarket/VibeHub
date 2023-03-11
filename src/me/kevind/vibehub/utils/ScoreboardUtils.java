package me.kevind.vibehub.utils;

import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ScoreboardUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

    public static void setupEntityCollision(Player player) {
        Team team = player.getScoreboard().registerNewTeam("NoPush");
        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
        team.addEntry(player.getName());
    }

    public static void setupScoreboard(Player player) {
        User user = LuckPermsUtils.getUser(player);
        String firstPlayed = sdf.format(new Date(player.getFirstPlayed()));
        Scoreboard scoreboard = player.getScoreboard();

        Objective objective = scoreboard.registerNewObjective(
                "sidebar", "dummy",
                ColorUtils.color("&9&lVibe &8| &7Hub"),
                RenderType.INTEGER);

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("  ").setScore(6);
        objective.getScore(ColorUtils.color("&7Name: &f")).setScore(5);
        objective.getScore(ColorUtils.color("&7Rank: &f")).setScore(4);
        objective.getScore(ColorUtils.color("&7Ping &f")).setScore(3);
        objective.getScore(ColorUtils.color("&7Joined: &f" + firstPlayed)).setScore(2);
        objective.getScore(" ").setScore(1);
        objective.getScore(ColorUtils.color("&9&lvibemarket.org")).setScore(0);

        Team rank = scoreboard.registerNewTeam("rank");
        rank.setSuffix(ColorUtils.color(user.getCachedData().getMetaData().getPrefix()));
        rank.addEntry(ColorUtils.color("&7Rank: &f"));

        Team ping = scoreboard.registerNewTeam("ping");
        ping.setSuffix(player.getPing() + "ms");
        ping.addEntry(ColorUtils.color("&7Ping &f"));

        Team username = scoreboard.registerNewTeam("username");
        username.setSuffix(player.getName());
        username.addEntry(ColorUtils.color("&7Name: &f"));
    }

    public static void updateScoreboard(Player player) {
        User user = LuckPermsUtils.getUser(player);
        Scoreboard scoreboard = player.getScoreboard();

        Team ping = scoreboard.getTeam("ping");
        Team rank = scoreboard.getTeam("rank");

        if (ping == null || rank == null)
            return;

        ping.setSuffix(player.getPing() + "ms");
        ping.addEntry(ColorUtils.color("&7Ping &f"));

        rank.setSuffix(ColorUtils.color(user.getCachedData().getMetaData().getPrefix()));
        rank.addEntry(ColorUtils.color("&7Rank: &f"));
    }

}
