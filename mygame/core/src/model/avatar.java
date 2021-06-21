package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class avatar  {
	private String img;
	private Texture avatar;
	private SpriteBatch batch;
	private Sprite sprite;

	private float size;

	public avatar(String img, double size2) {

		avatar = new Texture(img);
		sprite = new Sprite(avatar);
		size = avatar.getWidth() /(float)size2;
		sprite.setSize(size, size);
		batch = new SpriteBatch();

	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Texture getAvatar() {
		return avatar;
	}

	public void setAvatar(Texture avatar) {
		this.avatar = avatar;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}
}
