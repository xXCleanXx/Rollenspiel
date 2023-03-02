package com.roleplay.tiles.items;

public class ItemStack {
    private int size, maxSize;
    private Item item;

    public ItemStack(int maxSize, Item item) {
        setMaxSize(maxSize);
        setItem(item);
    }

    public void add() {
        if (getMaxSize() > getSize() + 1) throw new IndexOutOfBoundsException("Cannot add more items than allowed!");

        setSize(getSize() + 1);
    }

    private void remove() {
        this.setSize(this.getSize() - 1);
    }

    public Item getItem() {
        if (getSize() > 0) {
            remove();

            return item.clone();
        }

        return null;
    }

    private void setItem(Item item) {
        this.item = item;
    }

    public int getMaxSize() {
        return maxSize;
    }

    private void setMaxSize(int size) {
        if (size < 0 || size > 64) throw new IndexOutOfBoundsException("Size cannot be less than 0 or greater than 64!");

        maxSize = size;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        if (size < 0 || size > 64) throw new IndexOutOfBoundsException("Size cannot be less than 0 or greater than 64!");

        this.size = size;
    }
}