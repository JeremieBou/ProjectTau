package com.jeremiebou.projecttau.Systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.jeremiebou.projecttau.Components.TransformComponent;

public class TransformSystem extends EntityProcessingSystem {
	public TransformSystem() {
		super(Aspect.all(TransformComponent.class));
	}

	protected void process(Entity e) {
		TransformComponent t = e.getComponent(TransformComponent.class);
		t.getPosition().add(t.getDisplacement().cpy().scl(t.getMovementSpeed()* Gdx.graphics.getDeltaTime()));
	}
}
