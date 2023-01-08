package me.kevind.listeners.npc;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.kevind.VibeHub;
import me.kevind.utils.ColorUtils;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class NPCRightClickListener implements Listener {
    @EventHandler
    public void onNPCRightClickEvent(NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker().getPlayer();
        String creativenpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.creative");
        String comingsoonnpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.comingsoon");
        String survivalnpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.survival");
        String skyblocknpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.skyblock");


        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");

        if (npc.getName().equalsIgnoreCase(creativenpc)) {
            out.writeUTF("creative");
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Sending you to &6&lCreative&7."));
        }
        if (npc.getName().equalsIgnoreCase(comingsoonnpc)) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7This server is coming soon!"));
            return;
        }
        if (npc.getName().equalsIgnoreCase(skyblocknpc)) {
            out.writeUTF("skyblock");
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Sending you to &b&lSkyblock&7."));
        }
        if (npc.getName().equalsIgnoreCase(survivalnpc)) {
            out.writeUTF("survival");
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Sending you to &a&lSurvival&7."));
        }
        player.sendPluginMessage(VibeHub.getInstance(), "BungeeCord", out.toByteArray());
    }
}
