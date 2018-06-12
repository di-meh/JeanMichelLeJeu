package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import app.modele.Coeur;
import app.modele.Ennemi;
import app.modele.Item;
//import app.modele.Ennemi;
//import app.modele.Item;
import app.modele.JeanMichel;
import app.modele.Jeu;
import app.modele.Terrain;
import app.vue.VueCoeur;
import app.vue.VueEnnemi;
import app.vue.VueItem;
import app.vue.VueJeanMichel;
import app.vue.VueTerrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {

	//modeles
	private Jeu jeu;
	private Terrain map;
	//vues
	private VueTerrain vueMap;
	private VueJeanMichel vueHeros;
	private VueEnnemi vueEnnemi;
	private VueItem vueitem;

	private Timeline gameLoop;

	//private ObservableList<Item> listeItems;
	private ObservableList<Ennemi> listeEnnemis;

	//FXML
	@FXML
	private BorderPane borderpane;
	@FXML
	private Pane pane;
	@FXML
	private TilePane tilemap;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.map = new Terrain();
		this.jeu = new Jeu();

		this.jeu.getJeanMichel().setJeu(this.jeu);
		this.jeu.getEnnemis().get(0).setJeu(this.jeu);

		this.vueEnnemi = new VueEnnemi(this.jeu.getEnnemis().get(0));
		this.vueMap = new VueTerrain(this.map);
		this.vueHeros = new VueJeanMichel(this.jeu.getJeanMichel());
		this.vueitem = new VueCoeur((Coeur)this.jeu.getListeItems().get(0));

		//Ajout des élements dans le Scene Builder

		this.tilemap.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(this.vueMap.getTileMapObs());
		this.pane.getChildren().add(this.vueMap.getTileMapMov());

		//affichage des persos
		this.pane.getChildren().add(vueitem.getSprite());
		this.pane.getChildren().add(vueHeros.getSprite());
		this.pane.getChildren().add(vueEnnemi.getSprite());
		init();
		getGameLoop().play();
	}

	//GameLoop
	private void init() {

		setGameLoop(new Timeline());
		getGameLoop().setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.018), //environ 60 FPS
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda

				(ev ->{
					//TODO gérer le changement de sprite
//					switch (this.getJeanMichel().getOrientation()) {
//					case 0:
//						break;
//					case 1: 
//						break;
//					case 2: 
//						break;
//					case 3: 
//						break;
//					}
					if (jeu.collisionObjet()) {
						//TODO le faire dans le modèle
						this.pane.getChildren().remove(vueitem.getSprite());
						this.jeu.getListeItems().remove(0);
						this.getJeanMichel().pointsVieProperty().set(this.getJeanMichel().getPointsVie()+5);
						if (this.getJeanMichel().getPointsVie() > 100) this.getJeanMichel().pointsVieProperty().set(100);

					}
					if(this.jeu.getJeanMichel().getPointsVie() == 0){
						System.out.println("Vous êtes mort");
						getGameLoop().stop();
					}
					else
						this.jeu.update();
				})
				);
		getGameLoop().getKeyFrames().add(kf);

	}

	private Timeline getGameLoop() {
		return gameLoop;
	}

	private void setGameLoop(Timeline gameLoop) {
		this.gameLoop = gameLoop;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public JeanMichel getJeanMichel() {
		return this.jeu.getJeanMichel();
	}

}
