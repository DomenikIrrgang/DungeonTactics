package com.DCStudios.VBall.Interface;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Animation2D extends InterfaceObject {
	
    private int cols = 6;     
    private int rows = 5;  
    private Texture texture;
    private Animation animation;
    
    private float stateTime;  
    private float frameTime;

	public Animation2D(Texture texture, int cols, int rows, Vector2 position, Measure measure) {
		super(position, measure);
		this.texture = texture;
		this.cols = cols;
		this.rows = rows;
		frameTime = 1f / (cols * rows);
		animation = createAnimation();
		stateTime = 0f;       
	}          

    private Animation createAnimation() {
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/cols, texture.getHeight()/rows);              // #10
        TextureRegion[] animationFrames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }
       return new Animation(frameTime, animationFrames);   
    }

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(getCurrentFrame(), getPosition().x, getPosition().y, getMeasure().width, getMeasure().height);
	}
	
	public void reset() {
		stateTime = 0;
	}
	
	private TextureRegion getCurrentFrame() {
		stateTime += Gdx.graphics.getDeltaTime();
		if (stateTime > 1f) {
			stateTime = 0;
		}
		return animation.getKeyFrame(stateTime, true); 
	}
	
	@Override
	public void update() {
	}

}
