package model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.math.Rectangle;

public class alien extends avatar {
	boolean tt = false, tb = false, tl = true, tr = true;
	boolean ability = true;
	private boolean isdead;
	ArrayList<point> position = new ArrayList<point>();

	public alien(String img, int size) {
		super(img, size);

	}

	public void draw_Alien() {
	
		super.getBatch().begin();

		super.getSprite().draw(super.getBatch());
		;

		super.getBatch().end();
	}

	public void automove(OrthographicCamera camera, Sprite mur, int select) {
		switch (select) {
		case 1: {
			if (tl && super.getSprite().getX() > mur.getWidth()
					&& super.getSprite().getX() <= camera.viewportWidth - 2*mur.getWidth() ) {
				super.getSprite().translateX(+2);

				tr = false;
			} else {
				tr = true;

			}

			if (tr && super.getSprite().getX() > mur.getWidth() && super.getSprite().getX() > mur.getWidth() + 10) {
				super.getSprite().translateX(-3);

				tl = false;
			} else {
				tl = true;

			}

			break;
		}

		case 2: {
			if (tt && super.getSprite().getY() > mur.getWidth()
					&& super.getSprite().getY() < camera.viewportHeight - 2* mur.getWidth()) {
				super.getSprite().translateY(+2);
			//	System.out.println("11111");
				tb = false;
			} else {

				tt = false;

				tb = true;
				

			}

			if (tb&&super.getSprite().getY() > mur.getWidth()&& super.getSprite().getY() >mur.getWidth() + 10 ) {
				super.getSprite().translateY(-3);

			//	System.out.println("2222");
				tt = false;
			} else {
				tt = true;
				tb = false;
				
			//	System.out.println("else");
			}

			break;
		}
		}
		// super.getSprite().setX(MathUtils.clamp( super.getSprite().getX(),
		// mur.getWidth() , camera.viewportWidth-mur.getWidth()));

		// super.getSprite().setY(MathUtils.clamp( super.getSprite().getY(),
		// mur.getWidth() , camera.viewportHeight-2*mur.getWidth()));

	}

	public void setposition(float initposx, float initposy) {
		super.getSprite().setPosition(initposx, initposy);
	}

	public boolean isIsdead() {
		return isdead;
	}

	public void setIsdead(boolean isdead) {
		this.isdead = isdead;
	}
	public boolean  kill(player player) {
		Rectangle rect1 = new Rectangle(player.getSprite().getX(), player.getSprite().getY(), player.getSprite().getWidth(),
				player.getSprite().getHeight());
		Rectangle rect2 = new Rectangle(super.getSprite().getX(), super.getSprite().getY(),
				super.getSprite().getWidth(), super.getSprite().getHeight());
		if (isIsdead()==false)
		{
			if (rect1.overlaps(rect2)) {

				player.getSprite().setScale(0);
				return true;
			}
		}
		return false;
		
	
		
	}

}