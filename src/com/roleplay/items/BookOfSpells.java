package com.roleplay.items;

import com.roleplay.characters.Character;
import com.roleplay.spells.Spell;

import java.util.ArrayList;
import java.util.List;

public class BookOfSpells extends Item {
    private final List<Spell> spells = new ArrayList<>();
    private float cooldown;

    public BookOfSpells(String name) {
        super(name, 0);
    }

    public boolean addSpell(Spell spell) {
        if (spell == null) throw new IllegalArgumentException("Spell cannot be null!");

        return spells.add(spell);
    }

    public boolean removeSpell(Spell spell) {
        if (spell == null) throw new IllegalArgumentException("Spell cannot be null!");

        return spells.remove(spell);
    }

    public void use(Character character, String spell) {
        for(Spell item : spells) {
           if (item.getName().equalsIgnoreCase(spell)) {
               item.use(character);
           }
        }
    }

    @Override
    public Item clone() {
        return new BookOfSpells(getName());
    }
}
