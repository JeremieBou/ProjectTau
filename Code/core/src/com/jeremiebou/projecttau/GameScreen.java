package com.jeremiebou.projecttau;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.jeremiebou.projecttau.Components.TileMapComponent;
import com.jeremiebou.projecttau.Systems.CameraSystem;
import com.jeremiebou.projecttau.Systems.ControllerSystem;
import com.jeremiebou.projecttau.Systems.InputSystem;
import com.jeremiebou.projecttau.Systems.PhysicsSystem;
import com.jeremiebou.projecttau.Systems.RenderSystem;
import com.jeremiebou.projecttau.Systems.TileMapRenderSystem;
import com.jeremiebou.projecttau.Systems.TiledMapSystem;
import com.jeremiebou.projecttau.Systems.TransformSystem;

public class GameScreen implements Screen {
	private final World world;
	private final EntityFactory entityFactory;
	private ComponentMapper<TileMapComponent> tm;
		
	public GameScreen(ProjectTau game, Assets assets){
		entityFactory = new EntityFactory();
		
		ControllerSystem cm = new ControllerSystem();
		
		WorldConfiguration config = new WorldConfiguration()
		.setSystem(new InputSystem(cm))
		.setSystem(new TiledMapSystem())
		.setSystem(new CameraSystem(game.batcher))

		.setSystem(new TileMapRenderSystem())
		.setSystem(new RenderSystem(game.batcher))

		.setSystem(cm)	
		
		.setSystem(new PhysicsSystem())
		.setSystem(new TransformSystem());
		
		world = new World(config);
		
		tm = world.getMapper(TileMapComponent.class);
		
		entityFactory.initialize(world, assets);
		
		
		

		Entity tileMap = entityFactory.createTiledMap(assets.getMap());
		Entity player = entityFactory.createPlayer(new Vector2(200,200));
		entityFactory.createCamera(player, tm.get(tileMap).getRenderer());
		
		
	}
	
	public void render(float delta){
		System.out.println("fps: " + Gdx.graphics.getFramesPerSecond());
		Gdx.gl.glClearColor(0.0f, 1.0f, 0.0f, 0.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.setDelta(MathUtils.clamp(delta, 0, 1 / 15f));
		world.process();
	}

	public void show(){}
	public void resize(int width, int height) {	}
	public void hide(){}
	public void pause(){}
	public void resume(){}
	public void dispose(){}

}
