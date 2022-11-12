package me.kevind.listeners.npc;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
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
        String creativenpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.creative");
        String comingsoonnpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.comingsoon");
        String survivalnpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.survival");
        String skyblocknpc = VibeHub.getInstance().getConfig().getString("citizens.npcs.skyblock");


        ByteArrayDataOutput  out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");


        if (npc.getName().equalsIgnoreCase(creativenpc)) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7This server is coming soon!"));
            return;
        }
        if (npc.getName().equalsIgnoreCase(comingsoonnpc)) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7This server is coming soon!"));
            return;
        }
        if (npc.getName().equalsIgnoreCase(skyblocknpc)) {
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7This server is coming soon!"));
            return;
        }
        if (npc.getName().equalsIgnoreCase(survivalnpc)) {
            out.writeUTF("survival");
            player.sendMessage(ColorUtils.color(VibeHub.getPrefix() + "&7Sending you to &a&lSurvival&7."));
        }
        player.sendPluginMessage(VibeHub.getInstance(), "BungeeCord", out.toByteArray());
    }
}
