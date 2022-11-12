package me.kevind.listeners.npc;

import me.kevind.main.VibeHub;
import me.kevind.utils.ColorUtils;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NPCRightClickEvent implements Listener {
    @EventHandler
    public void onNPCRightClickEvent(net.citizensnpcs.api.event.NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker().getPlayer();
        if (npc.getName().equalsIgnoreCase("§6§lCreative §7(Coming Soon)")) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7This server is coming soon!"));
        }
        if (npc.getName().equalsIgnoreCase("§c§lComing Soon §7(Right Click)")) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7This server is coming soon!"));
        }
        if (npc.getName().equalsIgnoreCase("§b§lSkyblock §7(Coming Soon)")) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7This server is coming soon!"));
        }
    }
}
