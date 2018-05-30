package app.vue;

import app.modele.PNJ;
import javafx.scene.image.Image;

public class VuePNJ {
	
	private PNJ pnj;

	private Image sprite = new Image("file:./src/app/img/1.png");

	public VuePNJ(PNJ p) {
		this.setPNJ(p);
	}

	public Image getImage() {
		return this.sprite;
	}

	public Image getSprite() {
		return sprite;
	}

	public PNJ getPNJ() {
		return this.pnj;
	}

	public void setPNJ(PNJ p) {
		this.pnj = p;
	}
}
