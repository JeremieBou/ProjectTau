package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.math.Vector2;

public class TileGraphPath extends DefaultGraphPath<TileNode> {

	
	public Vector2 getNodePosition(int index) {
		TileNode node = nodes.get(index);
		Vector2 pos = new Vector2(node.x, node.y);
		return pos;
	}
	
}
