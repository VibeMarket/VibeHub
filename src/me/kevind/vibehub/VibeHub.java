package me.kevind.vibehub;

import me.kevind.vibehub.commands.*;
import me.kevind.vibehub.gui.guis.CosmeticsGui;
import me.kevind.vibehub.gui.guis.SelectorGui;
import me.kevind.vibehub.gui.guis.SpeedGui;
import me.kevind.vibehub.gui.guis.TimeGui;
import me.kevind.vibehub.gui.guis.cosmetics.ArmorsGui;
import me.kevind.vibehub.gui.guis.cosmetics.ParticlesGui;
import me.kevind.vibehub.gui.guis.staff.StaffCosmeticsGui;
import me.kevind.vibehub.gui.guis.staff.StaffSelectorGui;
import me.kevind.vibehub.listeners.entity.EntityDismountListener;
import me.kevind.vibehub.listeners.entity.ProjectileLaunchListener;
import me.kevind.vibehub.listeners.inventory.InteractListener;
import me.kevind.vibehub.listeners.npc.NPCCreateListener;
import me.kevind.vibehub.listeners.npc.NPCDeleteListener;
import me.kevind.vibehub.listeners.npc.NPCRightClickListener;
import me.kevind.vibehub.listeners.player.*;
import me.kevind.vibehub.listeners.world.WeatherChangeListener;
import me.kevind.vibehub.tasks.ActionbarTask;
import me.kevind.vibehub.tasks.ScoreboardUpdateTask;
import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;
import java.util.logging.Logger;

public final class VibeHub extends JavaPlugin {

    private static VibeHub instance;
    private static LuckPerms luckperms;

    public static VibeHub getInstance() {
        return instance;
    }

    public static LuckPerms getLuckPerms() {
        return luckperms;
    }

    @Override
    public void onEnable() {
        long start = System.currentTimeMillis();
        Logger logger = getLogger();
        PluginManager pluginManager = getServer().getPluginManager();

        // Ensure dependencies are enabled.
        if (!pluginManager.isPluginEnabled("PlaceholderAPI")) {
            logger.severe("Could not find PlaceholderAPI. This plugin is required.");
            pluginManager.disablePlugin(this);
        }

        if (!pluginManager.isPluginEnabled("LuckPerms")) {
            logger.severe("Could not find LuckPerms. This plugin is required.");
            pluginManager.disablePlugin(this);
        }

        saveDefaultConfig();

        instance = this;
        luckperms = getServer().getServicesManager().load(LuckPerms.class);

        Messenger messenger = getServer().getMessenger();
        messenger.registerOutgoingPluginChannel(this, "BungeeCord");

        // Listeners
        logger.info("Registering listeners...");
        pluginManager.registerEvents(new EntityDismountListener(), this);
        pluginManager.registerEvents(new ProjectileLaunchListener(), this);

        pluginManager.registerEvents(new InteractListener(), this);

        pluginManager.registerEvents(new FoodLevelChangeListener(), this);
        pluginManager.registerEvents(new PlayerDropItemListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);

        pluginManager.registerEvents(new WeatherChangeListener(), this);

        if (pluginManager.isPluginEnabled("Citizens")) {
            pluginManager.registerEvents(new NPCRightClickListener(), this);
            pluginManager.registerEvents(new NPCDeleteListener(), this);
            pluginManager.registerEvents(new NPCCreateListener(), this);

            logger.info("Registered NPC listeners. NPC Spy is enabled.");
        } else
            logger.warning("Not registering NPC listener. Please install Citizens.");

        if (pluginManager.isPluginEnabled("WorldGuard"))
            logger.info("WorldGuard is enabled... not registering fallback protection.");
        else {
            pluginManager.registerEvents(new BlockBreakListener(), this);
            pluginManager.registerEvents(new BlockPlaceListener(), this);

            logger.warning("WorldGuard is highly encouraged... registered fallback protection.");
        }

        // GUIs
        new ArmorsGui();
        new ParticlesGui();

        new StaffCosmeticsGui();
        new StaffSelectorGui();

        new CosmeticsGui();
        new SelectorGui();
        new SpeedGui();
        new TimeGui();

        // Tasks
        logger.info("Registering tasks...");
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.runTaskTimerAsynchronously(this, new ActionbarTask(), 40, 40);
        scheduler.runTaskTimerAsynchronously(this, new ScoreboardUpdateTask(), 20, 20);

        // Commands
        logger.info("Registering commands...");
        //getCommand("actionbar").setExecutor(new ActionbarCommand());
        Objects.requireNonNull(getCommand("build")).setExecutor(new BuildCommand());
        Objects.requireNonNull(getCommand("cosmetics")).setExecutor(new CosmeticsCommand());
        Objects.requireNonNull(getCommand("particles")).setExecutor(new ParticlesComand());
        Objects.requireNonNull(getCommand("hubreload")).setExecutor(new ReloadCommand());
        //getCommand("scoreboard").setExecutor(new ScoreboardCommand());
        Objects.requireNonNull(getCommand("sethub")).setExecutor(new SetHubCommand());
        Objects.requireNonNull(getCommand("vspeed")).setExecutor(new VSpeedCommand());

        logger.info("Done! Took " + (System.currentTimeMillis() - start) + "ms");
    }

}
