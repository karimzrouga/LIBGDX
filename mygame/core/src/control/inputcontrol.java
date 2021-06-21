package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

import model.player;
import model.robot;

public class inputcontrol {
	boolean done = false;
	private Sprite sprite;
	private int speed = 0;

	public inputcontrol(player sprite, int intiposition ) {

		this.sprite = sprite.getSprite();
		this.speed = (int) (sprite.getSprite().getWidth() + 2);

	}

	public void fire(robot b, Sprite sprite2) {
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

			b.getSprite().setPosition(sprite2.getX(), sprite2.getY());
		
			done=true;
		}
		
		if (done)
			b.draw_bomb();
		
		
	}

	public void move(OrthographicCamera camera, float f, player av ,boolean end) {
if (end==false)
{
	if (Gdx.input.isKeyJustPressed(Keys.UP)) {

		if ((int) sprite.getX() % 2 == 0) {

			sprite.translateY(speed);

			// System.out.println(av.getPosition());

		}

	}

	if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {

		if ((int) sprite.getX() % 2 == 0) {
			sprite.translateY(-speed);
		
			// System.out.println(av.getPosition());
		}
	}
	if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {

		if ((int) sprite.getY() % 2 == 0) {
			sprite.translateX(speed);
		
			// System.out.println(av.getPosition());
		}

	}

	if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
		if ((int) sprite.getY() % 2 == 0) {
			sprite.translateX(-speed);

			
		
		}
	}
}
		

		sprite.setX(MathUtils.clamp(sprite.getX(), f, camera.viewportWidth - 3 * f));
		sprite.setY((float) MathUtils.clamp(sprite.getY(), f, camera.viewportHeight - 2.7 * f));

	}

}