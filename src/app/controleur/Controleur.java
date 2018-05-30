package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import app.modele.JeanMichel;
import app.modele.Jeu;
import app.modele.Terrain;
import app.vue.VueEnnemi;
import app.vue.VueJeanMichel;
import app.vue.VuePNJ;
import app.vue.VueTerrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
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
	private VuePNJ vuePNJ;
	
	private Timeline gameLoop;

	//FXML
	@FXML
	private BorderPane borderpane;

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
		this.vuePNJ = new VuePNJ(this.jeu.getPNJ());
		this.vueHeros = new VueJeanMichel(this.jeu.getJeanMichel());

		//Ajout des élements dans le Scene Builder
		this.pane.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(this.vueMap.getTileMapObs());
		
		this.pane.getChildren().add(new ImageView(vueHeros.getSprite()));
		this.pane.getChildren().add(new ImageView(vueEnnemi.getSprite()));
		this.pane.getChildren().add(new ImageView(vuePNJ.getSprite()));
		//Bind la position du sprite à la position du héros


		pane.getChildren().get(3).layoutXProperty().bind(this.jeu.getJeanMichel().XProperty());
		pane.getChildren().get(3).layoutYProperty().bind(this.jeu.getJeanMichel().YProperty());

		pane.getChildren().get(4).layoutXProperty().bind(this.jeu.getEnnemi().XProperty());
		pane.getChildren().get(4).layoutYProperty().bind(this.jeu.getEnnemi().YProperty());
		
		pane.getChildren().get(5).layoutXProperty().bind(this.jeu.getPNJ().XProperty());
		pane.getChildren().get(5).layoutYProperty().bind(this.jeu.getPNJ().YProperty());

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
					if(this.jeu.getJeanMichel().getPointsVie() == 0){
						System.out.println("Vous êtes mort");
						getGameLoop().stop();
					}
					else {
						this.jeu.update();
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
		return this.jeu.getJeanMichel();
	}
}

