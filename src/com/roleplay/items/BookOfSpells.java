package com.roleplay.items;

import com.roleplay.spells.Spell;

import java.util.ArrayList;
import java.util.List;

public class BookOfSpells extends Item {
    private final List<Spell> spells = new ArrayList<>();
    private float cooldown;

    public BookOfSpells(String name) {
        super(name, 0);
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void use(String spell) {
        for(Spell item : spells) {
           if (item.getName().equalsIgnoreCase(spell)) {
               item.use();
           }
        }
    }

    @Override
    public Item clone() {
        return new BookOfSpells(getName());
    }
}
