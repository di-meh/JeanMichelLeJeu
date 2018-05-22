package app.vue;

import app.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class VueTerrain {
	
	private Terrain terrain;
	private TilePane tilemap;
	
	private int tailleMap = 12;
	
	public VueTerrain(Terrain t) {
		this.terrain = t;
		this.tilemap = new TilePane();
		this.tilemap.setPrefColumns(tailleMap);
		this.tilemap.setPrefRows(tailleMap);
		
		int [][] t2 = this.terrain.getTab2d();
		for (int x = 0; x< t2.length; x++) {
			for (int y =0; y< t2[x].length; y++) {
				Image img = new Image(this.terrain.imageDe(t2[x][y]));
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				this.tilemap.getChildren().add(imgVw);
			}
		}
	}
	
	public TilePane getTileMap() {
		return this.tilemap;
	}
	
	
}
