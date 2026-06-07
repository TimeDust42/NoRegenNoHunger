package com.timedust.noRegenAndHungerPlugin;

import com.timedust.noRegenAndHungerPlugin.commands.PluginReloadCommand;
import com.timedust.noRegenAndHungerPlugin.listeners.FoodLevelChangeListener;
import com.timedust.noRegenAndHungerPlugin.listeners.PlayerJoinListener;
import com.timedust.noRegenAndHungerPlugin.listeners.WorldLoadListener;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class NoRegenAndHungerPlugin extends JavaPlugin {

    public static final int MAX_FOOD_LEVEL = 20;
    public static final float MAX_SATURATION = 20.0f;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        boolean noNaturalRegen = this.getConfig().getBoolean("no-natural-regen");

        for (World world : Bukkit.getWorlds()) {
            updateRegenRule(world, noNaturalRegen);
        }

        getServer().getPluginManager().registerEvents(new WorldLoadListener(this), this);

        if (this.getConfig().getBoolean("no-food-regen")) {
            getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
            getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(this), this);

            for (Player player : getServer().getOnlinePlayers()) {
                setFullStats(player);
            }
        }

        Objects.requireNonNull(getCommand("noregenandhungerplugin")).setExecutor(new PluginReloadCommand(this));
    }

    public void updateRegenRule(World world, boolean disableRegen) {
        boolean targetGameRuleValue = !disableRegen;

        if (!Boolean.valueOf(targetGameRuleValue).equals(world.getGameRuleValue(GameRule.NATURAL_REGENERATION))) {
            world.setGameRule(GameRule.NATURAL_REGENERATION, targetGameRuleValue);

            if (this.getConfig().getBoolean("logging")) {
                String status = targetGameRuleValue ? "включена" : "отключена";
                this.getLogger().info("Регенерация " + status + " в мире: " + world.getName());
            }
        }
    }

    public static void setFullStats(Player player) {
        player.setFoodLevel(MAX_FOOD_LEVEL);
        player.setSaturation(MAX_SATURATION);
    }

    public void reloadPluginConfig() {
        this.reloadConfig();

        boolean noNaturalRegen = this.getConfig().getBoolean("no-natural-regen");
        for (World world : Bukkit.getWorlds()) {
            updateRegenRule(world, noNaturalRegen);
        }

        if (this.getConfig().getBoolean("no-food-regen")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                setFullStats(player);
            }
        }
    }
}
