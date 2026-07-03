package com.timedust.noRegenNoHunger.utils;

import com.timedust.noRegenNoHunger.data.WorldData;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class HealthFoodUtils {

    public static final int MAX_FOOD_LEVEL = 20;
    public static final float SATURATION = 0.0f;

    public static void setHunger(Player player) {
        player.setFoodLevel(MAX_FOOD_LEVEL);
        player.setSaturation(SATURATION);
    }

    public static void applyRegenRule(World world, boolean ruleValue) {
        world.setGameRule(GameRule.NATURAL_REGENERATION, ruleValue);
    }

    public static WorldData createDefaultWorldData(World world) {
        String worldName = world.getName();

        return new WorldData(worldName, false, false);
    }
}
