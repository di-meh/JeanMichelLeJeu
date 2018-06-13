package app.vue;

import java.util.ArrayList;

//import java.util.ArrayList;

import app.modele.Personnage;
//import javafx.beans.value.ObservableValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class VuePersonnage {

	private Personnage personnage;
	private ImageView sprite;
	private Rectangle2D rectangle;

	private ArrayList<ImageView> sprites;

	public VuePersonnage(Personnage p, String url) {
		this.personnage = p;
		this.sprite = new ImageView(url);
		this.sprites = new ArrayList<>();
		sprites.add(sprite);
		this.sprite.translateXProperty().bind(this.personnage.XProperty());
		this.sprite.translateYProperty().bind(this.personnage.YProperty());
		rectangle = new Rectangle2D(sprite.getX(), sprite.getY(), sprite.getFitWidth(), sprite.getFitHeight());
		//sprite.viewportProperty().bind(personnage.getRectangle());
	}

	//	public ImageView getSprite() {
	//		int d = 0;
	//		switch(d) {
	//		case 0: return this.sprites.get(0);
	//		case 1: return this.sprites.get(1);
	//		case 2: return this.sprites.get(2);
	//		case 3: return this.sprites.get(3);
	//		}
	//		return this.sprites.get(0);
	//		
	//	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public ImageView getSprite() {
		return this.sprite;
	}

	public Rectangle2D getRectangle() {
		return rectangle;
	}
}