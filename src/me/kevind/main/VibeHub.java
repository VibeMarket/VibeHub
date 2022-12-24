package me.kevind.main;

import me.kevind.commands.*;
import me.kevind.inventory.CosmeticsGUI;
import me.kevind.inventory.SelectorGUI;
import me.kevind.inventory.SpeedGUI;
import me.kevind.inventory.TimeGUI;
import me.kevind.inventory.staff.StaffSelectorGUI;
import me.kevind.listeners.inventory.InteractListener;
import me.kevind.listeners.inventory.InventoryClickListener;
import me.kevind.listeners.item.ProjectileLaunchListener;
import me.kevind.listeners.npc.NPCRightClickListener;
import me.kevind.listeners.player.*;
import me.kevind.tasks.ActionbarTask;
import me.kevind.tasks.ScoreboardTask;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class VibeHub extends JavaPlugin {
    private static VibeHub instance;
    private static SelectorGUI serverselector;
    private static SpeedGUI speeditem;
    private static TimeGUI timegui;
    private static StaffSelectorGUI staffselector;
    private static CosmeticsGUI cosmetics;

    public static SelectorGUI getSelectorGUI() {
        return serverselector;
    }

    public static TimeGUI getTimeGUI() {
        return timegui;
    }

    public static StaffSelectorGUI getStaffselector() {
        return staffselector;
    }

    public static CosmeticsGUI getCosmetics() {
        return cosmetics;
    }

    public static SpeedGUI getSpeedGUI() {
        return speeditem;
    }

    public static VibeHub getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return instance.getConfig().getString("messages.Prefix");
    }

    public static LuckPerms luckperms;
    String serverip = getConfig().getString("messages.ServerIP");

    public void onEnable() {
        long start = System.currentTimeMillis();
        instance = this;
        serverselector = new SelectorGUI();
        speeditem = new SpeedGUI();
        timegui = new TimeGUI();
        staffselector = new StaffSelectorGUI();
        saveDefaultConfig();
        //tasks
        getLogger().info("Registering tasks...");
        BukkitTask actionbartask = new ActionbarTask().runTaskTimerAsynchronously(this, 40, 40);
        BukkitTask scoreboardtask = new ScoreboardTask().runTaskTimerAsynchronously(this, 0, 20);

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            getLogger().info("Using PlaceholderAPI.");
        } else {
            getLogger().warning("Could not find PlaceholderAPI. This plugin is required");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        //Check to make sure luckperms is enabled, if its not then disable the plugin.
        if (!Bukkit.getPluginManager().isPluginEnabled("LuckPerms")) {
            getLogger().warning("LuckPerms is not enabled! Please either install it or enable it.");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            luckperms = getServer().getServicesManager().load(LuckPerms.class);
            getLogger().info("Found LuckPerms! Using...");
        }
        //Events
        getLogger().info("Registering events...");
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFoodChangeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DropListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProjectileLaunchListener(), this);
        if (Bukkit.getPluginManager().isPluginEnabled("Citizens")) {
            Bukkit.getPluginManager().registerEvents(new NPCRightClickListener(), this);
            getLogger().info("Registered NPC listener.");
        } else {
            getLogger().warning("Not registering NPC listener. Please install Citizens.");
        }
        if (Bukkit.getPluginManager().isPluginEnabled("WorldGuard")) {
            getLogger().info("WorldGuard is enabled... not registering fallback protection.");
        } else {
            Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
            Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
            getLogger().warning("WorldGuard is highly encouraged... registered fallback protection.");
        }
        Bukkit.getPluginManager().registerEvents(new EntityDismountListener(), this);
        //Commands
        getLogger().info("Registering commands...");
        getCommand("hubreload").setExecutor(new ReloadCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("vspeed").setExecutor(new VSpeedCommand());
        getCommand("sethub").setExecutor(new SetHubCommand());
        getCommand("iteminfo").setExecutor(new ItemInfoCommand());
        getLogger().info("Done! Took " + (System.currentTimeMillis() - start) + "ms");
    }

    public void onDisable() {
    }
}
