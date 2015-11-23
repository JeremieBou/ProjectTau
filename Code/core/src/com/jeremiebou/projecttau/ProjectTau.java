package com.jeremiebou.projecttau;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ProjectTau extends Game {
	public SpriteBatch batcher;
	private  Assets assets;
	
	@Override
	public void create () {
		batcher = new SpriteBatch();
		Settings.load();
		assets = new Assets();
		
		setScreen(new GameScreen(this, assets));
	}
	
	public void dispose(){
		super.dispose();
		assets.dispose();
	}
}
