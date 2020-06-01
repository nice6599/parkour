package com.hackclub.hackcraft.parkour;

import com.hackclub.hackcraft.parkour.commands.ParkourAdminCommand;
import com.hackclub.hackcraft.parkour.listeners.CheckpointListener;
import com.hackclub.hackcraft.parkour.listeners.ComputerMapListener;
import com.hackclub.hackcraft.parkour.listeners.ParkourEndListener;
import com.hackclub.hackcraft.parkour.listeners.ParkourStartListener;
import com.hackclub.hackcraft.parkour.listeners.PlayerMoveListener;
import com.hackclub.hackcraft.parkour.objects.ParkourMap;
import com.hackclub.hackcraft.parkour.utils.ParkourUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class ParkourPlugin extends JavaPlugin {

    public ParkourUtil parkourUtil;

    @Override
    public void onEnable() {
        getLogger().info("Parkour activated!");

        // register serialization
        ConfigurationSerialization.registerClass(ParkourMap.class);

        // initialize custom objects
        parkourUtil = new ParkourUtil(this);
        parkourUtil.loadParkourMaps();

        // register commands
        this.getCommand("pkadmin").setExecutor(new ParkourAdminCommand(this));

        getServer().getPluginManager().registerEvents(new ComputerMapListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        getServer().getPluginManager().registerEvents(new CheckpointListener(this), this);
        getServer().getPluginManager().registerEvents(new ParkourStartListener(this), this);
        getServer().getPluginManager().registerEvents(new ParkourEndListener(this), this);



        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                parkourUtil.spawnCheckpointParticles();
            }
        }, 1L, 20L);
    }

    @Override
    public void onDisable() {
        getLogger().info("Parkour deactivated!");
    }
}
