package com.hackclub.hackcraft.parkour.objects;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import org.bukkit.entity.Player;

public class PlayerData {
    private final ParkourPlugin plugin;
    private final Player player;


    // Session data (will be cleared when player quits)
    private ParkourRun currentRun = null;
    private ParkourMap currentMap = null;

    public PlayerData(ParkourPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;

    }

    public Player getPlayer() {
        return player;
    }

    public ParkourRun getCurrentRun() {
        return currentRun;
    }

    public void setCurrentRun(ParkourRun currentRun) {
        this.currentRun = currentRun;
    }

    public ParkourMap getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(ParkourMap currentMap) {
        this.currentMap = currentMap;
    }



}

