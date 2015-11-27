package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.indexed.DefaultIndexedGraph;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;

public class TileGraph extends DefaultIndexedGraph<TileNode> implements IndexedGraph<TileNode> {
	public final int sizeX;
	public final int sizeY;
	
	public boolean diagonal;
	public TileNode startNode;
	
	public TileGraph(int sizeX, int sizeY){
		super(sizeX * sizeY);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		diagonal = false;
		startNode = null;
		
	}
	
	
	
	public TileNode getNode(int x, int y){
		return nodes.get(x * sizeY + y);
	}
	
	
	public TileNode getNode(int index){
		return nodes.get(index);
	}
	
	
}
