package com.hackclub.hackcraft.parkour.objects;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ParkourRun {

    private ParkourPlugin plugin;
    private Player player;

    private ParkourMap map;
    private int lastCheckpoint;
    private long startTime;
    private long endTime;
    private long time;

    public ParkourRun(ParkourPlugin pl, Player player, ParkourMap map, Long startTime) {
        this.plugin = pl;
        this.player = player;
        this.map = map;
        this.startTime = startTime;
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
        return this.player.teleport(lastCheckpointLocation.clone().add(.5, .5, .5));
    }

    public Plugin getPlugin() {
        return plugin;
    }

}
