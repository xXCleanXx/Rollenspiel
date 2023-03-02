package com.roleplay.tiles.build;

import com.roleplay.tiles.Entity;

public class Block extends Entity {
    private BlockProperties blockProperties;

    public Block(String name, BlockProperties blockProperties) {
        super(name);

        setBlockProperties(blockProperties);
    }

    public Block(String name) {
        this(name, new BlockProperties(false));
    }

    public BlockProperties getBlockProperties() {
        return blockProperties;
    }

    protected void setBlockProperties(BlockProperties blockProperties) {
        if (blockProperties == null) throw new IllegalArgumentException("Block properties cannot be null!");

        this.blockProperties = blockProperties;
    }
}