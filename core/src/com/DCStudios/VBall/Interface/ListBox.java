package com.DCStudios.VBall.Interface;

import java.util.List;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class ListBox extends Container {
	
	private Color color = new Color(0.2f, 0.2f, 0.2f, 0f);

	public ListBox(Vector2 position, Measure measure, String ... values) {
		super(position, measure);
		int i = 1;
		Label tmp;
		for (String s : values) {
			tmp = new Label(s, new Vector2(0, 0));
			tmp.getPosition().set(measure.width / 2 - tmp.getMeasure().width / 2, i * 20);
			this.addObject(tmp);
			i++;
		}
	}
	
	public void addLabel(Label label) {
		//label.getPosition().set(getMeasure().width / 2 - label.getMeasure().width / 2, (getObjects().size() + 1) * 27);
		label.getPosition().set(6, getMeasure().height - ((getObjects().size() + 1) * 23));
		addObject(label);
	}

	@Override
	public void render(SpriteBatch batch) {		
		batch.end();
		render.begin(ShapeType.Filled);
		render.setColor(color);
		render.rect(getDrawingPosition().x, getDrawingPosition().y, getMeasure().width, getMeasure().height);
		render.end();
		
		render.begin(ShapeType.Line);
		render.setColor(Color.BLACK);
		render.rect(getDrawingPosition().x, getDrawingPosition().y, getMeasure().width, getMeasure().height);
		render.end();
		batch.begin();
		super.render(batch);	
	}
	
	public void resetAllText() {
		for (InterfaceObject label : getObjects()) {
			((Label) label).setText("");
		}
	}

	@Override
	public void update() {
	}

}
