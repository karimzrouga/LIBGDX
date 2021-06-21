package model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class arme {

	private Texture arme, fire;
	private SpriteBatch batch, fbatch;
	private Sprite sprite, fsprite;
	private float posx, posy;

	public arme(String img1, String img2, double size2) {

		arme = new Texture(img1);
		sprite = new Sprite(arme);
		float size = arme.getWidth() / (float) size2;
		sprite.setSize(size, size);
		batch = new SpriteBatch();
		fire = new Texture(img2);
		fsprite = new Sprite(fire);

		fsprite.setSize(50, 50);
		fbatch = new SpriteBatch();
	}

	public void draw() {

		batch.begin();

		sprite.draw(batch);

		batch.end();
		//////////////
		fbatch.begin();

		fsprite.draw(fbatch);

		fbatch.end();

	}

	public void firre(OrthographicCamera camera) {
		fsprite.translateX(-8);
		if (fsprite.getX()<=0) {
			fsprite.setPosition(posx, posy);
		}
	}

	public void armeposition(float f, float g) {
		posx = f;
		posy = g;
		sprite.setPosition(f, g);
		fsprite.setPosition(f + 1, g + 1);

	}
	public boolean isoverlaps (player p)
	{  
		Rectangle rect1 = new Rectangle(fsprite.getX(),fsprite.getY(),fsprite.getWidth(),fsprite.getHeight());
		Rectangle rect2 = new Rectangle(p.getSprite().getX(),p.getSprite().getY(),p.getSprite().getWidth(),p.getSprite().getHeight());
		return rect1.overlaps(rect2);
	
	}

}
