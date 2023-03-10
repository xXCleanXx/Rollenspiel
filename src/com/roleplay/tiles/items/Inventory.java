package com.roleplay.tiles.items;

import com.roleplay.tiles.items.armors.Armor;
import com.roleplay.tools.ImageUtils;

import java.awt.image.BufferedImage;

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

    public BufferedImage drawInventory() {
        int height = this.items.length / 6;

        BufferedImage img = new BufferedImage(SLOT_SIZE * 6, SLOT_SIZE * height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage slotImg = ImageUtils.loadImage("src/com/roleplay/resources/slot.png");

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                for (int k = 0; k < SLOT_SIZE; k++) {
                    for (int l = 0; l < SLOT_SIZE; l++) {
                        img.setRGB(i, j, slotImg.getRGB(k, l));
                    }
                }
            }
        }

        return img;
    }
}