package me.kevind.main;

import me.kevind.commands.*;
import me.kevind.inventory.SelectorGUI;
import me.kevind.inventory.SpeedGUI;
import me.kevind.listeners.*;
import me.kevind.utils.ColorUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.logging.log4j.core.appender.rolling.action.Action;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class VibeHub extends JavaPlugin {
    private static VibeHub instance;
    private static SelectorGUI serverselector;
    private static SpeedGUI speeditem;

    public static SelectorGUI getSelectorGUI() {
        return serverselector;
    }
    public static SpeedGUI getSpeedGUI() { return speeditem; }
    public static VibeHub getInstance() {
        return instance;
    }
    public static String getPrefix() { return instance.getConfig().getString("prefix"); }
    public void onEnable() {
        instance = this;
        serverselector = new SelectorGUI();
        speeditem = new SpeedGUI();
        getConfig().options().copyDefaults(true);
        saveConfig();

        //tasks
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    TextComponent ip = new TextComponent(ColorUtils.color("&9&lvibemarket.org"));
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, ip);
                }
            }
        }.runTaskTimerAsynchronously(this, 40, 40);

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        //Events
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
        //Commands
        getCommand("hubreload").setExecutor(new ReloadCommand());
        getCommand("idontwantspeed").setExecutor(new IDontWantSpeedCommand());
        getCommand("iwantspeed").setExecutor(new IWantSpeedCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("vspeed").setExecutor(new VSpeedCommand());

    }
    public void onDisable() {}
}
