package me.kevind.listeners.npc;

import me.kevind.VibeHub;
import me.kevind.utils.MessageUtils;
import net.citizensnpcs.api.event.NPCRemoveEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class NPCDeleteListener implements Listener {
    @EventHandler
    public void onNPCListener(NPCRemoveEvent e) {
        NPC npc = e.getNPC();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("vibe.npcspy")) {
                MessageUtils.sendMessage(player, VibeHub.getPrefix() + "&9" + player.getDisplayName() + " &7created an NPC named &9" + npc.getName());

            }
        }
    }
}
