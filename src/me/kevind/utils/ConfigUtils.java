package me.kevind.utils;

import me.kevind.VibeHub;

import java.io.File;

public final class ConfigUtils {
    public static void createFiles(File File) {
    }
    public static String getString(String s) {
        return VibeHub.getInstance().getConfig().getString(s);
    }
    public static String get(String s) {
        return VibeHub.getInstance().getConfig().get(s);
    }
}
