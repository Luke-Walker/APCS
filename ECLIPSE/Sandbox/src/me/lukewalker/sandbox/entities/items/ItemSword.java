package me.lukewalker.sandbox.entities.items;

import me.lukewalker.sandbox.entities.type.EntityType;
import me.lukewalker.sandbox.entities.type.ItemEntity;

public class ItemSword extends EntityType implements ItemEntity {

	@Override
	public String getName() {
		return "sword";
	}

	@Override
	public String getSprite() {
		return "sword.jpg";
	}
}