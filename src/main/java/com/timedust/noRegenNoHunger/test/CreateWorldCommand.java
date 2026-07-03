package com.timedust.noRegenNoHunger.test;

import com.timedust.noRegenNoHunger.NoRegenNoHunger;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateWorldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(NoRegenNoHunger.NAMESPACE + ".test")) {
            sender.sendMessage("You do not have permission to execute this command.");
            return true;
        }

        if (args.length == 1) {
            WorldCreator creator = new WorldCreator(args[0]);
            creator.environment(World.Environment.NORMAL);
            creator.type(WorldType.FLAT);

            World customWorld = Bukkit.createWorld(creator);

            if (sender instanceof Player) {
                ((Player) sender).teleport(new Location(customWorld, 100, 100, 100));
            }
        }

        return false;
    }
}
