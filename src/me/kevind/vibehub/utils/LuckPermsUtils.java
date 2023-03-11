package me.kevind.vibehub.utils;

import me.kevind.vibehub.VibeHub;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.entity.Player;

import java.util.UUID;

public final class LuckPermsUtils {

    private static final UserManager manager = VibeHub.getLuckPerms().getUserManager();

    public static User getUser(Player player) {
        UUID uuid = player.getUniqueId();

        if (!manager.isLoaded(uuid))
            manager.loadUser(uuid);

        return manager.getUser(uuid);
    }

}
