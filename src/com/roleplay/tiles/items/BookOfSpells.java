package com.roleplay.tiles.items;

import com.roleplay.tiles.characters.Character;
import com.roleplay.spells.Spell;

import java.util.ArrayList;
import java.util.List;

/***
 * Book of spells item.
 * Contains all collected spells.
 */
public class BookOfSpells extends Item {
    private final List<Spell> spells = new ArrayList<>();
    private float cooldown;

    public BookOfSpells() {
        super("book_of_spells", 0);
        setImg(loadImage("src/com/roleplay/resources/images/gras.png"));
    }

    public Spell[] getSpells() {
        Spell[] spells = new Spell[this.spells.size()];

        for (int i = 0; i < spells.length; i++) {
            spells[i] = this.spells.get(i);
        }

        return spells;
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
        BookOfSpells book = new BookOfSpells();
        book.setPosition(getPosition());
        book.setDisplayName(getDisplayName());

        for (Spell item : spells) {
            book.addSpell(item);
        }

        return book;
    }
}
