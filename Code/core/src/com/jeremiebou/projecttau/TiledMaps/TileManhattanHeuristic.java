package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.Heuristic;

public class TileManhattanHeuristic implements Heuristic<TileNode> {

	@Override
	public float estimate(TileNode node, TileNode endNode) {
		return Math.abs(endNode.x - node.x) + Math.abs(endNode.y - node.y);
	}

}
