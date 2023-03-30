package com.roleplay.items.artefacts;

import com.roleplay.characters.Character;
import com.roleplay.effects.DamageEffect;
import com.roleplay.effects.Effect;
import com.roleplay.effects.HealEffect;
import com.roleplay.effects.InvisibleEffect;
import com.roleplay.items.ItemProperties;
import com.roleplay.tools.ImageUtils;

import java.util.Random;

public class Potion extends Artefact {
    public Potion(ItemProperties itemProperties) {
        super(itemProperties, loadEffect());
        itemProperties.setName("potion");
        itemProperties.setTexture32(ImageUtils.loadImage("src/com/roleplay/resources/images/items/potion_32x32.png"));
    }

    @Override
    public void use(Character character) {
        getEffect().apply(character);
    }

    private static Effect loadEffect() {
        switch (new Random().nextInt(3)) {
            case 0 -> {
                return new HealEffect(3);
            }
            case 1 -> {
                return new DamageEffect(3);
            }
            case 2 -> {
                return new InvisibleEffect(3);
            }
        }
        return new HealEffect(3);
    }
}