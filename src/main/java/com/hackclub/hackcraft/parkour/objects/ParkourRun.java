package com.hackclub.hackcraft.parkour.objects;

import com.hackclub.hackcraft.parkour.ParkourPlugin;

import org.bukkit.entity.Player;

public class ParkourRun {

    private ParkourPlugin plugin;
    private Player player;

    private ParkourMap map = null;
    private String lastCheckpoint = null;
    private long startTime = 0;

    public ParkourRun(ParkourPlugin plugin, Player player, ParkourMap map) {
        this.plugin = plugin;
        this.player = player;
        this.map = map;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long time) {
        this.startTime = time;
    }

    public String getLastCheckpoint() {
        return this.lastCheckpoint;
    }

    public void setLastCheckpoint(String newCheckpoint) {
        this.lastCheckpoint = newCheckpoint;
    }

    public ParkourMap getMap() {
        return this.map;
    }

}
