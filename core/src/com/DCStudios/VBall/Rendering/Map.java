package com.DCStudios.VBall.Rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

public interface Map extends RenderableCollection, Disposable, Updateable {
	Texture getBackground();
	void step();
	World getPhysic();
}
