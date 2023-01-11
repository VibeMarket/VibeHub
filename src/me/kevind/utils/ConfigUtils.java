package me.kevind.utils;

import me.kevind.VibeHub;

import java.io.File;

public class ConfigUtils {
    public static void createFiles(File File) {
    }
    public static String getString(String s) {
        VibeHub.getInstance().getConfig().getString(s);
        return s;
    }
}
