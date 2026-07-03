package com.timedust.noRegenNoHunger.listeners;

import com.timedust.noRegenNoHunger.config.CustomConfig;
import com.timedust.noRegenNoHunger.managers.WorldManager;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public class WorldLoadListener implements Listener {

    private final CustomConfig config;
    private final WorldManager worldManager;

    public WorldLoadListener(CustomConfig config, WorldManager worldManager) {
        this.config = config;
        this.worldManager = worldManager;
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        World world = event.getWorld();
        String worldName = world.getName();

        if (!worldManager.contains(worldName)) {
            worldManager.addNewWorld(world);
        }
    }
}
