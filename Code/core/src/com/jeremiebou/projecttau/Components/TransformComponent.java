package com.jeremiebou.projecttau.Components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent extends Component{
	private Vector2 posistion = new Vector2(0, 0);
	private Vector2 displacement = new Vector2(0, 0);
	private Vector2 dimensions = new Vector2(0, 0);
	private float movementSpeed;
	private float angle;
	
	public TransformComponent(Vector2 pos, Vector2 dimensions,  float movementSpeed, float angle){
		this.posistion = pos;
		this.dimensions = dimensions;
		this.movementSpeed = movementSpeed;
		this.angle = angle;
	}
	
	public Vector2 getPosition() {
		return posistion;
	}

	public void setPosistion(Vector2 pos) {
		this.posistion = pos;
	}

	public Vector2 getDisplacement() {
		return displacement;
	}

	public void setDisplacement(Vector2 displacement) {
		this.displacement = displacement;
	}

	public Vector2 getDimensions() {
		return dimensions;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
}
