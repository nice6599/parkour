package com.hackclub.hackcraft.parkour.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import com.hackclub.hackcraft.parkour.objects.ParkourMap;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ParkourUtil {

    private Plugin plugin;
    private FileConfiguration parkourFile;
    private ArrayList<ParkourMap> parkourMaps;
    private String menuId;


    File file;


    public ParkourUtil(Plugin pl) {
        plugin = pl;
        file = new File(plugin.getDataFolder(), "parkour.yml");
        parkourFile = YamlConfiguration.loadConfiguration(file);
        parkourMaps = new ArrayList<ParkourMap>();
    }

    public void setMenu(String id) {
        menuId = id;
    }

    public String getMenu() {
        return menuId;
    }

    public boolean saveParkourMap(ParkourMap pm) {
        parkourFile.set("parkours." + pm.getId(), pm);
        try {
            parkourFile.save(file);
            return true;
        } catch (IOException e) {
            plugin.getLogger().severe("Error whilst try to save ParkourMap:");
            plugin.getLogger().severe(e.getMessage());
            return false;
        }
    }

    public Optional<ParkourMap> getFromID(String id) {
        Optional<ParkourMap> pm =
                getParkourMaps().stream().filter(m -> m.getId().equals(id)).findFirst();

        return pm;
    }

    public ArrayList<ParkourMap> loadParkourMaps() {
        parkourMaps.clear();


        ((MemorySection) parkourFile.get("parkours")).getValues(true).forEach((k, v) -> {
            ParkourMap pm = (ParkourMap) v;
            if (pm.getSpawn() == null) {
                pm.setSpawn(new Location(plugin.getServer().getWorld("world"), 0, 0, 0));
                if (saveParkourMap(pm)) {
                    plugin.getLogger().log(Level.INFO,
                            "New Spawnpoint Created for " + pm.getName());
                } else {
                    plugin.getLogger().log(Level.WARNING, pm.getName() + " has no spawnpoint set");
                }
            }
            parkourMaps.add(pm);

        });

        return parkourMaps;
    }

    public ArrayList<ParkourMap> getParkourMaps() {
        return parkourMaps;
    }


    public void spawnCheckpointParticles() {
        getParkourMaps().forEach((p) -> p.getCheckpoints().forEach((c) -> {
            // 204, 14, 0 is a dark red
            Particle.DustOptions du = new Particle.DustOptions(Color.fromRGB(204, 14, 0), 2);
            c.getWorld().spawnParticle(Particle.REDSTONE, c.clone().add(.5, 1, .5), 50, du);
        }));
    }

}
