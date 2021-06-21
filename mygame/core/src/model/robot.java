package model;


import com.badlogic.gdx.graphics.g2d.Sprite;


public class robot extends avatar {

	public robot(String texture, int size) {
	
		super(texture, size);
	

	}

	public void draw_bomb() {

		super.getBatch().begin();

		super.getSprite().draw(super.getBatch());;

		super.getBatch().end();
		super.getSprite().translateX(+4);
	}


	public Sprite getSprite() {
		return super.getSprite();
	}

	
}
