package me.kevind.vibehub.gui.guis.cosmetics;

import me.kevind.vibehub.gui.Gui;
import me.kevind.vibehub.gui.guis.staff.StaffCosmeticsGui;
import me.kevind.vibehub.utils.ItemList;
import me.kevind.vibehub.utils.MessageUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class ParticlesGui extends Gui {

    public ParticlesGui() {
        super(1, "Particles");

        setItem(1, 1, ItemList.FLAME_PARTICLE, (player, click) -> {
            if (click.isLeftClick()) {
                createParticle(player);
                MessageUtils.message(player, "&7Equipped &c&lFlame &7particle");
            } else if (click.isRightClick()) {
                removeParticle(player);
                MessageUtils.message(player, "&7Cleared particles.");
            }
        });
        setItem(1, 9, ItemList.GO_BACK, (player, click) -> {
            player.openInventory(Gui.get(StaffCosmeticsGui.class));
        });
    }

    // Testing methods
    public static void createParticle(Player player) {
        Location location = player.getLocation();
        World world = player.getWorld();

        world.spawnParticle(Particle.FLAME, location, 10);
    }

    public static void removeParticle(Player player) {
        Location location = player.getLocation();
        World world = player.getWorld();

        world.spawnParticle(Particle.FLAME, location, 0);
    }

}
