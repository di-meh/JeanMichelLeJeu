package app.vue;

import java.util.ArrayList;
import app.modele.Personnage;
import javafx.scene.image.ImageView;

public class VuePersonnage {

	private Personnage personnage;
	private ImageView sprite;

	private ArrayList<ImageView> sprites;

	public VuePersonnage(Personnage p, String url) {
		this.personnage = p;
		this.sprite = new ImageView(url);
		this.sprites = new ArrayList<>();
		sprites.add(sprite);
		this.sprite.translateXProperty().bind(this.personnage.XProperty());
		this.sprite.translateYProperty().bind(this.personnage.YProperty());
	}


	public Personnage getPersonnage() {
		return personnage;
	}

	public ImageView getSprite() {
		return this.sprite;
	}

}