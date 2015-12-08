package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.DefaultConnection;

public class TileConnection extends DefaultConnection<TileNode>{
	private float cost;
	
	public TileConnection(TileNode fromNode, TileNode toNode, float cost) {
		super(fromNode, toNode);
		this.cost = cost;
		
	}

	public float getCost() {
		
		return cost;
	}
	
	public String toString(){
		return fromNode.toString(1) + " " + toNode.toString(1) + " " + cost;
	}
}
