package com.hackclub.hackcraft.parkour.utils;

import com.hackclub.hackcraft.parkour.objects.ParkourMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PlayerUtil {

    private Plugin plugin;

    // teleports player to the start of a parkour map
    public void teleportParkour(Player player, ParkourMap map) {
        player.teleport(map.getSpawn());
    }

    // probably should be teleport lobby or something idk
    public void teleportSpawn(Player player) {
        player.teleport(plugin.getServer().getWorld("world").getSpawnLocation());
        // TODO: create a parkour world class or some way to store this data flexibly
    }


}
