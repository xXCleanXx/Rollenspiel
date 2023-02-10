package com.roleplay.build;

public class Key {
    private String name;

    public Key(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null!");

        this.name = name;
    }
}