package com.roleplay.characters;

import java.util.Random;

public class Abilities {
    private double intelligence;
    private double strength;
    private double constitution;
    private double wisdom;
    private double skill;
    private double experience;

    public Abilities() {
        Random rand = new Random();
        setIntelligence(rand.nextInt((18 - 3) + 1) + 3);
        setStrength(rand.nextInt((18 - 3) + 1) + 3);
        setConstitution(rand.nextInt((18 - 3) + 1) + 3);
        setWisdom(rand.nextInt((18 - 3) + 1) + 3);
        setSkill(rand.nextInt((18 - 3) + 1) + 3);
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        if (intelligence < 0) throw new IllegalArgumentException("Intelligence cannot be less than 0!");

        this.intelligence = intelligence;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        if (strength < 0) throw new IllegalArgumentException("Strength cannot be less than 0!");

        this.strength = strength;
    }

    public double getConstitution() {
        return constitution;
    }

    public void setConstitution(double constitution) {
        if (constitution < 0) throw new IllegalArgumentException("Constitution cannot be less than 0!");

        this.constitution = constitution;

    }

    public double getWisdom() {
        return wisdom;
    }

    public void setWisdom(double wisdom) {
        if (wisdom < 0) throw new IllegalArgumentException("Wisdom cannot be less than 0!");

        this.wisdom = wisdom;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        if (skill < 0) throw new IllegalArgumentException("Skill cannot be less than 0!");

        this.skill = skill;
    }

    public double getExperience() {
        return experience;
    }

    public Abilities setExperience(double experience) {
        if (experience < 0) throw new IllegalArgumentException("Experience cannot be less than 0!");

        this.experience = experience;

        return this;
    }

    public void addAbilities(int intelligence, int strength, int constitution, int wisdom, int skill) {
        setIntelligence(getIntelligence() + intelligence);
        setStrength(getStrength() + strength);
        setConstitution(getConstitution() + constitution);
        setWisdom(getWisdom() + wisdom);
        setSkill(getSkill() + skill);
    }
}
