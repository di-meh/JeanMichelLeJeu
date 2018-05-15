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

	private Image imagetest;


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.map = new Map();
		this.jeu = new Jeu(this.map);
		// TODO Auto-generated method stub
		//		this.imagetest = new Image("./Ressources/tile_herbe.jpg", 16, 0, false, false);
		//		ImageView iv = new ImageView();
		//		iv.setImage(this.imagetest);
		//		iv.setFitWidth(16);
		//		iv.setPreserveRatio(true);
		//		iv.setCache(true);
		//		this.robert = new Pane();
		//		this.map = new TilePane();



	}

}

