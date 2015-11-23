package com.jeremiebou.projecttau.Components;

import com.artemis.Component;
import com.badlogic.gdx.utils.Array;
import com.jeremiebou.projecttau.Systems.KeyActionPacket;

public class InputControllableComponent extends Component{
	private Array<KeyActionPacket> keyActionArray = new Array<KeyActionPacket>();
	
	public InputControllableComponent(Array<KeyActionPacket> keyActionArray){
		this.keyActionArray = keyActionArray;
	}

	public Array<KeyActionPacket> getKeyActionArray() {
		return keyActionArray;
	}
}
