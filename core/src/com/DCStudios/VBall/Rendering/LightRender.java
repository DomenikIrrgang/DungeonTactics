package com.DCStudios.VBall.Rendering;

import box2dLight.RayHandler;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.World;

public final class LightRender {
	private static RayHandler rayHandler;
	
	public static void initLightRender(World world) {
		rayHandler = new RayHandler(world);
	}
	
	public static RayHandler getRayHandler() {
		return rayHandler;
	}
	
	public static void render(OrthographicCamera camera) {
		LightRender.getRayHandler().setCombinedMatrix(camera.combined);
		LightRender.getRayHandler().updateAndRender();
	}
}
