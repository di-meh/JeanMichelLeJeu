package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import app.modele.JeanMichel;
import app.modele.Jeu;
import app.modele.Terrain;
import app.vue.VueJeanMichel;
import app.vue.VueTerrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable{

	private Jeu jeu;

	private Terrain map;
	private VueTerrain vueMap;

	private JeanMichel heros;
	private VueJeanMichel vueHeros;
	
	
	@FXML
	private Pane pane;

	@FXML
	private TilePane tilemap;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.heros = new JeanMichel(null, 0, 0);
		this.vueHeros = new VueJeanMichel(heros);
		this.map = new Terrain();
		this.vueMap = new VueTerrain(this.map);


		//this.setJeu(new Jeu(this.map));
		
		//Ajout des élements dans le Scene Builder
		this.pane.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(new ImageView(vueHeros.getSprite()));
		
		//Bind la position du sprite à la position du héros
		
		pane.getChildren().get(2).layoutXProperty().bind(heros.XProperty());
		pane.getChildren().get(2).layoutYProperty().bind(heros.YProperty());
	}



	public Jeu getJeu() {
		return jeu;
	}


	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public VueJeanMichel getVueJeanMichel() {
		return this.vueHeros;
	}
}

