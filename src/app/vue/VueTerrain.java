package app.vue;

import app.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueTerrain {
	
	private Terrain terrain;
	
	public VueTerrain(Terrain t) {
		this.terrain = t;
		int [][] t2 = this.terrain.getTab2d();
		for (int x = 0; x< t2.length; x++) {
			for (int y =0; y< t2[x].length; y++) {
				Image img = new Image(this.terrain.imageDe(t2[x][y]));
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				//this.tilemap.getChildren().add(imgVw);
			}
		}
	}
	
	
	
}
