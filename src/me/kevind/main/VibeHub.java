package me.kevind.main;

import me.kevind.commands.*;
import me.kevind.inventory.SelectorGUI;
import me.kevind.listeners.InteractListener;
import me.kevind.listeners.JoinListener;
import me.kevind.listeners.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class VibeHub extends JavaPlugin {
    private static VibeHub instance;
    private static SelectorGUI serverselector;

    public static SelectorGUI getSelectorGUI() {
        return serverselector;
    }
    public static VibeHub getInstance() {
        return instance;
    }
    public static String getPrefix() { return instance.getConfig().getString("prefix"); }
    public void onEnable() {
        instance = this;
        serverselector = new SelectorGUI();
        getConfig().options().copyDefaults(true);
        saveConfig();

        //Events
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        //Commands
        getCommand("hubreload").setExecutor(new ReloadCommand());
        getCommand("idontwantspeed").setExecutor(new IDontWantSpeedCommand());
        getCommand("iwantspeed").setExecutor(new IWantSpeedCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("vspeed").setExecutor(new VSpeedCommand());
    }
    public void onDisable() {}
}
