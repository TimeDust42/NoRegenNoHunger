package com.timedust.noRegenNoHunger.listeners;

import com.timedust.noRegenNoHunger.data.WorldData;
import com.timedust.noRegenNoHunger.managers.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {

    private final WorldManager worldManager;

    public FoodLevelChangeListener(WorldManager worldManager) {
        this.worldManager = worldManager;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        String worldName = player.getWorld().getName();

        WorldData data = worldManager.getWorldData(worldName);
        if (data == null) return;

        if (!data.isHungerEnabled()) {
            event.setCancelled(true);
        }
    }
}
