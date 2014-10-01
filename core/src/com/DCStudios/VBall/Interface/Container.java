package com.DCStudios.VBall.Interface;

import java.util.ArrayList;
import java.util.List;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Container extends InterfaceObject {
	
	private List<InterfaceObject> objects = new ArrayList<InterfaceObject>();

	public Container(Vector2 position, Measure measure) {
		super(position, measure);
	}
	
	public void addObject(InterfaceObject object) {
		objects.add(object);
	}
	
	public void removeObject(InterfaceObject object) {
		objects.remove(object);
	}

	@Override
	public void render(SpriteBatch batch) {
		if (visible) {
			for (InterfaceObject object : objects) {
				object.renderAtPosition(batch, getDrawingPosition().cpy().add(object.getPosition()));
			}
		}
	}

	public List<InterfaceObject> getObjects() {
		return objects;
	}
	
	public void clear() {
		objects.clear();
	}
	
	@Override
	public void update() {
		for(InterfaceObject object : objects) {
			object.update();
		}
	}

}
