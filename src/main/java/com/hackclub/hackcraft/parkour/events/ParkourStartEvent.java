package com.hackclub.hackcraft.parkour.events;

import com.hackclub.hackcraft.parkour.objects.ParkourMap;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ParkourStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private ParkourMap map;
    private Long time;

    public ParkourStartEvent(Player player, ParkourMap map) {
        this.player = player;
        this.map = map;
        this.time = System.nanoTime();
    }

    public Player getPlayer() {
        return player;
    }

    public ParkourMap getMap() {
        return map;
    }

    public Long getTime() {
        return time;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
