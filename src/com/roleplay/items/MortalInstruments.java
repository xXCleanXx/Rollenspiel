package com.roleplay.items;

import com.roleplay.tools.ImageUtils;

/***
 * Cristal ball item.
 */
public class MortalInstruments extends Item {
    public MortalInstruments(ItemProperties itemProperties, int index) {
        super(itemProperties);
        if (index == 1) {
            itemProperties.setName("angelCup");
            itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/angel_cup_32x32.png"));
        } else if (index == 2) {
            itemProperties.setName("lynMirror");
            itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/lyn_mirror_32x32.png"));
        } else if (index == 3) {
            itemProperties.setName("soulSword");
            itemProperties.setTexture32(ImageUtils.loadImage("com/roleplay/resources/images/items/soul_sword_32x32.png"));
        }
    }
}