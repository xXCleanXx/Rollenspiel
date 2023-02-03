package com.roleplay.items;

public class ItemStack<T> {
    private int _size;

    public ItemStack(int size) {
        this.setSize(size);
    }

    public int getSize() {
        return this._size;
    }

    private void setSize(int size) {
        if (size < 0) throw new IndexOutOfBoundsException("Size cannot be less than 0!");

        this._size = size;
    }
}