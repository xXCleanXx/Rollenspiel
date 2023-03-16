package com.roleplay;

import com.roleplay.characters.Character;

import java.util.Enumeration;
import java.util.Random;

public class Fight {
    private final Enumeration<Character> enemies1;
    private final Enumeration<Character> enemies2;

    public Fight(Enumeration<Character> enemies1, Enumeration<Character> enemies2) {
        this.enemies1 = enemies1;
        this.enemies2 = enemies2;
    }

    public void fight() {
//        double defence = enemy2.defend();
//        Item item = enemy1.getProperties().getInventory().getFirstHand();

//        if (item instanceof Weapon weapon) {
//            double damage = weapon.getDamage();
//
//            if (defence < damage) {
//
//            }
//        }
    }

    public int rollDice() {
        return new Random().nextInt(1, 21);
    }
}