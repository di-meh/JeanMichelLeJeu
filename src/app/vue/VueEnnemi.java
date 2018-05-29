package app.vue;

import app.modele.Ennemi;
import javafx.scene.image.Image;

public class VueEnnemi {

	private Ennemi ennemi;

	private Image sprite = new Image("file:./src/app/img/cactus.png");

	//private SimpleIntegerProperty positionX, positionY;

	public VueEnnemi(Ennemi e) {
		this.setEnnemi(e);
		//this.obstacles = new ArrayList<Integer>();

	}

	public Image getImage() {
		return this.sprite;
	}


	public Image getSprite() {
		return sprite;
	}

	public Ennemi getHeros() {
		return ennemi;
	}

	public void setEnnemi(Ennemi e) {
		this.ennemi = e;
	}
}
