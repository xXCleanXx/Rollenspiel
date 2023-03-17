package com.roleplay;

import com.roleplay.characters.Character;
import com.roleplay.items.weapons.Weapon;

import java.util.*;

public class Fight {
    private Queue<Character> fighters;
    private Queue<Character> opponents;

    public Fight(Iterable<Character> fighters, Iterable<Character> opponents) {
        initFight(fighters, opponents);
    }

    private void initFight(Iterable<Character> fighters, Iterable<Character> opponents) {
        if (fighters == null) throw new IllegalArgumentException("Fighters cannot be null!");
        if (opponents == null) throw new IllegalArgumentException("Opponents cannot be null!");

        this.opponents = initCharacters(fighters);
        this.fighters = initCharacters(opponents);
    }

    private static Queue<Character> initCharacters(Iterable<Character> characters) {
        Queue<Character> fighters = new ArrayDeque<>();

        for (Character item : characters) {
            fighters.add(item);
        }

        return fighters;
    }

    private boolean attack(Character fighter, Character opponent) {
        if (Objects.requireNonNull(fighter).getProperties().getInventory().getFirstHand() instanceof Weapon weapon) {
            double defence = Objects.requireNonNull(opponent).defend();

            if (defence < weapon.getDamage()) {
                double diff = weapon.getDamage() - defence;

                opponent.getProperties().setHealthPoints(opponent.getProperties().getHealthPoints() - weapon.getDamage());
            }
        }

        return opponent.getProperties().getHealthPoints() > 0;
    }

    public void fight() {
        boolean finished = false;

        do {
            if (fighters.isEmpty() || opponents.isEmpty()) finished = true;

            Character fighter = fighters.poll();
            Character opponent = opponents.poll();

            if (attack(fighter, opponent)) {
                if (attack(opponent, fighter)) {
                    fighters.add(fighter);
                }

                opponents.add(opponent);
            }
        } while(finished);
    }

    public int rollDice() {
        return new Random().nextInt(1, 21);
    }
}