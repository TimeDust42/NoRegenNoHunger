package com.timedust.noRegenAndHungerPlugin.listeners;

import com.timedust.noRegenAndHungerPlugin.NoRegenAndHungerPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {

    private final NoRegenAndHungerPlugin plugin;

    public FoodLevelChangeListener(NoRegenAndHungerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (plugin.getConfig().getBoolean("no-food-regen")) {
            if (event.getEntity() instanceof Player player) {
                event.setCancelled(true);

                NoRegenAndHungerPlugin.setFullStats(player);
            }
        }
    }
}
