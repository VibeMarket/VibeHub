package me.kevind.cosmetics.particles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Flame {
    public static void createParticle(Player player) {
        Location PlayerLocation = player.getLocation();
        World PlayerWorld = player.getWorld();
        PlayerWorld.spawnParticle(Particle.FLAME, PlayerLocation, 10);
    }
}

