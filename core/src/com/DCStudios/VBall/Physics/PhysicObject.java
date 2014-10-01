package com.DCStudios.VBall.Physics;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Rendering.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class PhysicObject extends GameObject {
	
	protected World physic;
	protected Body body;
	protected BodyDef bodyDef;
	protected FixtureDef fixtureDef;
	protected Shape shape;

	public PhysicObject(World physic, Texture texture, Vector2 position, Measure measure) {
		super(texture, position, measure);	
		this.physic = physic;
		setUpBody();
	}
	
	@Override
	public void update() {
		sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2,
				body.getPosition().y - sprite.getHeight() / 2);
		sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
		super.update();
	}
	
	public Body getBody() {
		return body;
	}
	
	public abstract void setUpBody();

}
