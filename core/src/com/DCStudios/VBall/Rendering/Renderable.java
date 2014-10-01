package com.DCStudios.VBall.Rendering;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface Renderable extends Disposable, Updateable {
	void render(SpriteBatch batch);
	Vector2 getPosition();
	void setPosition(Vector2 position);
	Measure getMeasure();
	void setMeasure(Measure measure);
	void setVisible(boolean visible);
	void dispose();
}
