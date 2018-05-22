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
		//TODO faire un new terrainVue(this.terrain) et c'est terrainVue qui construit les images.


		//this.setJeu(new Jeu(this.map));

		this.pane.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(new ImageView(vueHeros.getSprite()));
		vueHeros.getPositionX().bind(heros.XProperty());
		vueHeros.getPositionY().bind(heros.YProperty());
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
	//	public void gererfleche(KeyEvent e) {
	//		
	//		KeyCode value = e.getCode();
	//		switch (value) {
	//		case Z : pane.getChildren().get(1).setLayoutY(pane.getChildren().get(1).getLayoutY()-5);
	//			//TODO appeler une méthode sur le personnage qui déplace le y
	//			break;
	//		case Q : pane.getChildren().get(1).setLayoutX(pane.getChildren().get(1).getLayoutX()-5);
	//			break;
	//		case S : pane.getChildren().get(1).setLayoutY(pane.getChildren().get(1).getLayoutY()+5);
	//			break;
	//		case D : pane.getChildren().get(1).setLayoutX(pane.getChildren().get(1).getLayoutX()+5);
	//			break;
	//		default:
	//			break;
	//		}
	//	}



}

