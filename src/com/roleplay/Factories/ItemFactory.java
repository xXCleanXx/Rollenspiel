package com.roleplay.Factories;

import com.roleplay.effects.HealEffect;
import com.roleplay.effects.InvisibleEffect;
import com.roleplay.items.Item;
import com.roleplay.items.ItemProperties;
import com.roleplay.items.armors.ChainArmor;
import com.roleplay.items.armors.IronArmor;
import com.roleplay.items.armors.LeatherArmor;
import com.roleplay.items.armors.Shield;
import com.roleplay.items.artefacts.Amulet;
import com.roleplay.items.artefacts.Cape;
import com.roleplay.items.artefacts.Potion;
import com.roleplay.items.artefacts.Ring;
import com.roleplay.items.weapons.*;
import com.roleplay.map.Settings;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

    private final Settings settings;

    private List<Item> allItems;

    public ItemFactory(Settings settings){
        this.settings = settings;
    }

    public void addAllItems(){
        settings.addItemToWhiteList(createItemByName("amulet"));
        settings.addItemToWhiteList(createItemByName(("cape")));
        settings.addItemToWhiteList(createItemByName("potion"));
        settings.addItemToWhiteList(createItemByName("ring"));
        settings.addItemToWhiteList(createItemByName("leather"));
        settings.addItemToWhiteList(createItemByName("chain"));
        settings.addItemToWhiteList(createItemByName("iron"));
        settings.addItemToWhiteList(createItemByName("shield"));
        settings.addItemToWhiteList(createItemByName("dagger"));
        settings.addItemToWhiteList(createItemByName("dart"));
        settings.addItemToWhiteList(createItemByName("handAxe"));
        settings.addItemToWhiteList(createItemByName("axe"));
        settings.addItemToWhiteList(createItemByName("spear"));
        settings.addItemToWhiteList(createItemByName("sword"));
        settings.addItemToWhiteList(createItemByName("bow"));

        allItems = new ArrayList<>(settings.getItemWhiteList());

    }

    public Item getItemByName(String name) {
        for (Item i : allItems) {
            if (i.getProperties().getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    public Item createItemByName(String name){
        return switch (name) {
            case "amulet" -> new Amulet(new ItemProperties(), new HealEffect(3));
            case "cape" -> new Cape(new ItemProperties(), new InvisibleEffect(3));
            case "potion" -> new Potion(new ItemProperties());
            case "ring" -> new Ring(new ItemProperties(), new HealEffect(3));
            case "leather" -> new LeatherArmor(new ItemProperties());
            case "chain" -> new ChainArmor(new ItemProperties());
            case "iron" -> new IronArmor(new ItemProperties());
            case "shield" -> new Shield(new ItemProperties());
            case "dagger" -> new Dagger(new ItemProperties());
            case "dart" -> new Dart(new ItemProperties());
            case "handAxe" -> new HandAxe(new ItemProperties());
            case "axe" -> new Axe(new ItemProperties());
            case "spear" -> new Spear(new ItemProperties());
            case "sword" -> new Sword(new ItemProperties());
            case "bow" -> new Bow(new ItemProperties());
            default -> null;
        };
    }

}
