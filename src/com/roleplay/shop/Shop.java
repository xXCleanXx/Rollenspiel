package com.roleplay.shop;

import com.roleplay.tiles.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Article> articles = new ArrayList<>();
    private final Shop shop = new Shop();

    private Shop() { }

    public Shop getInstance() {
        return shop;
    }

    public Item buy(String name, double price) {
        for (Article item : articles) {
            if (item.getItem().getName().equalsIgnoreCase(name) && price == item.getPrice()) {
                return item.getItem();
            }
        }

        return null;
    }

    public boolean addArticle(Article article) {
        if (article == null) throw new IllegalArgumentException("Article cannot be null!");

        return articles.add(article);
    }

    public boolean removeArticle(Article article) {
        if (article == null) throw new IllegalArgumentException("Article cannot be null!");

        return articles.remove(article);
    }
}