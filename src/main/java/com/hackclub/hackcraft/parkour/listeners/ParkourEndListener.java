package com.hackclub.hackcraft.parkour.listeners;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import com.hackclub.hackcraft.parkour.events.ParkourEndEvent;
import com.hackclub.hackcraft.parkour.objects.ParkourRun;
import com.hackclub.hackcraft.parkour.objects.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ParkourEndListener implements Listener {
    private ParkourPlugin pl;

    public ParkourEndListener(ParkourPlugin pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onParkourEnd(ParkourEndEvent event) {
        PlayerData data = pl.getDataManager().getData(event.getPlayer());
        ParkourRun run = data.getCurrentRun();
        run.setEndTime(event.getTime());
        event.getPlayer().sendMessage(run.getTime().toString());
    }
}
