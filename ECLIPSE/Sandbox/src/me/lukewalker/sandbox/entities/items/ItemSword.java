package me.lukewalker.sandbox.entities.items;

import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.ItemEntity;

public class ItemSword extends EntityType implements ItemEntity {

	@Override
	public ItemType getType() {
		return ItemType.WEAPON;
	}

	@Override
	public String getName() {
		return "Sword";
	}

	@Override
	public String getSprite() {
		return "sword.jpg";
	}

	@Override
	public int getWidth() {
		return 100;
	}

	@Override
	public int getHeight() {
		return 100;
	}
}
