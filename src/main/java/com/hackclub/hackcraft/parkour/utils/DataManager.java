package com.hackclub.hackcraft.parkour.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.hackclub.hackcraft.parkour.ParkourPlugin;
import com.hackclub.hackcraft.parkour.objects.PlayerData;
import org.bukkit.entity.Player;

public class DataManager {
    private final ParkourPlugin plugin;
    private final String dataFolder;
    private final Map<UUID, PlayerData> players = new HashMap<>();

    public DataManager(ParkourPlugin plugin) {
        this.plugin = plugin;
        this.dataFolder = plugin.getDataFolder() + File.separator + "players";

        File folder = new File(this.dataFolder);
        folder.mkdirs();
    }

    public String getDataFolder() {
        return this.dataFolder;
    }

    public PlayerData getData(Player player) {
        return this.players.get(player.getUniqueId());
    }

    public void registerPlayer(Player player) {
        this.players.put(player.getUniqueId(), new PlayerData(this.plugin, player));
    }

    public void registerAll() {
        for (Player player : this.plugin.getServer().getOnlinePlayers()) {
            this.registerPlayer(player);
        }
    }

    public void unregisterPlayer(Player player) {

        this.players.remove(player.getUniqueId());
    }

    public void unregisterAll() {
        for (Player player : this.plugin.getServer().getOnlinePlayers()) {
            this.unregisterPlayer(player);
        }
    }
}
