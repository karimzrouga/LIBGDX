package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class menu {
	private Texture logo;
	private SpriteBatch logobatch;
	private Sprite logosprites;

	//////////////////////////////////////
	private SpriteBatch spriteBatch = new SpriteBatch();
	private BitmapFont font;
	private CharSequence str = "PRESS ENTER TO START THE GAME";
	private boolean started = false;

	public menu(String img) {
		font = new BitmapFont();
		logo = new Texture(img);
		logosprites = new Sprite(logo);
		int size = logo.getWidth();
		logosprites.setSize(size, size);
		logobatch = new SpriteBatch();

	}

	public void start(OrthographicCamera camera) {
		logobatch.begin();
		logosprites.draw(logobatch);
		logobatch.end();

		spriteBatch.begin();
		font.draw(spriteBatch, str, (camera.viewportWidth / 3f), camera.viewportHeight / 6f);
		spriteBatch.end();
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			this.started = true;

		}
	}

	public CharSequence getStr() {
		return str;
	}

	public void setStr(CharSequence str) {
		this.str = str;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}
}
