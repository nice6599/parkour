package com.hackclub.hackcraft.parkour.listeners;

import com.hackclub.hackcraft.parkour.ParkourPlugin;
import com.hackclub.hackcraft.parkour.events.ParkourStartEvent;
import com.hackclub.hackcraft.parkour.objects.ParkourRun;
import com.hackclub.hackcraft.parkour.objects.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ParkourStartListener implements Listener {
    private ParkourPlugin pl;

    public ParkourStartListener(ParkourPlugin pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onParkourStart(ParkourStartEvent event) {
        ParkourRun run = new ParkourRun(pl, event.getPlayer(), event.getMap(), event.getTime());
        PlayerData data = pl.getDataManager().getData(event.getPlayer());
        data.setCurrentRun(run);
        pl.itemMenuUtil.giveItemMenu(event.getPlayer(), pl.parkourUtil.getMenu());

    }
}
