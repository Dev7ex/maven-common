package com.dev7ex.common.bukkit.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Dev7ex
 * @since 19.05.2021
 *
 */

public final class Inventorys {

    private Inventorys() {}

    public static Inventory createInventory(final String title, final int size) {
        return Bukkit.createInventory(null, size, title);
    }

    public static Inventory createFilledInventory(final String title, final int size, final ItemStack itemStack) {
        final Inventory currentInventory = Bukkit.createInventory(null, size, title);

        for(int i = 0; i < size; i++) {
            currentInventory.setItem(i, itemStack);
        }
        return currentInventory;
    }

}
