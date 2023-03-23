package com.roleplay.items;

import com.roleplay.items.armors.Armor;
import com.roleplay.tools.ImageUtils;

import java.awt.image.BufferedImage;
import java.util.Objects;

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

    public Item remove(int index) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

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

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        if (this.armor != null) {
            throw new IllegalArgumentException("Cannot wear another armor!");
        }

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

    public BufferedImage drawInventory(int width, int height) {
        int rows = this.items.length / 6;

        BufferedImage img = new BufferedImage(width * 6, height * rows, BufferedImage.TYPE_INT_ARGB);
        BufferedImage slotImg = ImageUtils.loadImage("src/com/roleplay/resources/slot.png");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int x = 0; x < SLOT_SIZE; x++) {
                    for (int y = 0; y < SLOT_SIZE; y++) {
                        img.setRGB(i + x * SLOT_SIZE, j + y * SLOT_SIZE, Objects.requireNonNull(slotImg).getRGB(x, y));
                    }
                }
            }
        }

        return img;
    }
}