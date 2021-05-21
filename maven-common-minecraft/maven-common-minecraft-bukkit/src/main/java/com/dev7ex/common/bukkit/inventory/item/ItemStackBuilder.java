package com.dev7ex.common.bukkit.inventory.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 *
 * @author Dev7ex
 * @since 04.08.2019
 *
 */

public final class ItemStackBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemStackBuilder(final ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    /**
     * Creates a new itemstack
     *
     * @param material the material of the item
     */
    public ItemStackBuilder(final Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    /**
     * Creates a new itemstack
     *
     * @param material the material of the item
     * @param amount the amount of the item
     */
    public ItemStackBuilder(final Material material, final int amount) {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    /**
     * Sets the name of the item
     *
     * @param name name of the item
     * @return ItemBuilder
     */
    public ItemStackBuilder setDisplayName(final String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    /**
     * Sets the lore of the item
     *
     * @param lore lore of the item
     * @return ItemBuilder
     */
    public ItemStackBuilder setLore(final String... lore) {
        this.itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    /**
     * Sets the item unbreakable
     *
     */
    public ItemStackBuilder setUnbreakable(final boolean unbreakable) {
        this.itemMeta.setUnbreakable(unbreakable);
        return this;
    }

    /**
     * Sets the enchantment of the item
     *
     * @param enchantment the enchantment type of the item
     * @param level the level of the item
     * @return ItemBuilder
     */
    public ItemStackBuilder addEnchantment(final Enchantment enchantment, int level) {
        this.itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    /**
     * Sets the amount of the item
     *
     * @param amount the amount of the item
     * @return ItemBuilder
     */
    public ItemStackBuilder setAmount(final int amount) {
        if(amount > 64) {
            throw new IllegalArgumentException("The amount cannot be greater than 64.");
        }
        this.itemStack.setAmount(amount);
        return this;
    }

    /**
     * Sets the amount of the item
     *
     * @param modelData the modelData
     * @return ItemBuilder
     */
    public final ItemStackBuilder setCustomModelData(final int modelData) {
        this.itemMeta.setCustomModelData(modelData);
        return this;
    }

    /**
     * Builds the ItemStack
     *
     * @return Finished ItemStack
     */
    public final ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

}