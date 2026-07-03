package com.timedust.noRegenNoHunger.managers;

import com.timedust.noRegenNoHunger.config.CustomConfig;
import com.timedust.noRegenNoHunger.data.WorldData;
import com.timedust.noRegenNoHunger.utils.HealthFoodUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class WorldManager {

    private final CustomConfig customConfig;

    private final Map<String, WorldData> worlds = new HashMap<>();

    public WorldManager(CustomConfig customConfig) {
        this.customConfig = customConfig;
    }

    public void loadSettingsFromConfig() {
        worlds.clear();
        FileConfiguration config = customConfig.getConfig();
        ConfigurationSection worldSection = config.getConfigurationSection("worlds");

        if (worldSection == null) return;

        for (String worldName : worldSection.getKeys(false)) {
            boolean regenEnabled = worldSection.getBoolean(worldName + ".regen-enabled", false);
            boolean hungerEnabled = worldSection.getBoolean(worldName + ".hunger-enabled", false);

            WorldData data = new WorldData(worldName, regenEnabled, hungerEnabled);

            worlds.put(worldName, data);
        }
    }

    public void saveSettingsToConfig() {
        FileConfiguration config = customConfig.getConfig();

        config.set("worlds", null);

        for (Map.Entry<String, WorldData> entry : worlds.entrySet()) {
            String worldName = entry.getValue().getWorldName();
            WorldData data = entry.getValue();

            String path = "worlds." + worldName;

            config.set(path + ".regen-enabled", data.isRegenEnabled());
            config.set(path + ".hunger-enabled", data.isHungerEnabled());
        }

        customConfig.save();
    }

    public void addNewWorld(World world) {
        worlds.put(world.getName(), HealthFoodUtils.createDefaultWorldData(world));
        applyWorldSettings(world);
    }

    public void applyWorldSettings(World world) {
        String name = world.getName();
        WorldData data = worlds.get(name);

        if (data == null) {
            worlds.put(name, HealthFoodUtils.createDefaultWorldData(world));
            HealthFoodUtils.applyRegenRule(world, worlds.get(name).isRegenEnabled());
            return;
        }

        HealthFoodUtils.applyRegenRule(world, data.isRegenEnabled());
    }

    public void applyAllWorlds() {
        for (World world : Bukkit.getWorlds()) {
            applyWorldSettings(world);
        }
    }

    public WorldData getWorldData(String world) {
        return worlds.get(world);
    }

    public boolean contains(String worldName) {
        return worlds.containsKey(worldName);
    }

    public Collection<WorldData> getAllWorldData() {
        return Collections.unmodifiableCollection(worlds.values());
    }
}
