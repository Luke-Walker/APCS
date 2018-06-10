package me.lukewalker.sandbox.events;

import me.lukewalker.sandbox.entities.Entity;
import me.lukewalker.sandbox.entities.EntityPlayer;
import me.lukewalker.sandbox.entities.type.ItemEntity;
import me.lukewalker.sandbox.events.type.EntityCollisionEvent;

public class PlayerPickUpItemEvent extends CustomEvent implements EntityCollisionEvent {

	@Override
	public void onEvent(Entity ent, Entity other) {
		if (!(ent.getType() instanceof EntityPlayer)) return;
		if (!(other.getType() instanceof ItemEntity)) return;
		
		EntityPlayer player = (EntityPlayer) ent.getType();
		player.addItem((ItemEntity)other.getType());
	}

	@Override
	public Event getType() {
		return Event.ENTITY_COLLISION;
	}
}
