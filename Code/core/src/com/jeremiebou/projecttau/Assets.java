package com.jeremiebou.projecttau;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets  {
	private Texture playerSprite;
	private  TiledMap map;
	
	
	public Assets(){
		this.load();
	}
	
	
	private void load(){
		playerSprite = new Texture("Graphics/sprites/player.png");
		map = new TmxMapLoader().load("TileMaps/TestMap.tmx");
	}
	
	public void dispose(){
		playerSprite.dispose();
		map.dispose();
		
	}


	public Texture getPlayerSprite() {
		return playerSprite;
	}

	public TiledMap getMap() {
		return map;
	}
}
