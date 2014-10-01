package com.DCStudios.VBall.Interface;

import java.util.ArrayList;
import java.util.List;

import com.DCStudios.VBall.VBall;
import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Rendering.Renderable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class InterfaceObject implements Renderable, InputObserver {
	
	private Vector2 position;
	private Vector2 drawingPosition;
	private Measure measure;
	protected boolean visible = true;
	
	protected ShapeRenderer render = new ShapeRenderer();
	
	protected  BitmapFont font;
	protected  BitmapFont smallFont;
	
	protected List<MouseListener> mouseListener = new ArrayList<MouseListener>();
	protected List<KeyListener> keyListener = new ArrayList<KeyListener>();
	
	protected Color color = new Color(0.2f, 0.2f, 0.2f, 0f);
	

	public InterfaceObject(Vector2 position, Measure measure) {
		this.position = position;
		this.drawingPosition = this.position.cpy();
		this.measure = measure;
		
		VBall.input.addObserver(this);
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("data/font.ttf"));

		FreeTypeFontParameter para = new FreeTypeFontParameter();
		para.size = 15;
		font = gen.generateFont(para);
		font.setColor(Color.WHITE);
		
		para.size = 10;
		smallFont = gen.generateFont(para);
		smallFont.setColor(Color.WHITE);
		
		gen.dispose();
	}
	
	public void addKeyListener(KeyListener keyListener) {
		this.keyListener.add(keyListener);
	}
	
	public void removeKeyListener(KeyListener keyListener) {
		this.keyListener.remove(keyListener);
	}
	
	public void addMouseListener(MouseListener mouseListener) {
		this.mouseListener.add(mouseListener);
	}
	
	public void removeMouseListener(MouseListener mouseListener) {
		this.mouseListener.remove(mouseListener);
	}
	
	public void removeAllMouseListener() {
		this.mouseListener.clear();
	}
	
	@Override
	public void keyInput(KeyEvent event, int keyCode) {
		switch(event) {
		case PRESS: 
			for (KeyListener listener : keyListener) {
				listener.onKeyPress(keyCode);
			}
			break;
		case RELEASE:
			for (KeyListener listener : keyListener) {
				listener.onKeyRelease(keyCode);
			}
			break;
		}
	}
	
	@Override
	public void mouseInput(MouseEvent event, Vector2 position) {
		switch (event) {
		case PRESS:
			for (MouseListener listener : mouseListener) {
				listener.onMousePress(position);
			}
			break;
		case RELEASE:
			if(isMouseOver()) {
				for (MouseListener listener : mouseListener) {
					listener.onMouseRelease(position);
				}
				break;
			}		
		case MOVE:
			for (MouseListener listener : mouseListener) {
				listener.onMouseMove(position);
			}
			break;
		default:
			break;
		}
	}
	
	public boolean isMouseOver() {
		if (Gdx.input.getX() >= (int) this.getDrawingPosition().x &&
				Gdx.input.getX() <= (int) this.getDrawingPosition().x + this.getMeasure().width &&
				Gdx.input.getY() * -1 + Gdx.graphics.getHeight() >= (int) this.getDrawingPosition().y &&
				Gdx.input.getY() * -1 + Gdx.graphics.getHeight() <= (int) this.getDrawingPosition().y + this.getMeasure().height) {
			return true;
		}
		return false;
	}

	@Override
	public Vector2 getPosition() {
		return position;
	}

	@Override
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	@Override
	public Measure getMeasure() {
		return measure;
	}

	@Override
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public void dispose() {
		render.dispose();
		VBall.input.removeObserver(this);
	}
	
	public Vector2 getDrawingPosition() {
		return drawingPosition;
	}
	
	public void setDrawingPosition(Vector2 drawingPosition) {
		this.drawingPosition = drawingPosition;
	}
	
	public void renderAtPosition(SpriteBatch batch, Vector2 position) {
		if (visible) {
			this.drawingPosition = position;
			render(batch);
		}
	}

}

