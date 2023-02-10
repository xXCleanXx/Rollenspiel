package com.roleplay.build;

public class Door {
    private boolean locked, open;
    private Key key;

    public boolean isOpen() {
        return open;
    }

    public void close() {
        open = false;
    }

    public void open() {
        open = true;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean lock(Key key) {
        if (isOpen() || isLocked()) return false;

        this.key = key;

        return locked = true;
    }

    public boolean unlock(Key key) {
        if (!key.getName().equalsIgnoreCase(this.key.getName())) return false;

        locked = false;

        return true;
    }
}