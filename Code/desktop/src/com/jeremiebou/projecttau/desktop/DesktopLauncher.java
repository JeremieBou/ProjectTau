package com.jeremiebou.projecttau.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jeremiebou.projecttau.ProjectTau;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Super Sigma Project";
		config.fullscreen = false;
		
		if(arg.length >= 2){
			config.width = Integer.parseInt(arg[0]);
			config.height = Integer.parseInt(arg[1]);
			if(arg.length >= 3){
				config.fullscreen = Boolean.parseBoolean(arg[2]);
			}
		}
		else{
			config.width = 1920;
			config.height = 1080;
		}
		
		new LwjglApplication(new ProjectTau(), config);
	}
}
