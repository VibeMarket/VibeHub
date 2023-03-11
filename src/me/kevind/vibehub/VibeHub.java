package me.kevind.vibehub;

import me.kevind.vibehub.commands.*;
import me.kevind.vibehub.cosmetics.cosmetics.ArmorsGUI;
import me.kevind.vibehub.cosmetics.cosmetics.ParticlesGUI;
import me.kevind.vibehub.gui.guis.CosmeticsGui;
import me.kevind.vibehub.gui.guis.SelectorGui;
import me.kevind.vibehub.gui.guis.SpeedGui;
import me.kevind.vibehub.gui.guis.TimeGui;
import me.kevind.vibehub.gui.guis.staff.StaffCosmeticsGui;
import me.kevind.vibehub.gui.guis.staff.StaffSelectorGui;
import me.kevind.vibehub.inventory.item.CosmeticsGUI;
import me.kevind.vibehub.inventory.item.SpeedGUI;
import me.kevind.vibehub.inventory.item.TimeGUI;
import me.kevind.vibehub.inventory.item.selector.SelectorGUI;
import me.kevind.vibehub.inventory.staff.StaffCosmeticsGUI;
import me.kevind.vibehub.inventory.staff.StaffSelectorGUI;
import me.kevind.vibehub.listeners.inventory.InteractListener;
import me.kevind.vibehub.listeners.inventory.InventoryClickListener;
import me.kevind.vibehub.listeners.item.ProjectileLaunchListener;
import me.kevind.vibehub.listeners.npc.NPCCreateListener;
import me.kevind.vibehub.listeners.npc.NPCDeleteListener;
import me.kevind.vibehub.listeners.npc.NPCRightClickListener;
import me.kevind.vibehub.listeners.player.*;
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
    private static SelectorGUI serverselector;
    private static SpeedGUI speeditem;
    private static TimeGUI timegui;
    private static StaffSelectorGUI staffselector;
    private static CosmeticsGUI cosmetics;
    private static ArmorsGUI armorsGUI;
    private static ParticlesGUI particlesGUI;
    private static StaffCosmeticsGUI staffCosmeticsGUI;

    public static VibeHub getInstance() {
        return instance;
    }

    public static LuckPerms getLuckPerms() {
        return luckperms;
    }

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

    public static ArmorsGUI getArmorsGUI() {
        return armorsGUI;
    }

    public static ParticlesGUI getParticlesGUI() {
        return particlesGUI;
    }

    public static StaffCosmeticsGUI getStaffCosmeticsGUI(){
        return staffCosmeticsGUI;
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

        serverselector = new SelectorGUI();
        speeditem = new SpeedGUI();
        timegui = new TimeGUI();
        staffselector = new StaffSelectorGUI();
        cosmetics = new CosmeticsGUI();
        armorsGUI = new ArmorsGUI();
        particlesGUI = new ParticlesGUI();
        staffCosmeticsGUI = new StaffCosmeticsGUI();

        // Listeners
        logger.info("Registering listeners...");
        pluginManager.registerEvents(new InteractListener(), this);
        pluginManager.registerEvents(new InventoryClickListener(), this);

        pluginManager.registerEvents(new ProjectileLaunchListener(), this);

        pluginManager.registerEvents(new EntityDismountListener(), this);
        pluginManager.registerEvents(new FoodLevelChangeListener(), this);
        pluginManager.registerEvents(new PlayerDropItemListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);

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
