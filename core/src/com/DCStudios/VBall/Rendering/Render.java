package com.DCStudios.VBall.Rendering;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class Render implements isRender {

	private Map map;

	private SpriteBatch batch;
	private OrthographicCamera camera;

	private Box2DDebugRenderer box2DRenderer;

	private Measure measure;
	private float zoom = 10f;

	private boolean renderPhysics = false;
	private boolean renderBackground = true;
	private boolean renderDrawables = true;
	private boolean renderLight = false;
	
	private Matrix4 normalProjection;

	public Render(Map map) {
		this.map = map;
		//LightRender.initLightRender(map.getPhysic());
		box2DRenderer = new Box2DDebugRenderer();
		measure = new Measure((int) (Gdx.graphics.getWidth() / zoom),
				(int) (Gdx.graphics.getHeight() / zoom));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, measure.width, measure.height);
		camera.update();
		batch = new SpriteBatch();
		normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());

		batch.setProjectionMatrix(normalProjection);
		//batch.setProjectionMatrix(camera.combined);
		
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//batch.setProjectionMatrix(camera.combined);

		batch.setProjectionMatrix(normalProjection);
					
		map.step();
		batch.begin();
		renderBackground();
		batch.end();

		renderPhysic();

		batch.begin();
		renderGraphics();
		batch.end();
		
		renderLight();
	}

	@Override
	public void renderBackground() {
		if (renderBackground) {
			batch.draw(map.getBackground(), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
	}

	@Override
	public void renderLight() {
		if (renderLight) {
			LightRender.render(camera);
		}
	}

	@Override
	public void renderGraphics() {
		if (renderDrawables) {
			for (Renderable renderable : map.getRenderables()) {
				renderable.render(batch);
			}
		}
	}

	@Override
	public void renderPhysic() {
		if (renderPhysics) {
			box2DRenderer.render(map.getPhysic(), camera.combined);
		}	
	}

	@Override
	public void dispose() {
		map.dispose();
		batch.dispose();
		box2DRenderer.dispose();
	}
}
