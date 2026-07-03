package com.timedust.noRegenNoHunger.commands;

import com.timedust.noRegenNoHunger.NoRegenNoHunger;
import com.timedust.noRegenNoHunger.gui.WorldsGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PluginCommand implements CommandExecutor, TabCompleter {

    private final NoRegenNoHunger plugin;
    private final WorldsGUI gui;

    public PluginCommand(NoRegenNoHunger plugin, WorldsGUI gui) {
        this.plugin = plugin;
        this.gui = gui;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /" + label + " <worlds | reload>");
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("noregennohunger.reload")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }
            plugin.reloadPluginConfig();
            sender.sendMessage(ChatColor.GREEN + "Config reloaded!");
            return true;
        }

        if (args[0].equalsIgnoreCase("worlds")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "This command only for Players!");
                return true;
            }
            if (!sender.hasPermission("noregennohunger.worlds")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }
            Player player = (Player) sender;
            gui.openWorldList(player);
        }

        sender.sendMessage(ChatColor.RED + "Usage: /noregennohunger reload");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("reload", "worlds");
        }
        return Collections.emptyList();
    }
}
