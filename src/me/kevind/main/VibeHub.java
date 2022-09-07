package me.kevind.main;

import me.filoghost.holographicdisplays.api.HolographicDisplaysAPI;
import me.filoghost.holographicdisplays.api.hologram.Hologram;
import me.filoghost.holographicdisplays.api.hologram.line.ItemHologramLine;
import me.kevind.commands.*;
import me.kevind.inventory.SelectorGUI;
import me.kevind.inventory.SpeedGUI;
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
    private Player player;
    String serverip = VibeHub.getInstance().getConfig().getString("messages.serverip");
    private final Location loc = new Location(Bukkit.getWorld("Hub2023"), 2.500, 70, 0.500, 91, 90);
    public static SelectorGUI getSelectorGUI() {
        return serverselector;
    }
    public static SpeedGUI getSpeedGUI() { return speeditem; }
    public static VibeHub getInstance() {
        return instance;
    }
    public static String getPrefix() { return instance.getConfig().getString("messages.prefix"); }

    public void onEnable() {
        instance = this;
        serverselector = new SelectorGUI();
        speeditem = new SpeedGUI();
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

        if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
            getLogger().warning("HolographicDisplays is not enabled");
            getLogger().warning("A part of this plugin will not work\nPlease install HolographicDisplays");
            HolographicDisplaysAPI api = HolographicDisplaysAPI.get(VibeHub.getInstance());
            Hologram hologram = api.createHologram(loc);
            ItemStack icon = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta playerHeadMeta = (SkullMeta) icon.getItemMeta();
            playerHeadMeta.setOwner(player.getName());
            icon.setItemMeta(playerHeadMeta);
            ItemHologramLine itemline1 = hologram.getLines().appendItem(icon);
            this.setEnabled(false);
            return;
        }

        //Events
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFoodChangeEvent(), this);
        //Commands
        getCommand("hubreload").setExecutor(new ReloadCommand());
        getCommand("idontwantspeed").setExecutor(new IDontWantSpeedCommand());
        getCommand("iwantspeed").setExecutor(new IWantSpeedCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("vspeed").setExecutor(new VSpeedCommand());
        getCommand("sethub").setExecutor(new SetHubCommand());
    }
    public void onDisable() {}
}
