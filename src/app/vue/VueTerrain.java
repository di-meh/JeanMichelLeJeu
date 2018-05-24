package app.vue;


import app.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class VueTerrain {

	private Terrain terrain;
	private TilePane tilemap;

	private int tailleMap;

	
	
	public VueTerrain(Terrain t) {
		this.terrain = t;
		this.tailleMap = this.terrain.getTailleTab();
		this.tilemap = new TilePane();
		this.tilemap.setPrefColumns(tailleMap);
		this.tilemap.setPrefRows(tailleMap);

		int [][] t2 = this.terrain.getTab2d();
		for (int x = 0; x< t2.length; x++) {
			for (int y =0; y< t2[x].length; y++) {
				Image img = new Image(imageDe(t2[x][y]));
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				this.tilemap.getChildren().add(imgVw);
			}
		}
	}

	public TilePane getTileMap() {
		return this.tilemap;
	}
	public String imageDe(int i) {
		switch(i) {
		case 186: return "./app/img/tile_186.png";
		case 187: return "./app/img/tile_187.png";
		case 210: return "./app/img/tile_herbe.jpg";
		case 211: return "./app/img/tile_211.png";
		case 197: return "./app/img/tile_rocher.png";
		default: return "./app/img/tile_herbe.jpg"; // pour l'instant, on ajoute une tile verte dans le cas où il n'y a pas d'autres valeurs
		}	
	}

}
