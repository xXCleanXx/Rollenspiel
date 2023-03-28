package com.roleplay.build;

import com.roleplay.items.Key;
import com.roleplay.map.GameMapElementProperties;
import com.roleplay.map.Tile;

public class Door extends Tile<GameMapElementProperties> {
    private boolean locked, open;
    private int lockPickingLevel;
    private Key key;

    public Door(int lockPickingLevel, GameMapElementProperties tileProperties) {
        super(tileProperties);

        setLockPickingLevel(lockPickingLevel);
    }

    private String getImagePath(boolean flag) {
        String path = "src/com/roleplay/resources/images/door.png";

        if (flag) path = "src/com/roleplay/resources/images/doorRotated.png";

        return path;
    }

    public int getLockPickingLevel() {
        return lockPickingLevel;
    }

    private void setLockPickingLevel(int lockPickingLevel) {
        if (lockPickingLevel < 0) throw new IllegalArgumentException("Lock picking level cannot be less than 0!");

        this.lockPickingLevel = lockPickingLevel;
    }

    public boolean isOpen() {
        return open;
    }

    public void close() {
        open = false;
    }

    public void open() {
        getProperties().getHitBox().setEnabled(false);
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
        if (!key.getProperties().getName().equalsIgnoreCase(this.key.getProperties().getName())) return false;

        locked = false;

        return true;
    }
}