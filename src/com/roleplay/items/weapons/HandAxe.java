package com.roleplay.items.weapons;

import com.roleplay.items.Item;

public class HandAxe extends Weapon {
    public HandAxe(double damage) {
        super("hand_axe", 4, damage);
    }

    @Override
    public Item clone() {
        HandAxe handAxe = new HandAxe(getDamage());
        handAxe.setDisplayName(getDisplayName());

        return handAxe;
    }
}