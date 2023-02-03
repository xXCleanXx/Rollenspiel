package com.roleplay.items.interfaces;

import com.roleplay.items.enums.ItemType;
import org.jetbrains.annotations.NotNull;

public interface IItem {
    @NotNull String getName();
    @NotNull ItemType getType();
}