package com.timedust.noRegenAndHungerPlugin.listeners;

import com.timedust.noRegenAndHungerPlugin.NoRegenAndHungerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final NoRegenAndHungerPlugin plugin;

    public PlayerJoinListener(NoRegenAndHungerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (plugin.getConfig().getBoolean("no-food-regen")) {
            NoRegenAndHungerPlugin.setFullStats(event.getPlayer());
        }
    }

}
