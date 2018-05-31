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

		this.tilemap_base = new TilePane();
		this.tilemap_obs = new TilePane();

		this.tilemap_base.setPrefColumns(tailleMap);
		this.tilemap_base.setPrefRows(tailleMap);

		this.tilemap_obs.setPrefColumns(tailleMap);
		this.tilemap_obs.setPrefRows(tailleMap);

		int [][] t2base = this.terrain.getTab2dBase();
		int [][] t2obs = this.terrain.getTab2dObs();

		for (int x = 0; x< t2base.length; x++) {
			for (int y =0; y< t2base[x].length; y++) {
				Image img = new Image("file:" + imageDe(t2base[x][y]));
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				this.tilemap_base.getChildren().add(imgVw);
			}
		}

		for (int x = 0; x< t2obs.length; x++) {
			for (int y = 0; y<t2obs[x].length; y++) {
				Image img = new Image("file:" + imageDe(t2obs[x][y]));
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				this.tilemap_obs.getChildren().add(imgVw);
			}
		}
	}

	public TilePane getTileMap() {
		return this.tilemap_base;
	}
	public TilePane getTileMapObs() {
		return this.tilemap_obs;
	}

	public String imageDe(int i) {
		try {
			return "./src/app/img/tile_"+i+".png";
		}catch (Exception e) {
			e.printStackTrace();
			return "./src/app/img/tile_0.png";
		}
	}	
}