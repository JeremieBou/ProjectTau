package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.SmoothableGraphPath;
import com.badlogic.gdx.math.Vector2;

public class TileGraphPath extends DefaultGraphPath<TileNode> implements SmoothableGraphPath<TileNode, Vector2>{

	
	public Vector2 getNodePosition(int index) {
		TileNode node = nodes.get(index);
		Vector2 pos = new Vector2(node.x, node.y);
		return pos;
	}

	@Override
	public void swapNodes(int index1, int index2) {
		nodes.set(index1, nodes.get(index2));
		
	}

	@Override
	public void truncatePath(int newLength) {
		nodes.truncate(newLength);
		
	}
	
}
