package com.DCStudios.VBall.Rendering;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameObject implements Renderable {

	protected Vector2 position;
	protected Measure measure;
	
	protected Texture texture;
	protected Sprite sprite;
	
	private boolean visible = true;
	
	public GameObject(Texture texture, Vector2 position, Measure measure) {
		this.texture = texture;
		this.position = position;
		this.measure = measure;
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		sprite.setSize(measure.width, measure.height);
		sprite.setPosition(position.x, position.y);
	}
	
	public void render(SpriteBatch batch) {
		if (visible) {
			sprite.draw(batch);
		}
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
		sprite.setTexture(texture);
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	@Override
	public void update() {
		position.x = sprite.getX();
		position.y = sprite.getY();
	}

	@Override
	public void dispose() {
		texture.dispose();
	}

}
