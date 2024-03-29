package com.roleplay.tiles.items;

import com.roleplay.tiles.items.armors.Armor;

public class Inventory {
    private final ItemStack[] items;
    private Item firstHand;
    private Item secondHand;
    private Armor armor;

    public Inventory(int size) {
        if (size < 0) {
            throw new IndexOutOfBoundsException("Size cannot be less than 0!");
        }

        items = new ItemStack[size];
    }

    public ItemStack get(int index) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        return items[index];
    }

    public void add(int index, ItemStack itemStack) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        if (items[index] != null) {
            throw new IllegalArgumentException("Could not be set, because slot is not null!");
        }

        items[index] = itemStack;
    }

    public ItemStack remove(int index) {
        if (items[index] == null) {
            throw new IllegalArgumentException("There is nothing to remove!");
        }

        return swap(index, null);
    }

    public Item getFirstHand() {
        return firstHand;
    }

    public void setFirstHand(Item item) {
        firstHand = item;
    }

    public void setSecondHand(Item item) {
        secondHand = item;
    }

    public Item getSecondHand() {
        return secondHand;
    }

    public void setArmor(Armor armor) {
        if (this.armor != null) {
            throw new IllegalArgumentException("Cannot wear another armor!");
        }

        this.armor = armor;
    }

    public ItemStack swap(int index, ItemStack newItemStack) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        ItemStack oldItemStack = items[index];
        items[index] = newItemStack;

        return oldItemStack;
    }
}