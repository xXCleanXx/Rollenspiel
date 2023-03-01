package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;
import com.roleplay.tiles.properties.ItemProperties;
import com.roleplay.tools.Image;

import java.awt.*;

public class Axe extends Weapon {
    public Axe(ItemProperties itemProperties, double damage) {
        super(itemProperties, damage);
    }

    @Override
    public Item clone() {
        Axe axe = new Axe((ItemProperties) getProperties(), getDamage());

        clone(axe, this);

        return axe;
    }
}