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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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


	private Timeline gameLoop;

	//FXML
	@FXML
	private BorderPane borderpane;

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilemap;

	@FXML
	private GridPane grid;

	@FXML
	private ImageView heart0;

	@FXML
	private ImageView heart1;

	@FXML
	private ImageView heart2;

	@FXML
	private ImageView heart3;

	@FXML
	private ImageView heart4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.map = new Terrain();
		this.jeu = new Jeu();

		this.jeu.getJeanMichel().setJeu(this.jeu);
		this.jeu.getEnnemis().get(0).setJeu(this.jeu);

		this.vueEnnemi = new VueEnnemi(this.jeu.getEnnemis().get(0));
		this.vueMap = new VueTerrain(this.map);
		this.vueHeros = new VueJeanMichel(this.jeu.getJeanMichel());

		//Ajout des élements dans le Scene Builder
		this.pane.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(this.vueMap.getTileMapObs());
		this.pane.getChildren().add(this.vueMap.getTileMapMov());

		//affichage des persos
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
					if(this.jeu.getJeanMichel().getPointsVie() == 0){
						System.out.println("Vous êtes mort");
						heart0.setImage(new Image("file:./src/app/img/heartempty.png"));
						this.pane.getChildren().remove(4);
						getGameLoop().stop();
						
					}
					else {
						this.jeu.update();
						if (Jeu.ennemiRetiré) {
							pane.getChildren().remove(5);
							Jeu.ennemiRetiré=false;
						}
						verifVie();
						
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
	public void verifVie() {
		int vieJM = jeu.getJeanMichel().getPointsVie();
		if (vieJM/2 == 5) {
			heart4.setImage(heart0.getImage());
		}else {
			heart4.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM/2 >= 4) {
			heart3.setImage(heart0.getImage());
		}else {
			heart3.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM/2 >= 3) {
			heart2.setImage(heart0.getImage());
		}else {
			heart2.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM/2 >= 2) {
			heart1.setImage(heart0.getImage());
		}else {
			heart1.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM/2 >= 1) {
			heart0.setImage(heart0.getImage());
		}
	}
	
}

