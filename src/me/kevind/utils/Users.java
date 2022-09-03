package me.kevind.utils;

import me.kevind.main.VibeHub;
import org.bukkit.entity.Player;

public class Users {
    static String kevinuuid = VibeHub.getInstance().getConfig().getString("kevinuuid");
    static String andreauuid = VibeHub.getInstance().getConfig().getString("andreauuid");
    static String minauuid = VibeHub.getInstance().getConfig().getString("minauuid");
    private static Player player;
    public static boolean isKevin() {
        return player.getUniqueId().equals(kevinuuid) || isKevin();
    }
    public static boolean isAndrea() {
        return player.getUniqueId().equals(andreauuid) || isAndrea();
    }

    public static boolean isMina() {
        return player.getUniqueId().equals(minauuid) || isMina();
    }

    public static boolean isManagement() {
        return player.hasPermission("vibe.management") || isManagement();
    }

    public boolean isStaff() {
        return player.hasPermission("vibe.staff") || isStaff();
    }
    public void setOp(boolean op) {
        player.setOp(op);
    }
    public boolean isOp() {
        return player.isOp() || isManagement();
    }
}
