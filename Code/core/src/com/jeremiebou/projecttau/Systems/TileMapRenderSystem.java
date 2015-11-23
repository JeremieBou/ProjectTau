package com.jeremiebou.projecttau.Systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jeremiebou.projecttau.Components.TileMapComponent;

public class TileMapRenderSystem extends EntityProcessingSystem {

	public TileMapRenderSystem() {
		super(Aspect.all(TileMapComponent.class));
	}

	@Override
	protected void process(Entity e) {
		int[] layers = {0, 1};
		this.world.getMapper(TileMapComponent.class).get(e).getRenderer().render(layers);
	}

}
