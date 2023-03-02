package com.roleplay.shop;

import com.roleplay.tiles.items.Item;

public class Article {
    private double price;
    private Item item;

    public Article(Item item, double price) {
        setItem(item);
        setPrice(price);
    }

    public Item getItem() {
        return item;
    }

    private void setItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null!");

        this.item = item;
    }

    private void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be less than 0!");

        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}