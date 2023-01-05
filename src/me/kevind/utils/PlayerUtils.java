package me.kevind.utils;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class PlayerUtils {
    private static @NotNull Player player;
    public static @NotNull Player getPlayer() {
        return player;
    }
}
