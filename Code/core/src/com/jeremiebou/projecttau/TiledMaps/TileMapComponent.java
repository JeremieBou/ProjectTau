package com.jeremiebou.projecttau.TiledMaps;

import com.artemis.Component;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

public class TileMapComponent extends Component{
	private TiledMapRenderer mapRenderer;
	private TiledMap map;
	private Vector2 dim;
	
	public TileMapComponent(TiledMap map){
		this.map = map;
		mapRenderer = new OrthogonalTiledMapRenderer(this.map);
		
		setDim(new Vector2(64, 64));
	}
	
	public TiledMapRenderer getRenderer(){
		return mapRenderer;
	}

	public TiledMap getMap() {
		return map;
	}

	public Vector2 getDim() {
		return dim;
	}

	public void setDim(Vector2 dim) {
		this.dim = dim;
	}
}
