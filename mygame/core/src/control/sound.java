package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class sound {
	private Music music;
	private Sound sound;
	private String url;

	public sound(String url) {

		this.url = url;
		this.music = Gdx.audio.newMusic(Gdx.files.internal(url));
		//this.sound = Gdx.audio.newSound(Gdx.files.internal(url));
	}

	public void play() {
		this.music.play();
	}

	public void volume(float v) {
		this.music.setVolume(v);
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
