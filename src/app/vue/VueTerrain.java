package app.vue;

import app.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class VueTerrain {

	private Terrain terrain;

	private TilePane tilemap_base, tilemap_obs;

	private int tailleMap;

	public VueTerrain(Terrain t) {
		this.terrain = t;
		this.tailleMap = this.terrain.getTailleTab();

		int [][] t2base = this.terrain.getTab2dBase();
		int [][] t2obs = this.terrain.getTab2dObs();
		
		this.tilemap_base = ajoutTiles(t2base);
		this.tilemap_obs = ajoutTiles(t2obs);
	}
	
	private TilePane ajoutTiles(int [][] tab) {
		TilePane map = new TilePane();
		map.setPrefColumns(tailleMap);
		map.setPrefRows(tailleMap);
		for (int x = 0; x< tab.length; x++) {
			for (int y =0; y< tab[x].length; y++) {
				Image img = new Image("file:" + imageDe(tab[x][y]));
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				map.getChildren().add(imgVw);
			}
		}
		return map;
	}

	public TilePane getTileMap() {
		return this.tilemap_base;
	}
	public TilePane getTileMapObs() {
		return this.tilemap_obs;
	}

	public String imageDe(int i) {
		try {
			return "./src/app/img/tile_" + i + ".png";
		}catch (Exception e) {
			e.printStackTrace();
			return "./src/app/img/tile_0.png";
		}
	}	
}