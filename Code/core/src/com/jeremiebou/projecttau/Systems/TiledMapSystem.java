package com.jeremiebou.projecttau.Systems;

import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.jeremiebou.projecttau.Components.TileMapComponent;

public class TiledMapSystem extends BaseEntitySystem {
	public TiledMapSystem(){
		super(Aspect.all(TileMapComponent.class));
	}
	
	public void inserted(int e){
		super.inserted(e);
		if(this.world.getMapper(TileMapComponent.class).has(e)){
			TileMapComponent mapComp = this.world.getMapper(TileMapComponent.class).get(e);
			TiledMap map = mapComp.getMap();
						
		}			
	}
	
	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}
}
