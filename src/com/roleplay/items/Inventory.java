package com.roleplay.items;

import com.roleplay.items.armors.Armor;
import com.roleplay.items.artefacts.Artefact;
import com.roleplay.items.weapons.Weapon;

public class Inventory {
    private final ItemStack[] items;
    private Weapon currentWeapon;

    public Inventory(int size) {
        if (size < 0) {
            throw new IndexOutOfBoundsException("Size cannot be less than 0!");
        }

        this.items = new ItemStack[size];
    }

    public ItemStack get(int index) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        return items[index];
    }

    public void add(int index, ItemStack itemStack) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        if (items[index] != null) {
            throw new IllegalArgumentException("Could not be set, because slot is not null!");
        }

        items[index] = itemStack;
    }

    public ItemStack remove(int index) {
        if (items[index] == null) {
            throw new IllegalArgumentException("There is nothing to remove!");
        }

        return swap(index, null);
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public void setArmor(Armor armor) {

    }

    public ItemStack swap(int index, ItemStack newItemStack) {
        if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Index was less than 0 or greater than the maximum allow size!");
        }

        ItemStack oldItemStack = items[index];
        items[index] = newItemStack;

        return oldItemStack;
    }

    public void useArtefact(Artefact artefact){
            artefact.use();
    }
}