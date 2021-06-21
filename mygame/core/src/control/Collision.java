package control;




import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Collision  {
	
	
	


	private Sprite avatar , alien ;
	public Collision (Sprite s1 , Sprite s2) {
		this.avatar=s1;
		this.alien=s2;
	}
	
	
	public boolean isoverlaps ()
	{  
		Rectangle rect1 = new Rectangle(avatar.getX(),avatar.getY(),avatar.getWidth()-10,avatar.getHeight()-10);
		Rectangle rect2 = new Rectangle(alien.getX(),alien.getY(),alien.getWidth(),alien.getHeight());
		return rect1.overlaps(rect2);
	
	}

	
}