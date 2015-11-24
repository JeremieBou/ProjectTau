package com.jeremiebou.projecttau.Systems;

import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.jeremiebou.projecttau.Components.TileMapComponent;

public class TiledMapSystem extends BaseEntitySystem {
	public TiledMapSystem(){
		super(Aspect.all(TileMapComponent.class));
	}
	
	public void inserted(int e){
		super.inserted(e);
		if(this.world.getMapper(TileMapComponent.class).has(e)){
			TileMapComponent mapComp = this.world.getMapper(TileMapComponent.class).get(e);
			TiledMapTileLayer layer = (TiledMapTileLayer)mapComp.getMap().getLayers().get(0);
			
			int col = layer.getWidth();
			int row = layer.getHeight();
			
			int[][] map = new int[col][row];
			
			for(int i = 0; i < col; i++){
				for(int j = 0; j < row; j++){
					Cell cell = layer.getCell(i, j);
					TiledMapTile tile = cell.getTile();
					MapProperties props = tile.getProperties();
					
					map[i][j] = Integer.parseInt((String) props.get("Blocked"));					
				}
			}
			
			for(int i = 0; i < map.length; i++){
				for (int j = 0; j < map[0].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			float[][] heightMap = new float[col][row];
			System.out.println("\n\n");
			
			for(int i = 0; i < col; i++){
				for(int j = 0; j < row; j++){
					Cell cell = layer.getCell(i, j);
					TiledMapTile tile = cell.getTile();
					MapProperties props = tile.getProperties();
					
					heightMap[i][j] = Float.parseFloat((String) props.get("Height"));
				}
			}
			
			for(int i = 0; i < heightMap.length; i++){
				for (int j = 0; j < heightMap[0].length; j++) {
					System.out.print(heightMap[i][j] + " ");
				}
				System.out.println();
			}
		}			
	}
	
	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}
}
