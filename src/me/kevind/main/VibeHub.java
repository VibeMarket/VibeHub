package me.kevind.main;

import me.kevind.listeners.JoinListener;
import me.kevind.listeners.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class VibeHub extends JavaPlugin {
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
    }
    public void onDisable() {}
}
