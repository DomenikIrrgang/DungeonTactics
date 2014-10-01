package com.DCStudios.VBall.Screens.MainMenue;

import java.util.Collection;

import com.DCStudios.VBall.Rendering.Background;
import com.DCStudios.VBall.Rendering.Map;
import com.DCStudios.VBall.Rendering.Renderable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

public class MainMenue implements Map {
	
	private Background background;
	private Collection<Renderable> renderables;

	@Override
	public Collection<Renderable> getRenderables() {
		return null;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void update() {
	}

	@Override
	public Texture getBackground() {
		return null;
	}

	@Override
	public void step() {
	}

	@Override
	public World getPhysic() {
		return null;
	}

}
