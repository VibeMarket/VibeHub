package me.kevind.vibehub.listeners.npc;

import me.kevind.vibehub.utils.BungeeUtils;
import me.kevind.vibehub.utils.ConfigUtils;
import me.kevind.vibehub.utils.MessageUtils;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class NPCRightClickListener implements Listener {

    @EventHandler
    public void onNPCRightClickEvent(NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker();
        String name = npc.getName();

        String survivalNpc = ConfigUtils.get(String.class, "citizens.npcs.survival");
        String skyblockNpc = ConfigUtils.get(String.class, "citizens.npcs.skyblock");
        String creativeNpc = ConfigUtils.get(String.class, "citizens.npcs.creative");
        String comingsoonNpc = ConfigUtils.get(String.class, "citizens.npcs.comingsoon");

        if (name.equalsIgnoreCase(survivalNpc)) {
            MessageUtils.message(player, "&7Sending you to &a&lSurvival&7.");
            BungeeUtils.connect(player, "survival");
        }

        if (name.equalsIgnoreCase(skyblockNpc)) {
            MessageUtils.message(player, "&7Sending you to &b&lSkyblock&7.");
            BungeeUtils.connect(player, "skyblock");
        }

        if (name.equalsIgnoreCase(creativeNpc)) {
            MessageUtils.message(player, "&7Sending you to &6&lCreative&7.");
            BungeeUtils.connect(player, "creative");
        }

        if (name.equalsIgnoreCase(comingsoonNpc))
            MessageUtils.message(player, "&7This server is coming soon!");
    }

}
