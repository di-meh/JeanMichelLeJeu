package app.vue;

import app.modele.ObstacleDeplacable;
import javafx.scene.image.ImageView;

public class VueObstacleDeplacable {
	
	private ObstacleDeplacable obstacle;
	private ImageView sprite;
	
	
	public VueObstacleDeplacable(ObstacleDeplacable o, String url) {
		this.obstacle = o;
		this.sprite = new ImageView(url);
	}

}
