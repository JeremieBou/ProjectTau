package com.jeremiebou.projecttau.Systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jeremiebou.projecttau.Components.CameraComponent;
import com.jeremiebou.projecttau.Components.TransformComponent;

public class CameraSystem extends EntityProcessingSystem{
	private SpriteBatch batch;
		
	public CameraSystem(SpriteBatch batch) {
		super(Aspect.all(CameraComponent.class));		
		
		this.batch = batch;		
	}
	
	public void initialize(){
		super.initialize();
	}
	
	
	public void process(Entity entity) {
		CameraComponent cam = this.world.getMapper(CameraComponent.class).get(entity);
		
		if(cam.getTarget() == null){
			return;
		}
		
		TransformComponent targetTransform = this.world.getMapper(TransformComponent.class).get(cam.getTarget());
		
		
		if(targetTransform == null){
			return;
		}
		
		cam.getCamera().position.x = targetTransform.getPosition().x + targetTransform.getDimensions().x;
		cam.getCamera().position.y = targetTransform.getPosition().y + targetTransform.getDimensions().y;		
		cam.getCamera().update();

		batch.setProjectionMatrix(cam.getCamera().combined);
		
		cam.getMapRenderer().setView(cam.getCamera());
		
		
	}	
}
