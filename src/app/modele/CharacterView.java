package app.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterView {

	private ImageView imageView;
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	private Rectangle2D croppedPortion;
	
	public CharacterView() {
		this.imageView = new ImageView(new Image("./src/app/modele/Essaianim.png"));
		this.x = 0;
		this.y = 0;
		this.width = 14;
		this.height = 52;
	}
	
	public void getImage(int i) {
		switch(i) {
		case 1: cropImage(1, 1);
		case 2: cropImage(1, 2 * this.width);
		case 3: cropImage(1, 3 * this.width);
		case 4: cropImage(1, 4 * this.width);
		}
	}
	
	public void cropImage(int w, int h) {
		imageView.setViewport(croppedPortion);
		imageView.setFitWidth(w);
		imageView.setFitHeight(h);
	}
}