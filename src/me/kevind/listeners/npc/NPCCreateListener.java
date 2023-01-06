package me.kevind.listeners.npc;

import me.kevind.main.VibeHub;
import me.kevind.utils.MessageUtils;
import me.kevind.utils.PlayerUtils;
import net.citizensnpcs.api.event.NPCCreateEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class NPCCreateListener implements Listener {
    @EventHandler
    public void onNPCCreate(NPCCreateEvent e) {
        NPC npc = e.getNPC();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("vibe.npcspy")) {
                MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&9" + player.getDisplayName() + " &7created an NPC named &9" + npc.getName());
            }
        }
    }
}
