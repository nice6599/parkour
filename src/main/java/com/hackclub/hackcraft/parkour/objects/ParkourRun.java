package com.hackclub.hackcraft.parkour.objects;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ParkourRun {

    private ParkourPlugin plugin;
    private Player player;

    private ParkourMap map = null;
    private int lastCheckpoint = null;
    private long startTime = 0;
    private long endTime = 0;
    private long time = 0;

    public ParkourRun(ParkourPlugin plugin, Player player, ParkourMap map) {
        this.plugin = plugin;
        this.player = player;
        this.map = map;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public Long getTime() {
        return this.time;
    }

    public int getLastCheckpoint() {
        return this.lastCheckpoint;
    }

    public ParkourMap getMap() {
        return this.map;
    }

    public void setStartTime(Long time) {
        this.startTime = time;
    }

    public void setEndTime(Long time) {
        this.endTime = time;
        this.time = (this.endTime - this.startTime);
    }

    public void setLastCheckpoint(int index) {
        this.lastCheckpoint = index;
    }

    public boolean gotoLastCheckpoint() {
        Location lastCheckpointLocation = this.map.getCheckpointLocation(this.lastCheckpoint);
        return this.player.teleport(lastCheckpointLocation);
    }

}
