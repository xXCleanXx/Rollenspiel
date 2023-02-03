package com.roleplay.items;

import com.roleplay.items.armors.abstractions.Armor;
import com.roleplay.items.interfaces.IItem;
import com.roleplay.items.weapons.abstractions.Weapon;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<ItemStack<IItem>> _items = new ArrayList<>();
    private Weapon _currentWeapon;

    public ItemStack<IItem>[] getItems() {
        //return this._items.toArray(new ItemStack<IItem>[0]);
        return null;
    }

    public void add(ItemStack<IItem> itemStack) {
        this._items.add(itemStack);
    }

    public void remove(ItemStack<IItem> itemStack) {
        this._items.remove(itemStack);
    }

    public @Nullable Weapon getCurrentWeapon() {
        return this._currentWeapon;
    }

    public void setCurrentWeapon(@Nullable Weapon currentWeapon) {
        this._currentWeapon = currentWeapon;
    }

    public void setArmor(Armor armor) {

    }

    public void swap(IItem newItem, IItem oldItem) {

    }
    public void useArtefact(Artefact artefact){
            artefact.use();
    }
}