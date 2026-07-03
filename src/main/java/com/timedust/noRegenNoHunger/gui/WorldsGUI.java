package com.timedust.noRegenNoHunger.gui;

import com.timedust.noRegenNoHunger.data.WorldData;
import com.timedust.noRegenNoHunger.managers.WorldManager;
import com.timedust.noRegenNoHunger.utils.HealthFoodUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class WorldsGUI {

    private final WorldManager worldManager;

    public WorldsGUI(WorldManager worldManager) {
        this.worldManager = worldManager;
    }

    public void openWorldList(Player player) {
        CustomMenuHolder holder = new CustomMenuHolder();
        Inventory gui = Bukkit.createInventory(holder, 27, "§0Выбор мира");

        for (WorldData data : worldManager.getAllWorldData()) {
            String displayName = ChatColor.GREEN + data.getWorldName();
            ItemStack worldButton = createItem(Material.DIRT, displayName, createLore(data));
            gui.addItem(worldButton);
        }

        player.openInventory(gui);
    }

    private static ItemStack createItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        return item;
    }

    public List<String> createLore(WorldData data) {
        return Arrays.asList(
                ChatColor.GRAY + "Настройки:",
                data.isHungerEnabled() ? "§7Голод: §aВключён §e[ЛКМ]" : "§7Голод: §cВыключён §e[ЛКМ]",
                data.isRegenEnabled()  ? "§7Регенерация: §aВключена §e[ПКМ]" : "§7Регенерация: §cВыключена §e[ПКМ]"
        );
    }

    public void updateData(Player player, ItemStack item, Inventory inventory, int slot, ClickType type) {
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) return;

        String worldName = ChatColor.stripColor(item.getItemMeta().getDisplayName());

        WorldData data = worldManager.getWorldData(worldName);

        if (data == null) return;

        if (type.isLeftClick()) {
            boolean newState = !data.isHungerEnabled();
            if (!newState) {
                HealthFoodUtils.setHunger(player);
            }

            data.setHungerEnabled(newState);
        } else if (type.isRightClick()) {
            data.setRegenEnabled(!data.isRegenEnabled());
            worldManager.applyAllWorlds();
        } else {
            return;
        }

        ItemStack updatedButton = createItem(item.getType(), item.getItemMeta().getDisplayName(), createLore(data));
        inventory.setItem(slot, updatedButton);

        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
    }
}
