package com.roleplay.tiles.build;

public final class BlockProperties {
    private boolean rotated;

    public BlockProperties(boolean rotated) {
        rotate(rotated);
    }

    public boolean isRotated() {
        return rotated;
    }

    private void rotate(boolean flag) {
        rotated = flag;
    }
}