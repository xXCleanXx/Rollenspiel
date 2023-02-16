package com.roleplay.characters;

public class Abilities {
    private double intelligence;
    private double strength;
    private double constitution;
    private double wisdom;
    private double skill;
    private double experience;

    public Abilities() { }

    public double getIntelligence() {
        return intelligence;
    }

    public Abilities setIntelligence(double intelligence) {
        if (intelligence < 0) throw new IllegalArgumentException("Intelligence cannot be less than 0!");

        this.intelligence = intelligence;

        return this;
    }

    public double getStrength() {
        return strength;
    }

    public Abilities setStrength(double strength) {
        if (strength < 0) throw new IllegalArgumentException("Strength cannot be less than 0!");

        this.strength = strength;

        return this;
    }

    public double getConstitution() {
        return constitution;
    }

    public Abilities setConstitution(double constitution) {
        if (constitution < 0) throw new IllegalArgumentException("Constitution cannot be less than 0!");

        this.constitution = constitution;

        return this;
    }

    public double getWisdom() {
        return wisdom;
    }

    public Abilities setWisdom(double wisdom) {
        if (wisdom < 0) throw new IllegalArgumentException("Wisdom cannot be less than 0!");

        this.wisdom = wisdom;

        return this;
    }

    public double getSkill() {
        return skill;
    }

    public Abilities setSkill(double skill) {
        if (skill < 0) throw new IllegalArgumentException("Skill cannot be less than 0!");

        this.skill = skill;

        return this;
    }

    public double getExperience() {
        return experience;
    }

    public Abilities setExperience(double experience) {
        if (experience < 0) throw new IllegalArgumentException("Experience cannot be less than 0!");

        this.experience = experience;

        return this;
    }
}
