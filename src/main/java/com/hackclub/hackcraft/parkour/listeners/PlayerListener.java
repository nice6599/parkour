package com.hackclub.hackcraft.parkour.listeners;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import net.md_5.bungee.api.ChatColor;

public class PlayerListener {

    private final ParkourPlugin plugin;

    public PlayerListener(ParkourPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        this.plugin.getDataManager().registerPlayer(event.getPlayer());
        // Set the initial active time


        // NOTE: Title isn't cleared when the player leaves the server
        event.getPlayer().resetTitle();
        event.setJoinMessage(ChatColor.YELLOW
                + ChatColor.stripColor(event.getPlayer().getDisplayName()) + " joined the game");
    }
}
