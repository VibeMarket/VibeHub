package me.kevind.main;

import me.kevind.commands.*;
import me.kevind.inventory.SelectorGUI;
import me.kevind.inventory.SpeedGUI;
import me.kevind.inventory.TimeGUI;
import me.kevind.listeners.*;
import me.kevind.utils.ColorUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class VibeHub extends JavaPlugin {
    private static VibeHub instance;
    private static SelectorGUI serverselector;
    private static SpeedGUI speeditem;
    private static TimeGUI timegui;
    public static SelectorGUI getSelectorGUI() {
        return serverselector;
    }
    public static TimeGUI getTimeGUI() {
        return timegui;
    }
    public static SpeedGUI getSpeedGUI() { return speeditem; }
    public static VibeHub getInstance() {
        return instance;
    }
    public static String getPrefix() { return instance.getConfig().getString("messages.Prefix"); }

    String serverip = getConfig().getString("messages.ServerIP");

    public void onEnable() {
        instance = this;
        serverselector = new SelectorGUI();
        speeditem = new SpeedGUI();
        timegui = new TimeGUI();
        saveDefaultConfig();

        //tasks
        //action bar to always show server ip
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    TextComponent ip = new TextComponent(ColorUtils.color(serverip));
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, ip);
                }
            }
        }.runTaskTimerAsynchronously(this, 40, 40);

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            getLogger().info("Using PlaceholderAPI.");
        }else {
            getLogger().warning("Could not find PlaceholderAPI. This plugin is required");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        //Events
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFoodChangeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DropListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProjectileLaunchListener(), this);
        //Commands
        getCommand("hubreload").setExecutor(new ReloadCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("vspeed").setExecutor(new VSpeedCommand());
        getCommand("sethub").setExecutor(new SetHubCommand());
        getCommand("iteminfo").setExecutor(new ItemInfoCommand());
    }
    public void onDisable() {}
}
