package com.roleplay.items;

import com.roleplay.items.armors.Armor;

import javax.management.InstanceNotFoundException;

public class Inventory {
    public final int SLOT_SIZE = 48;
    private final Item[] items;
    private Item firstHand;
    private Item secondHand;
    private Armor armor;

    public Inventory(int size) {
        if (size < 0) {
            throw new IndexOutOfBoundsException("Size cannot be less than 0!");
        }

        items = new Item[size];
    }

    public boolean containsItem(String name) {
        for (Item i : items) {
            if (i != null && i.getProperties().getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMortal() {
        for (Item i : items) {
            if (i instanceof MortalInstruments) {
                return true;
            }
        }
        return false;
    }

    public int getItemIndexByName(String name) throws InstanceNotFoundException {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getProperties().getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        throw new InstanceNotFoundException("item does not exist!");
    }

    public Item get(int index) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        return items[index];
    }

    public int add(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null!");

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;

                return i;
            }
        }

        return -1;
    }

    public int length() {
        return items.length;
    }

    public Item getLast() {
        return items[items.length - 1];
    }

    public void add(int index, Item item) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        if (items[index] != null) {
            throw new IllegalArgumentException("Could not be set, because slot is not null!");
        }

        items[index] = item;
    }

    public void remove(int index) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        if (items[index] == null) {
            throw new IllegalArgumentException("There is nothing to remove!");
        }

        items[index] = null;
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

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Item swap(int index, Item newItem) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        Item oldItem = items[index];
        items[index] = newItem;

        return oldItem;
    }
}