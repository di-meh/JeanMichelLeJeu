package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable{
	
	//TODO Copier information de fichier XMLforFXML.java afin d'extraire les informations à partir d'un fichier xml
	
	
	//mettre dans le modèle après avoir testé
	private int[] tab = {
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,
			210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210,210};
	
	
	
	
	private Image imagetest;
	
	public Controleur() {
    	//Jeu jeu = new Jeu();
    }
	
	public String imageDe(int i) {
		if (i == 210) return "./Ressources/tile_herbe.jpg";
		else return "Test";
	}
	
	public int[] getTab() {
		return this.tab;
	}
	
    @FXML
    private TilePane map;
    
    @FXML
    private Pane robert;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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

