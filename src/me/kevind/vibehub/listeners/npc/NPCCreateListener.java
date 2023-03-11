package me.kevind.vibehub.listeners.npc;

import me.kevind.vibehub.utils.MessageUtils;
import net.citizensnpcs.api.event.NPCCreateEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class NPCCreateListener implements Listener {

    @EventHandler
    public void onNPCCreate(NPCCreateEvent event) {
        NPC npc = event.getNPC();

        for (Player player : Bukkit.getOnlinePlayers())
            if (player.hasPermission("vibe.npcspy"))
                MessageUtils.message(player, "&9" + player.getDisplayName() + " &7created an NPC named &9" + npc.getName());
    }

}
