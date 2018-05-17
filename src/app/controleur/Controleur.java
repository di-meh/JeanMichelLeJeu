package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import app.modele.Jeu;
import app.modele.Map;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class Controleur implements Initializable {

	private Jeu jeu;
	private Map map;

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilemap;

	private Image imagetest;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.tilemap.setPrefColumns(this.map.getTailleTab());
		this.tilemap.setPrefRows(this.map.getTailleTab());
		this.map = new Map();
		this.setJeu(new Jeu(this.map));
		int [][] t2 = this.map.getTab2d();
		for (int x = 0; x< t2.length; x++) {
			for (int y =0; y< t2[x].length; y++) {
				this.imagetest = new Image(this.map.imageDe(t2[x][y]));
				ImageView img = new ImageView();
				img.setImage(imagetest);
				this.tilemap.getChildren().add(img);
			}
		}
		this.pane.getChildren().add(new ImageView(new Image("./app/img/Female_Sprite_face2.png"))); // Image du personnage, à déplacer dans le modèle
//		jeu.init();
//		jeu.getGameLoop().play();
	}



	public Jeu getJeu() {
		return jeu;
	}



	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
}

