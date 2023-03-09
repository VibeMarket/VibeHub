package me.kevind.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kevind.VibeHub;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreboardUtils {

    public static void setupEntityCollision(Player player) {
            Team team = player.getScoreboard().registerNewTeam("NoPush");
            team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
            team.addEntry(player.getName());
    }

    public static void setupScoreboard(Player player) {
            User user = VibeHub.luckperms.getUserManager().getUser(player.getUniqueId());
            Date date = new Date(player.getFirstPlayed());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
            String firstplayed = sdf.format(date);
            Objective objective = player.getScoreboard().registerNewObjective("sidebar", "dummy", ColorUtils.color("&9&lVibe &8| &7Hub"), RenderType.INTEGER);
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            objective.getScore("  ").setScore(6);
            objective.getScore(ColorUtils.color("&7Name: &f" + PlaceholderAPI.setPlaceholders(player, "%player_name%"))).setScore(5);
            objective.getScore(ColorUtils.color("&7Rank: &f")).setScore(4);
            objective.getScore(ColorUtils.color("&7Ping &f")).setScore(3);
            objective.getScore(ColorUtils.color("&7Joined: &f" + firstplayed)).setScore(2);
            objective.getScore(" ").setScore(1);
            objective.getScore(ColorUtils.color("&9&lvibemarket.org")).setScore(0);

            Team rank = player.getScoreboard().registerNewTeam("rank");
            rank.setSuffix(ColorUtils.color(user.getCachedData().getMetaData().getPrefix()));
            rank.addEntry(ColorUtils.color("&7Rank: &f"));

            Team ping = player.getScoreboard().registerNewTeam("ping");
            ping.setSuffix(player.getPing() + "ms");
            ping.addEntry(ColorUtils.color("&7Ping &f"));
        }
        public static void updateScoreboard(Player player) {
            Team ping = player.getScoreboard().getTeam("ping");
            if (ping == null) {
                return;
            }
            ping.setSuffix(player.getPing() + "ms");
            ping.addEntry(ColorUtils.color("&7Ping &f"));
        }
    }
