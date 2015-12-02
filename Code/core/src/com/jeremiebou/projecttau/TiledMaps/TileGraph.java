package com.jeremiebou.projecttau.TiledMaps;

import com.badlogic.gdx.ai.pfa.indexed.DefaultIndexedGraph;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;

public class TileGraph extends DefaultIndexedGraph<TileNode> implements IndexedGraph<TileNode> {
	private static final float DIGONAL_COST = (float)Math.sqrt(2);
	
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
	
	public void createNode(int x, int y, float height){
		nodes.add(new TileNode(x, y, height));
	}
	
	public void addConnection(int x1, int y1, int x2, int y2){
		
		if(coordInRange(x1, y1) && coordInRange(x2, y2)){
			TileNode tn1 = getNode(x1, y1);
			TileNode tn2 = getNode(x2, y2);
			float heightDifference = tn1.height - tn2.height;
			float cost = 1;
			
			
			if(isDiagonal(x1, y1, x2, y2)){
				cost = DIGONAL_COST;
			}
						
			if(heightDifference < 1 && heightDifference > -1){				
				tn1.getConnections().add(new TileConnection(tn1, tn2, cost));
			}
		}
	}
	
	private boolean isDiagonal(int x1, int y1, int x2, int y2){
		return Math.abs(x1-x2) + Math.abs(y1-y1) == 2;
	}
	
	private boolean coordInRange(int x, int y){
		return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
	}
	
	
	public TileNode getNode(int x, int y){
		return nodes.get(x * sizeY + y);
		
	}
	
	
	public TileNode getNode(int index){
		return nodes.get(index);
	}
	
	
}
