package com.hackclub.hackcraft.parkour.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.hackclub.hackcraft.parkour.ParkourPlugin;
import com.hackclub.hackcraft.parkour.objects.ParkourMap;
import com.hackclub.hackcraft.parkour.objects.PlayerData;
import org.bukkit.entity.Player;

public class PlayerUtil {

    private ParkourPlugin plugin;
    private final Map<UUID, PlayerData> players = new HashMap<>();


    // teleports player to the start of a parkour map
    public void teleportParkour(Player player, ParkourMap map) {
        player.teleport(map.getSpawn());
        plugin.getDataManager().getData(player).setCurrentMap(map);
    }

    // probably should be teleport lobby or something idk
    public void teleportSpawn(Player player) {
        player.teleport(plugin.getServer().getWorld("world").getSpawnLocation());
        plugin.getDataManager().getData(player).setCurrentMap(null);
        // TODO: create a parkour world class or some way to store this data flexibly
    }

}
