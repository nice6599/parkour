package com.hackclub.hackcraft.parkour.listeners;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class MenuListener implements Listener {
    ParkourPlugin plugin;



    public MenuListener(ParkourPlugin parkourPlugin) {
        this.plugin = parkourPlugin;
    }

    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if (event.getItem() != null) {

            switch (event.getItem().getItemMeta().getDisplayName().toLowerCase()) {
                case "checkpoint":
                    plugin.getDataManager().getData(event.getPlayer()).getCurrentRun()
                            .gotoLastCheckpoint();
                    return;


            }
        }

    }

}
