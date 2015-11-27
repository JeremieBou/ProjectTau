package com.jeremiebou.projecttau.TiledMaps;

import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

public class TiledMapSystem extends BaseEntitySystem {
	private TileGraph graph;
	
	public TiledMapSystem(){
		super(Aspect.all(TileMapComponent.class));
		
	}
	
	public void inserted(int e){
		super.inserted(e);
		
		if(this.world.getMapper(TileMapComponent.class).has(e)){	
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
	
	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}
}
