package model;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class randobstacle {
	private Texture randobstacle;
	private SpriteBatch batch;
	private Sprite sprite;
	
	private ArrayList<Boolean> rand = new ArrayList<Boolean>();

	public randobstacle(String img) {

		randobstacle = new Texture(img);
		sprite = new Sprite(randobstacle);
		float size = randobstacle.getWidth() / 50f;
		sprite.setSize(size, size);
		batch = new SpriteBatch();
		Random randomGenerator = new Random();
		for (int idx = 1; idx <= 90; ++idx) {
			boolean randomBool = randomGenerator.nextBoolean();
			//System.out.println("Generated : " + randomBool);
			rand.add(randomBool);
		}
	}

	public void drawobstacle(OrthographicCamera camera, Sprite sprite2) {

		batch.begin();
		float j=sprite2.getWidth();
		int index =1;
		
		while (  j<camera.viewportHeight-2*sprite.getWidth())
		{   
			
			for (float i =sprite2.getWidth() ; i<camera.viewportWidth-2*sprite.getWidth() ;i++)
			{  
				
					if ( index==1)
					{
						
						sprite.draw(batch);
						sprite.setPosition(i, j+sprite.getWidth());	
						
					}
					else
					{
						sprite.draw(batch);
						sprite.setPosition(i, j);
					}
			
				
				i+=2*sprite2.getWidth();
				index++;
			}
		
			j+=sprite2.getWidth();
		}
		batch.end();
	}

	public Texture getRandobstacle() {
		return randobstacle;
	}

	public void setRandobstacle(Texture randobstacle) {
		this.randobstacle = randobstacle;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}



}