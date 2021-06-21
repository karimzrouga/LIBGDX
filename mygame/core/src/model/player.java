package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class player extends avatar {


	public player(String texture ,double size) {
		super(texture,size);
	}

	public void draw_avatar() {

		super.getBatch().begin();

		super.getSprite().draw(super.getBatch());;

		super.getBatch().end();
	}

	public Texture getAvatar() {
		return super.getAvatar();
	}

	public void setAvatar(Texture avatar) {
		super.setAvatar(avatar);
	}

	public SpriteBatch getBatch() {
	return super.getBatch();
	}

	public void setBatch(SpriteBatch batch) {
	super.setBatch(batch);
	}

	public Sprite getSprite() {
		return super.getSprite();
	}

	public void setSprite(Sprite sprite) {
		super.setSprite(sprite);
	}

	
	public void setStextture(Texture img) {
		super.setAvatar(img);
	}

	

	

	

}
