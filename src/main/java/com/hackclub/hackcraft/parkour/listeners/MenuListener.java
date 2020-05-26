package com.hackclub.hackcraft.parkour.listeners;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class MenuListener implements Listener {


    public MenuListener(ParkourPlugin parkourPlugin) {
	}

	@EventHandler
    public void onPlayerInteract(final PlayerInteractEvent event) {
        System.out.println(event.getAction());
        if (event.getItem() != null) {
            System.out.println(event.getItem().getType());
            System.out.println(event.getItem().getItemMeta().getDisplayName());
        }
    }

}
