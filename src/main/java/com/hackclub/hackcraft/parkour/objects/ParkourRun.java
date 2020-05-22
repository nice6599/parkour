package com.hackclub.hackcraft.parkour.objects;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import org.bukkit.entity.Player;

public class ParkourRun {

    private ParkourPlugin plugin;
    private Player player;

    private ParkourMap currentMap = null;
    private String lastCheckpoint = null;
    private long currentTime = 0;

    public ParkourRun(ParkourPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }


}
