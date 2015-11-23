package com.jeremiebou.projecttau.Components;

import com.artemis.Component;
import com.artemis.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.jeremiebou.projecttau.Settings;

public class CameraComponent extends Component{
	private Entity target;	
	private OrthographicCamera camera;
	private TiledMapRenderer mapRenderer;
	
	public CameraComponent(Entity target, TiledMapRenderer mapRenderer) {
		this.target = target;
		camera = new OrthographicCamera(Settings.getScreenWidth(), Settings.getScreenHeigth());
		
		this.mapRenderer = mapRenderer;
	}
	
	public TiledMapRenderer getMapRenderer() {
		return mapRenderer;
	}

	public Entity getTarget() {
		return target;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

}

