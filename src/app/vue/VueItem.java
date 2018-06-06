package app.vue;

import app.modele.Item;
import javafx.scene.image.ImageView;

public abstract class VueItem {
	
	protected Item item;
	private ImageView sprite;
	
	public VueItem(Item i, String url) {
		this.item = i;
		this.sprite = new ImageView(url);
		this.sprite.translateXProperty().bind(this.item.XProperty());
		this.sprite.translateYProperty().bind(this.item.YProperty());
	}
	
	public ImageView getSprite() {
		return sprite;
	}

}
