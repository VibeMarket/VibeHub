package me.kevind.vibehub.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.kevind.vibehub.VibeHub;
import org.bukkit.entity.Player;

public final class BungeeUtils {

    public static void connect(Player player, String server) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(server);

        player.sendPluginMessage(VibeHub.getInstance(), "BungeeCord", output.toByteArray());
    }

}
