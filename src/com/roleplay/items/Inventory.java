package com.roleplay.items;

import com.roleplay.items.interfaces.IItem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<IItem> _items = new ArrayList<>();

    public IItem[] getItems() {
        return this._items.toArray(new IItem[0]);
    }

    public void add(IItem item) {
        this._items.add(item);
    }

    public void remove(IItem item) {
        this._items.remove(item);
    }

    public void swap(IItem newItem, IItem oldItem) {

    }
}