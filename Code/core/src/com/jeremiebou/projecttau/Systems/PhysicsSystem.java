package com.jeremiebou.projecttau.Systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.badlogic.gdx.math.Vector2;
import com.jeremiebou.projecttau.Components.TransformComponent;

public class PhysicsSystem extends EntitySystem {
	private static final float blankSpeed = 312459;
	
	public PhysicsSystem() {
		super(Aspect.all(TransformComponent.class));
	}

	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub

	}
	
	public void startMoveUp(Entity e){
		modifyDisplacementVector(e, blankSpeed, 1);
	}
	
	public void startMoveDown(Entity e){
		modifyDisplacementVector(e, blankSpeed, -1);
	}
	
	public void startMoveRight(Entity e){
		modifyDisplacementVector(e, 1, blankSpeed);
	}
	
	public void startMoveLeft(Entity e){
		modifyDisplacementVector(e, -1, blankSpeed);
	}
	
	public void stopMoveUp(Entity e){
		modifyDisplacementVector(e, blankSpeed, 0);
	}
	
	public void stopMoveDown(Entity e){
		modifyDisplacementVector(e, blankSpeed, 0);
	}
	
	public void stopMoveRight(Entity e){
		modifyDisplacementVector(e, 0, blankSpeed);
	}
	
	public void stopMoveLeft(Entity e){
		modifyDisplacementVector(e, 0, blankSpeed);
	}
	
	private void modifyDisplacementVector(Entity e, float newX, float newY){
		TransformComponent tc = world.getMapper(TransformComponent.class).get(e);
		if(newX != blankSpeed){
			tc.setDisplacement(new Vector2(newX, tc.getDisplacement().y));
		}
		
		if(newY != blankSpeed){
			tc.setDisplacement(new Vector2(tc.getDisplacement().x, newY));
		}
		
		System.out.println(tc.getDisplacement() + " " + tc.getMovementSpeed());
	}

}
