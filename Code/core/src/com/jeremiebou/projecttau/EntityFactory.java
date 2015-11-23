package com.jeremiebou.projecttau;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.utils.EntityBuilder;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.jeremiebou.projecttau.Components.CameraComponent;
import com.jeremiebou.projecttau.Components.ControllableComponent;
import com.jeremiebou.projecttau.Components.DebugRenderComponent;
import com.jeremiebou.projecttau.Components.InputControllableComponent;
import com.jeremiebou.projecttau.Components.RenderableComponent;
import com.jeremiebou.projecttau.Components.SpriteComponent;
import com.jeremiebou.projecttau.Components.TileMapComponent;
import com.jeremiebou.projecttau.Components.TransformComponent;

public class EntityFactory{
	private World world;
	private Assets assets;
	
	public EntityFactory(){
	}

	public void initialize(World world, Assets assets){
		this.world = world;
		this.assets = assets;
	}
	
	public Entity createGlobalController(){
		Entity entity = new EntityBuilder(world)
		.with(new ControllableComponent(),
				new InputControllableComponent(Settings.getGlobalKeyActionIds()))
		.build();

		return entity;
	}

	public Entity createPlayer(Vector2 spawnPoint){				
		Entity entity = new EntityBuilder(world)
		.with(new DebugRenderComponent(Color.CYAN),
				new RenderableComponent(),
				new SpriteComponent(new Sprite(assets.getPlayerSprite())),
				new TransformComponent(spawnPoint, new Vector2(64,64), 300, 90),
				new ControllableComponent(),				
				new InputControllableComponent(Settings.getPlayerKeyActionIds()))
		.build();
		
		return entity;
	}

	public Entity createCamera(Entity target, TiledMapRenderer renderer){

		Entity entity = new EntityBuilder(world)
		.with(new CameraComponent(target, renderer))		
		.build();
				
		return entity;
	}

	public Entity createTiledMap(TiledMap tMap){
		
		TileMapComponent tmc = new TileMapComponent(tMap);
		Entity entity = new EntityBuilder(world)
		.with(tmc, new RenderableComponent())		
		.build();
		
		//TileMapSystem.processMap(tmc);
		
		return entity;
	}
}
