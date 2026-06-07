package com.timedust.noRegenAndHungerPlugin.commands;

import com.timedust.noRegenAndHungerPlugin.NoRegenAndHungerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.List;

public class PluginReloadCommand implements CommandExecutor, TabCompleter {

    private final NoRegenAndHungerPlugin plugin;

    public PluginReloadCommand(NoRegenAndHungerPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("noregenandhungerplugin.reload")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.reloadPluginConfig();
            sender.sendMessage(ChatColor.GREEN + "Config reloaded!");
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Usage: /noregenandhungerplugin reload");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Collections.singletonList("reload");
        }
        return Collections.emptyList();
    }
}
