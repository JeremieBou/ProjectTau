package com.jeremiebou.projecttau.TiledMaps;

import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class TiledMapSystem extends BaseEntitySystem {
	private TileGraph graph;
	private IndexedAStarPathFinder<TileNode> aStar;
	
	public TiledMapSystem(){
		super(Aspect.all(TileMapComponent.class));
		
		
	}
	
	public void inserted(int e){
		super.inserted(e);
		
		if(this.world.getMapper(TileMapComponent.class).has(e)){	
			long a = System.currentTimeMillis();
			TileMapComponent mapComp = this.world.getMapper(TileMapComponent.class).get(e);
			TiledMapTileLayer layer = (TiledMapTileLayer)mapComp.getMap().getLayers().get(0);	

			graph = new TileGraph(layer.getWidth(), layer.getHeight());
			
			float[][] heightMap = getHeightMap(layer);			
			
			for(int i = 0; i < heightMap.length; i++){
				for (int j = 0; j < heightMap[0].length; j++) {
					System.out.print(heightMap[i][j] + " ");
				}
				System.out.println();
			}
			
			processHeightMapIntoGraph(heightMap);
			
			System.out.println("here");
			for(int i = 0; i < heightMap.length; i++){
				for (int j = 0; j < heightMap[0].length; j++) {
					System.out.print(graph.getNode(i, j) + " ");
				}
				System.out.println();
			}
			
			System.out.println(System.currentTimeMillis() - a);
			
			aStar = new IndexedAStarPathFinder<TileNode>(graph, true);
			
			TileGraphPath outPath = new TileGraphPath();
			TileManhattanHeuristic heuristic = new TileManhattanHeuristic();
			
			aStar.searchNodePath(graph.getNode(10, 10), graph.getNode(10, 15), heuristic, outPath);
			System.out.println(outPath.getCount() + "yay");
			for(int i = 0; i < outPath.getCount(); i++){
				System.out.println(outPath.get(i));
			}
			
			
			System.out.println(aStar.metrics.visitedNodes);
			
			
		}		
	}
	
	private float[][] getHeightMap(TiledMapTileLayer layer){
		float[][] heightMap = new float[layer.getWidth()][layer.getHeight()];
		System.out.println("\n\n");
		
		for(int i = 0; i < layer.getWidth(); i++){
			for(int j = 0; j < layer.getHeight(); j++){
				Cell cell = layer.getCell(i, j);
				TiledMapTile tile = cell.getTile();
				MapProperties props = tile.getProperties();
				
				heightMap[i][j] = Float.parseFloat((String) props.get("Height"));
			}
		}
		
		return heightMap;
		
	}
	
	private void processHeightMapIntoGraph(float[][] map){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
				graph.createNode(i, j, map[i][j]);				
			}
		}
		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
				Array<Vector2> connections = getConnections(i, j, map);
				
				for(int k = 0; k < connections.size; k++){
					graph.addConnection(i, j, (int) connections.get(k).x, (int) connections.get(k).y);
				}
				
			}
		}
		
		graph.startNode = graph.getNode(0, 0);		
	}
	
	private Array<Vector2> getConnections(int x, int y, float[][] map){
		Array<Vector2> connections = new Array<Vector2>();
		
		if(x > 0){
			connections.add(new Vector2(x - 1, y));
			
			if(y > 0){
				connections.add(new Vector2(x - 1, y - 1));
			}
			
			if(y < map[0].length){
				connections.add(new Vector2(x - 1, y + 1));
			}
			
		}
		
		if(x < (map.length -1)){
			connections.add(new Vector2(x + 1, y));
			
			if(y > 0){
				connections.add(new Vector2(x + 1, y - 1));	
			}
			
			if(y < (map[0].length -1)){
				connections.add(new Vector2(x + 1, y + 1));
			}
		}
		
		if(y > 0){			
			connections.add(new Vector2(x, y - 1));
		}
		
		if(y < (map[0].length -1)){
			connections.add(new Vector2(x, y + 1));
		}
		
		return connections;
	}
	
	
	
	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}
}
