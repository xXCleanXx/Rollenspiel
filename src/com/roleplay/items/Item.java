package com.roleplay.items;

public abstract class Item implements Cloneable {
    private String name, displayName;
    private double weight;

    public Item(String name, double weight) {
        setName(name);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be less than 0!");
        }

        this.weight = weight;
    }

    @Override
    public abstract Item clone();
}