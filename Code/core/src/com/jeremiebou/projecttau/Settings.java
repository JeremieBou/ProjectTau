package com.jeremiebou.projecttau;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.jeremiebou.projecttau.Systems.ActionPacket;
import com.jeremiebou.projecttau.Systems.InputSystem;
import com.jeremiebou.projecttau.Systems.KeyActionPacket;

/**
 * Where all the games settings are stored and where there handled
 * 
 * @author Jeremie Boudreau
 */

public class Settings {
	
	private static int screenWidth;
	private static int screenHeigth;
		
	private static Array<KeyActionPacket> playerKeyActionIds;
	private static Array<KeyActionPacket> globalKeyActionIds;
		
	public static void load(){
		screenWidth = Gdx.graphics.getWidth();
		screenHeigth = Gdx.graphics.getHeight();
		
		//load player keys
		playerKeyActionIds = new Array<KeyActionPacket>();
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_UP, Keys.W, InputSystem.KEY_PRESSED));		
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_RIGHT, Keys.D, InputSystem.KEY_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_DOWN, Keys.S, InputSystem.KEY_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_LEFT, Keys.A, InputSystem.KEY_PRESSED));
		
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_UP, Keys.W, InputSystem.KEY_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_RIGHT, Keys.D, InputSystem.KEY_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_DOWN, Keys.S, InputSystem.KEY_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_LEFT, Keys.A, InputSystem.KEY_RELEASED));
		
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.HANDHELD_MAIN, Input.Buttons.LEFT, InputSystem.MOUSE_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.HANDHELD_SECONDARY, Input.Buttons.RIGHT, InputSystem.MOUSE_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_HANDHELD_MAIN, Input.Buttons.LEFT, InputSystem.MOUSE_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_HANDHELD_SECONDARY, Input.Buttons.RIGHT, InputSystem.MOUSE_RELEASED));
		
		//load global keys
		globalKeyActionIds = new Array<KeyActionPacket>();
		globalKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.EXIT_GAME, Keys.ESCAPE, InputSystem.KEY_PRESSED));
		globalKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.DEBUG_MODE, Keys.F2, InputSystem.KEY_PRESSED));
	}
	

	public static void save(){
		
	}

	
	public static Array<KeyActionPacket> getPlayerKeyActionIds(){
		return playerKeyActionIds;
	}
	public static Array<KeyActionPacket> getGlobalKeyActionIds() {
		return globalKeyActionIds;
	}
	
	
	public static int getScreenWidth() {
		return screenWidth;
	}

	public static void setScreenWidth(int screenWidth) {
		Settings.screenWidth = screenWidth;
	}

	public static int getScreenHeigth() {
		return screenHeigth;
	}

	public static void setScreenHeigth(int screenHeigth) {
		Settings.screenHeigth = screenHeigth;
	}
}
