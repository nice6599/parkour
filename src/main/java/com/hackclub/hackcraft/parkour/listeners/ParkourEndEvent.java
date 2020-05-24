package com.hackclub.hackcraft.parkour.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ParkourEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Player player;


    public ParkourEndEvent(Player player, String id, String name) {
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
