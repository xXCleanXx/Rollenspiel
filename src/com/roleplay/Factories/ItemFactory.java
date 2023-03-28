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

public class ItemFactory {

    private Settings settings;
    public ItemFactory(Settings settings){
        this.settings = settings;
    }

    public void addAllItems(){
        settings.addItemToWhiteList(new Amulet(new ItemProperties("amulet"), new HealEffect(3)));
        settings.addItemToWhiteList(new Cape(new ItemProperties("cape"), new InvisibleEffect(3)));
        settings.addItemToWhiteList(new Potion(new ItemProperties("potion"), new HealEffect(3)));
        settings.addItemToWhiteList(new Ring(new ItemProperties("ring"), new HealEffect(3)));
        settings.addItemToWhiteList(new LeatherArmor(new ItemProperties("leather")));
        settings.addItemToWhiteList(new ChainArmor(new ItemProperties("chain")));
        settings.addItemToWhiteList(new IronArmor(new ItemProperties("iron")));
        settings.addItemToWhiteList(new Shield(new ItemProperties("shield")));
        settings.addItemToWhiteList(new Dagger(new ItemProperties("dagger")));
        settings.addItemToWhiteList(new Dart(new ItemProperties("dart")));
        settings.addItemToWhiteList(new HandAxe(new ItemProperties("hand_axe")));
        settings.addItemToWhiteList(new Axe(new ItemProperties("axe")));
        settings.addItemToWhiteList(new Spear(new ItemProperties("spear")));
        settings.addItemToWhiteList(new Sword(new ItemProperties("sword")));
        settings.addItemToWhiteList(new Bow(new ItemProperties("bow")));

    }

    public Item getItemByName(String name) {
        for (Item i : settings.getItemWhiteList()) {
            if (i.getProperties().getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        for(Item i : settings.getItemBlackList()){
            if(i.getProperties().getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return null;
    }

    public Item createItemByName(String name){
        return switch (name) {
            case "amulet" -> new Amulet(new ItemProperties(), new HealEffect(3));
            case "cape" -> new Cape(new ItemProperties(), new InvisibleEffect(3));
            case "potion" -> new Potion(new ItemProperties(), new HealEffect(3));
            case "ring" -> new Ring(new ItemProperties(), new HealEffect(3));
            case "leather" -> new LeatherArmor(new ItemProperties());
            case "chain" -> new ChainArmor(new ItemProperties());
            case "iron" -> new IronArmor(new ItemProperties());
            case "shield" -> new Shield(new ItemProperties());
            case "dagger" -> new Dagger(new ItemProperties());
            case "dart" -> new Dart(new ItemProperties());
            case "hand_axe" -> new HandAxe(new ItemProperties());
            case "axe" -> new Axe(new ItemProperties());
            case "spear" -> new Spear(new ItemProperties());
            case "sword" -> new Sword(new ItemProperties());
            case "Bow" -> new Bow(new ItemProperties());
            default -> null;
        };
    }

}
