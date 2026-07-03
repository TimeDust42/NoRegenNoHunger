package com.timedust.noRegenNoHunger.listeners;

import com.timedust.noRegenNoHunger.gui.CustomMenuHolder;
import com.timedust.noRegenNoHunger.gui.WorldsGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WorldMenuClickListener implements Listener {

    private final WorldsGUI worldsGUI;

    public WorldMenuClickListener(WorldsGUI worldsGUI) {
        this.worldsGUI = worldsGUI;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        if (inventory == null) return;

        if (inventory.getHolder() instanceof CustomMenuHolder) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ClickType type = event.getClick();
            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem == null) return;

            worldsGUI.updateData(player, clickedItem, inventory, event.getSlot(), type);
        }
    }

}
