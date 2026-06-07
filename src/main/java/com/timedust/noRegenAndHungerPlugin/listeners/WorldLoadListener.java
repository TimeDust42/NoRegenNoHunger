package com.timedust.noRegenAndHungerPlugin.listeners;

import com.timedust.noRegenAndHungerPlugin.NoRegenAndHungerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public class WorldLoadListener implements Listener {

    private final NoRegenAndHungerPlugin plugin;

    public WorldLoadListener(NoRegenAndHungerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        boolean noNaturalRegen = plugin.getConfig().getBoolean("no-natural-regen");
        plugin.updateRegenRule(event.getWorld(), noNaturalRegen);
    }
}
