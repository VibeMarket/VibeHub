package me.kevind.vibehub.utils;

import me.kevind.vibehub.VibeHub;

public final class ConfigUtils {

    private static final VibeHub plugin = VibeHub.getInstance();

    public static <T>T get(Class<T> clazz, String path) {
        return plugin.getConfig().getObject(path, clazz);
    }

    public static void set(Object object, String path) {
        plugin.getConfig().set(path, object);
    }

    public static void save() {
        plugin.saveConfig();
    }

    public static void reload() {
        plugin.reloadConfig();
    }

}
