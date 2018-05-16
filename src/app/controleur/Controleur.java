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


public class Controleur implements Initializable{

	//TODO Copier information de fichier XMLforFXML.java afin d'extraire les informations à partir d'un fichier xml

	//mettre dans le modèle après avoir testé

	private Jeu jeu;
	private Map map;

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilemap;

	private Image imagetest;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String nomImage;

		this.tilemap.setPrefColumns(12);
		this.tilemap.setPrefRows(12);
		//tilepane setprefcol et prefrow
		this.map = new Map();
		this.jeu = new Jeu(this.map);
		int [][] t2 = this.map.getTab2d();
		for (int x = 0; x< t2.length; x++) {
			for (int y =0; y< t2[x].length; y++) {
				nomImage = this.map.imageDe(t2[x][y]);
				this.imagetest = new Image(nomImage);
				ImageView img = new ImageView();
				img.setImage(imagetest);
				this.tilemap.getChildren().add(img);
			}
		}



	}

}

