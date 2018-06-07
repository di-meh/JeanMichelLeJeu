package app.vue;

import app.modele.Item;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public abstract class VueItem {
	
	protected Item item;
	private ImageView sprite;
	private Rectangle2D rectangle;
	
	public VueItem(Item i, String url) {
		this.item = i;
		this.sprite = new ImageView(url);
		this.rectangle = new Rectangle2D(sprite.getX(), sprite.getY(), sprite.getFitWidth(), sprite.getFitHeight());
		this.sprite.translateXProperty().bind(this.item.XProperty());
		this.sprite.translateYProperty().bind(this.item.YProperty());
	}
	
	public ImageView getSprite() {
		return sprite;
	}
	
	public Rectangle2D getRectangle() {
		return rectangle;
	}

}
