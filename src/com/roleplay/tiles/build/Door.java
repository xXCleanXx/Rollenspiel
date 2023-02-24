package com.roleplay.tiles.build;

import com.roleplay.tiles.items.Key;

public class Door extends Block {
    private boolean locked, open;
    private int lockPickingLevel;
    private Key key;

    public Door(int lockPickingLevel, boolean rotated){
        super("door", new BlockProperties(rotated));

        loadTexture(getImagePath(rotated));
        setLockPickingLevel(lockPickingLevel);
    }

    private String getImagePath(boolean flag) {
        String path = "src/com/roleplay/resources/images/door.png";

        if (flag) path = "src/com/roleplay/resources/images/rotatedDoor.png";

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