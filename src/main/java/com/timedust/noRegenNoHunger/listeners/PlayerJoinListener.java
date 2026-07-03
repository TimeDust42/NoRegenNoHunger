package com.timedust.noRegenNoHunger.listeners;

import com.timedust.noRegenNoHunger.data.WorldData;
import com.timedust.noRegenNoHunger.managers.WorldManager;
import com.timedust.noRegenNoHunger.utils.HealthFoodUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final WorldManager worldManager;

    public PlayerJoinListener(WorldManager worldManager) {
        this.worldManager = worldManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String worldName = player.getWorld().getName();

        WorldData data = worldManager.getWorldData(worldName);
        if (data == null) return;

        if (!data.isHungerEnabled()) {
            HealthFoodUtils.setHunger(player);
        }
    }

}
