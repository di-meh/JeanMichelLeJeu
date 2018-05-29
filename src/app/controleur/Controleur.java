package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import app.modele.JeanMichel;
import app.modele.Jeu;
import app.modele.Terrain;
import app.vue.VueEnnemi;
import app.vue.VueJeanMichel;
import app.vue.VueTerrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {

	private Jeu jeu;
	private Terrain map;
	private VueTerrain vueMap;
	private JeanMichel heros;
	private VueJeanMichel vueHeros;
	private Timeline gameLoop;
	private VueEnnemi vueEnnemi;

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilemap;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.tilemap.setPrefColumns(12);
		this.tilemap.setPrefRows(12);
		this.map = new Terrain();
		this.jeu = new Jeu();

		this.vueEnnemi = new VueEnnemi(this.jeu.getEnnemi());
		this.vueMap = new VueTerrain(this.map);

		this.heros = new JeanMichel(null, 0, 0);
		this.vueHeros = new VueJeanMichel(heros);
		this.map = new Terrain();

		this.vueMap = new VueTerrain(this.map);

		//Ajout des élements dans le Scene Builder
		this.pane.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(new ImageView(vueHeros.getSprite()));
		
		this.pane.getChildren().add(new ImageView(vueEnnemi.getSprite()));
		//Bind la position du sprite à la position du héros

		
		pane.getChildren().get(2).layoutXProperty().bind(heros.XProperty());
		pane.getChildren().get(2).layoutYProperty().bind(heros.YProperty());
		
		pane.getChildren().get(3).layoutXProperty().bind(this.jeu.getEnnemi().XProperty());
		pane.getChildren().get(3).layoutYProperty().bind(this.jeu.getEnnemi().YProperty());
		
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
					if(heros.getPointsVie() == 0){
						System.out.println("Vous êtes mort");
						getGameLoop().stop();
					}
					else {
						this.jeu.getEnnemi().droite();
						this.jeu.getEnnemi().gauche();
					}
				})
				);
		getGameLoop().getKeyFrames().add(kf);
		
	}
	
	public Timeline getGameLoop() {
		return gameLoop;
	}

	public void setGameLoop(Timeline gameLoop) {
		this.gameLoop = gameLoop;
	}
	
	public Jeu getJeu() {
		return jeu;
	}

	public JeanMichel getJeanMichel() {
		return this.heros;
	}
}

