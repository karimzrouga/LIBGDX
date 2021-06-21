package view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import control.Collision;
import control.inputcontrol;
import control.menu;
import control.sound;
import model.alien;
import model.player;
import model.robot;
import model.arme;

import java.util.Random;
import model.randobstacle;

public class game extends ApplicationAdapter {
	private static final float VIRTUAL_WIDTH = 600;
	private Texture door;
	private SpriteBatch batchd;
	private Sprite sprited;
	private OrthographicCamera camera;
	private player player;
	private inputcontrol controlinput;
	private randobstacle obstacle;
	private alien Alien, Alien2, Alien3, Alien4, Alien5;
	private robot fire;
	private int posy, posx;
	private menu MENU;
	private world gmaeworld;
	private Sprite sprite;
	private Collision collusion;
	private sound music;
	private arme lazer;

	@Override
	public void create() {

		music = new sound("t.mp3");
		lazer = new arme("23.png", "l.png", 15);
		door = new Texture("door.png");
		sprited = new Sprite(door);
		int size1 = door.getWidth() / 12;
		sprited.setSize(size1, size1);
		batchd = new SpriteBatch();

		player = new player("toad.png", 8);
		gmaeworld = new world("mur.png", 50);
		sprite = gmaeworld.getSprite();
		///////////////////////////////////////////////////////////
		obstacle = new randobstacle("randobstacle.png");
///////////////////////////////////////////////////////////
		Alien = new alien("kill1.png", 19);
		Alien2 = new alien("kill3.png", 19);
		Alien3 = new alien("kill2.png", 27);
		Alien4 = new alien("kill4.png", 19);
		Alien5 = new alien("kill5.png", 19);
/////////////////////////////////////////////////////////
		controlinput = new inputcontrol(player, 0);
		fire = new robot("feuuuuu.png ", 3);
		///////////////////////////////////////////////////////////////////
		camera = new OrthographicCamera();
		Random objGenerator = new Random();
		posx = objGenerator.nextInt(400);
		posy = objGenerator.nextInt(400);
		MENU = new menu("stacked.png");

	}

	public void drawdoor() {

		batchd.begin();

		sprited.draw(batchd);

		batchd.end();
	}

	@Override

	public void render() {

		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gmaeworld.getBatch().setProjectionMatrix(camera.combined);

		if (MENU.isStarted()) {
			gmaeworld.worldlimit(camera);
			gmaeworld.obstacles(camera);
			lazer.draw();
			lazer.firre(camera);
			collusion = new Collision(player.getSprite(), Alien.getSprite());
			Alien.draw_Alien();
			Alien.automove(camera, sprite, 1);
			Alien2.draw_Alien();
			Alien2.automove(camera, sprite, 2);
			Alien3.draw_Alien();
			Alien3.automove(camera, sprite, 1);
			Alien4.draw_Alien();
			Alien4.automove(camera, sprite, 1);
			Alien5.draw_Alien();
			Alien5.automove(camera, sprite, 2);
			player.draw_avatar();
			controlinput.move(camera, sprite.getWidth(), player, collusion.isoverlaps());
			controlinput.fire(fire, player.getSprite());
			attack();
			end();
		} else {
			MENU.start(camera);
			music.play();
		}

	}

	private void attack() {

		Rectangle rect2 = new Rectangle(Alien.getSprite().getX(), Alien.getSprite().getY(),
				Alien.getSprite().getWidth(), Alien.getSprite().getHeight());

		Rectangle rect3 = new Rectangle(Alien2.getSprite().getX(), Alien2.getSprite().getY(),
				Alien2.getSprite().getWidth(), Alien2.getSprite().getHeight());
		Rectangle rect4 = new Rectangle(Alien3.getSprite().getX(), Alien3.getSprite().getY(),
				Alien.getSprite().getWidth(), Alien3.getSprite().getHeight());
		Rectangle rect5 = new Rectangle(Alien4.getSprite().getX(), Alien4.getSprite().getY(),
				Alien.getSprite().getWidth(), Alien4.getSprite().getHeight());
		Rectangle rect6 = new Rectangle(Alien5.getSprite().getX(), Alien5.getSprite().getY(),
				Alien.getSprite().getWidth(), Alien5.getSprite().getHeight());

		Rectangle rect1 = new Rectangle(fire.getSprite().getX(), fire.getSprite().getY(), fire.getSprite().getWidth(),
				fire.getSprite().getHeight());
		if (rect1.overlaps(rect2)) {

			Alien.getSprite().setScale(0);
			Alien.setIsdead(true);

		}
		if (rect1.overlaps(rect3)) {

			Alien2.getSprite().setScale(0);
			Alien2.setIsdead(true);

		}
		if (rect1.overlaps(rect4)) {

			Alien3.getSprite().setScale(0);
			Alien3.setIsdead(true);

		}
		if (rect1.overlaps(rect5)) {

			Alien4.getSprite().setScale(0);
			Alien4.setIsdead(true);

		}
		if (rect1.overlaps(rect6)) {

			Alien5.getSprite().setScale(0);
			Alien5.setIsdead(true);

		}
	}

	public void resize(int width, int height) {

		float virtualHeight = VIRTUAL_WIDTH * (float) height / width;
		camera.setToOrtho(false, VIRTUAL_WIDTH, virtualHeight);
		player.getBatch().setProjectionMatrix(camera.combined);
		obstacle.getBatch().setProjectionMatrix(camera.combined);
		gmaeworld.getBatch().setProjectionMatrix(camera.combined);
		sprite.setPosition((camera.viewportHeight / 3), 10);
		Alien3.getBatch().setProjectionMatrix(camera.combined);
		player.getSprite().setPosition(player.getSprite().getWidth(), player.getSprite().getWidth());
		gmaeworld.getBatch().setProjectionMatrix(camera.combined);

		Alien.setposition(3 * sprite.getWidth(), 6 * sprite.getWidth() + Alien.getSize() / 3f);

		Alien2.setposition(2 * sprite.getWidth() + 5, 2 * sprite.getWidth() + Alien2.getSize() / 5f);

		Alien3.setposition(2 * sprite.getWidth(), 2 * sprite.getWidth() + Alien3.getSize() / 5f);
		sprited.setPosition(posx, posy);
		Alien4.setposition(4 * sprite.getWidth() + 5,
				10 + (this.obstacle.getSprite().getWidth() * 3) + camera.viewportHeight / 2f);

		Alien5.setposition(camera.viewportWidth - (this.obstacle.getSprite().getWidth() * 2),
				8 * sprite.getWidth() + Alien3.getSize() / 5f);
		sprited.setPosition(posx, posy);
		lazer.armeposition(camera.viewportWidth, (camera.viewportHeight / 2f) - 15);
	}

	private boolean check() {
		Alien.kill(player);
		Alien2.kill(player);
		Alien3.kill(player);
		Alien4.kill(player);
		Alien5.kill(player);
		if (Alien.kill(player) || Alien2.kill(player) || Alien3.kill(player) || Alien4.kill(player)
				|| Alien5.kill(player) || lazer.isoverlaps(player)) {
			MENU.setStr("LOOOOOOOSER");
			MENU.setStarted(false);

		}

		if (this.Alien.isIsdead() && this.Alien2.isIsdead() && this.Alien3.isIsdead() && this.Alien4.isIsdead()
				&& this.Alien5.isIsdead()) {

			drawdoor();
			return true;

		}
		return false;

	}

	private void end() {
		if (check()) {
			Rectangle rect1 = new Rectangle(player.getSprite().getX(), player.getSprite().getY(),
					player.getSprite().getWidth(), player.getSprite().getHeight());
			Rectangle rect2 = new Rectangle(this.sprited.getX(), this.sprited.getY(), this.sprited.getWidth(),
					this.sprited.getHeight());
			if (rect1.overlaps(rect2)) {

				player.getSprite().setScale(0);
				MENU.setStr("WINNNNNNNNER");
				MENU.setStarted(false);

			}
		}

	}

	@Override
	public void dispose() {
		obstacle.getBatch().dispose();
		player.getBatch().dispose();
		Alien.getBatch().dispose();
		gmaeworld.getBatch().dispose();
	}

}
