package me.kevind.listeners;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ProjectileLaunchListener implements Listener {
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity().getShooter() instanceof Player && event.getEntity() instanceof EnderPearl) {
            event.getEntity().setPassenger((Player)event.getEntity().getShooter());
        }
    }
}