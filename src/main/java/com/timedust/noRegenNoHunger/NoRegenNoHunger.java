package com.timedust.noRegenNoHunger;

import com.timedust.noRegenNoHunger.commands.PluginCommand;
import com.timedust.noRegenNoHunger.config.CustomConfig;
import com.timedust.noRegenNoHunger.gui.WorldsGUI;
import com.timedust.noRegenNoHunger.listeners.FoodLevelChangeListener;
import com.timedust.noRegenNoHunger.listeners.PlayerJoinListener;
import com.timedust.noRegenNoHunger.listeners.WorldLoadListener;
import com.timedust.noRegenNoHunger.listeners.WorldMenuClickListener;
import com.timedust.noRegenNoHunger.managers.WorldManager;
import com.timedust.noRegenNoHunger.test.ActionBarTask;
import com.timedust.noRegenNoHunger.test.CreateWorldCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class NoRegenNoHunger extends JavaPlugin {

    public static final String NAMESPACE = "noregennohunger";

    private CustomConfig worldsConfig;
    private WorldManager worldManager;
    private WorldsGUI worldsGUI;

    @Override
    public void onEnable() {
        // Init
        worldsConfig = new CustomConfig(this, "worlds.yml");

        worldManager = new WorldManager(worldsConfig);
        worldManager.loadSettingsFromConfig();

        worldsGUI = new WorldsGUI(worldManager);

        // Listeners
        getServer().getPluginManager().registerEvents(new WorldLoadListener(worldsConfig, worldManager), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(worldManager), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(worldManager), this);
        getServer().getPluginManager().registerEvents(new WorldMenuClickListener(worldsGUI), this);

        // Commands
        Objects.requireNonNull(getCommand("noregennohunger")).setExecutor(new PluginCommand(this, worldsGUI));
        // Objects.requireNonNull(getCommand("createworld")).setExecutor(new CreateWorldCommand());

        // Tasks
        // Bukkit.getScheduler().runTaskTimer(this, new ActionBarTask(), 20L, 20L);

        // Other
        worldManager.applyAllWorlds();
    }

    @Override
    public void onDisable() {
        worldManager.saveSettingsToConfig();
    }

    public void reloadPluginConfig() {
        this.reloadConfig();
        worldsConfig.reload();
        worldManager.loadSettingsFromConfig();
        worldManager.applyAllWorlds();
    }
}
