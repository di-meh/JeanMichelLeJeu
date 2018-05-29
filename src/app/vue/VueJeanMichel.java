package app.vue;

import app.modele.JeanMichel;
import javafx.scene.image.Image;
//import java.util.ArrayList;

public class VueJeanMichel {

	private JeanMichel heros;

	private Image sprite = new Image("file:./src/app/img/jeanMi.png");

	public VueJeanMichel(JeanMichel heros) {
		this.setHeros(heros);
		//this.obstacles = new ArrayList<Integer>();

	}

	public Image getImage() {
		return this.sprite;
	}


	public Image getSprite() {
		return sprite;
	}

	public JeanMichel getHeros() {
		return heros;
	}

	public void setHeros(JeanMichel heros) {
		this.heros = heros;
	}
}

