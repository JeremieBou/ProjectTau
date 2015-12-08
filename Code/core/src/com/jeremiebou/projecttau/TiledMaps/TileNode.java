package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.indexed.IndexedNode;
import com.badlogic.gdx.utils.Array;

public class TileNode implements IndexedNode<TileNode>{

	public final int x;
	public final int y;
	public final float height;
	
	protected Array<Connection<TileNode>> connections;
	
	public TileNode(int x, int y, float height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.connections = new Array<Connection<TileNode>>(8);
	}
	
	public int getIndex() {
		return 0;
	}
	
	public Array<Connection<TileNode>> getConnections() {
		return connections;
	}

	public String toString(){
		return "" + height;
	}
	
	public String toString(int i){
		return "" + x +  " " + y + " " + height;
	}
	
	
}
