package com.roleplay.characters;

public class Abilities {

    private double intelligence;
    private double strength;
    private double constitution;
    private double wisdom;
    private double skill;
    private double experience;

    public Abilities(double intelligence, double strength, double constitution, double wisdom, double skill, double experience){
        setIntelligence(intelligence);
        setStrength(strength);
        setConstitution(constitution);
        setWisdom(wisdom);
        setSkill(skill);
        setExperience(experience);
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getConstitution() {
        return constitution;
    }

    public void setConstitution(double constitution) {
        this.constitution = constitution;
    }

    public double getWisdom() {
        return wisdom;
    }

    public void setWisdom(double wisdom) {
        this.wisdom = wisdom;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }
}
