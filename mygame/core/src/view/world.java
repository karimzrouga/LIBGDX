package view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class world {

	private Texture pierres;

	private SpriteBatch batch;
	private Sprite sprite;

	public world(String img, float sizee) {

		pierres = new Texture(img);
		sprite = new Sprite(pierres);
		float size = pierres.getWidth() / sizee;
		sprite.setSize(size, size);
		batch = new SpriteBatch();

	}
	

	public void obstacles(OrthographicCamera camera) {

		batch.begin();

		for (float i = 2 * sprite.getWidth(); i < camera.viewportWidth - 3 * sprite.getWidth(); i++) {
			for (float j = 2 * sprite.getWidth(); j < camera.viewportHeight - 2 * sprite.getWidth(); j++) {
				sprite.draw(batch);
				sprite.setPosition(i, j);

				j += 2 * sprite.getWidth();

			}
			i += 2 * sprite.getWidth();

		}
		batch.end();
	}

	public void worldlimit(OrthographicCamera camera) {
		int nb = Math.round((camera.viewportWidth) / (sprite.getWidth()));
		batch.begin();
		int i = 0, j = 0;
		while (j < nb) {
			// corn (0,0)
			sprite.draw(batch);
			sprite.setPosition(i, 0);
			//
			sprite.draw(batch);
			sprite.setPosition(0, i);
			//

			sprite.draw(batch);
			sprite.setPosition(camera.viewportWidth - sprite.getWidth(), i);
			//
			sprite.draw(batch);
			sprite.setPosition(i, camera.viewportHeight - sprite.getWidth());
			i += sprite.getWidth();
			j++;
		}

		batch.end();
	}

	public Texture getPierres() {
		return pierres;
	}

	public void setPierres(Texture pierres) {
		this.pierres = pierres;
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
