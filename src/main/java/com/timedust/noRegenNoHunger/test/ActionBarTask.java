package com.timedust.noRegenNoHunger.test;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActionBarTask implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.isOp()) return;

            String builder = "Hunger: " +
                    player.getFoodLevel() +
                    " / 20 | Saturation: " +
                    player.getSaturation() +
                    " / " + player.getFoodLevel();
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(builder));
        }
    }
}
