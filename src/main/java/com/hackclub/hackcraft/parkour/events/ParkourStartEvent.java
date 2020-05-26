package com.hackclub.hackcraft.parkour.listeners;

import com.hackclub.hackcraft.parkour.objects.ParkourMap;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ParkourStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;

    public ParkourStartEvent(Player player, ParkourMap map) {
    }

    public Player getPlayer() {
        return player;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
