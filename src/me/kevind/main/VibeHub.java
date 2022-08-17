package me.kevind.main;

import me.kevind.commands.ReloadCommand;
import me.kevind.listeners.JoinListener;
import me.kevind.listeners.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class VibeHub extends JavaPlugin {
    private static VibeHub instance;
    public static VibeHub getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();

        //Events
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        //Commands
        getCommand("hubreload").setExecutor(new ReloadCommand());
    }
    public void onDisable() {}
}
