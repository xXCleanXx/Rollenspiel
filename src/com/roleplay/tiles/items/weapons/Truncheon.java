package com.roleplay.tiles.items.weapons;

import com.roleplay.tiles.items.Item;

public class Truncheon extends ThrowableWeapon {
    protected Truncheon() {
        super("truncheon", 3, 6, 1);
    }

    @Override
    public Item clone() {
        Truncheon truncheon = new Truncheon();

        clone(truncheon, this);

        return truncheon;
    }
}
