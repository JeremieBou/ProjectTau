package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.DefaultConnection;

public class TileConnection extends DefaultConnection<TileNode>{
	static final float NON_DIAGONAL_COST = (float) Math.sqrt(2);
	
	TileGraph worldMap;
	
	public TileConnection(TileGraph worldMap, TileNode fromNode, TileNode toNode) {
		super(fromNode, toNode);
		this.worldMap = worldMap;
	}

	public float getCost() {
		
		return 0;
	}
}
