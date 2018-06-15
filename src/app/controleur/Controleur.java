package app.controleur;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import app.modele.Cactus;
import app.modele.Coeur;
import app.modele.Ennemi;
import app.modele.JeanMichel;
import app.modele.Jeu;
import app.modele.Tentacule;
import app.modele.Terrain;
import app.vue.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DialogPane;
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
<<<<<<< HEAD
	private VuePersonnage vueJeanMichel;
	private VueItem vueItem;
=======

	private VueItem vueItem;
	
	private VuePersonnage vueHeros;

>>>>>>> 84344544a5277110466a928ec2636a73edf3638f
	private HashMap<Ennemi, VuePersonnage> EnnemiVue;

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

	@FXML
	private DialogPane dialog;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.EnnemiVue = new HashMap<>();
		this.map = new Terrain();
		this.jeu = new Jeu();
		this.dialog = new DialogPane();
		this.jeu.getJeanMichel().setJeu(this.jeu);
		jeu.getJeanMichel().pointsVieProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				verifVie();
			}
		});
		
		this.vueMap = new VueTerrain(this.map);
<<<<<<< HEAD
		this.vueJeanMichel = new VueJeanMichel(this.jeu.getJeanMichel());
		this.vueItem = new VueCoeur((Coeur)this.jeu.getListeItems().get(0));

=======
		this.vueItem = new VueCoeur((Coeur)this.jeu.getListeItems().get(0));
		this.vueHeros = new VueJeanMichel(this.jeu.getJeanMichel());
>>>>>>> 84344544a5277110466a928ec2636a73edf3638f
		//Ajout des élements dans le Scene Builder

		this.tilemap.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(this.vueMap.getTileMapObs());
		this.pane.getChildren().add(this.vueMap.getTileMapMov());

		//affichage des persos
<<<<<<< HEAD

		this.pane.getChildren().add(vueItem.getSprite());
		this.pane.getChildren().add(vueJeanMichel.getSprite());

=======
		this.pane.getChildren().add(vueItem.getSprite());
		this.pane.getChildren().add(vueHeros.getSprite());
>>>>>>> 84344544a5277110466a928ec2636a73edf3638f
		for (Ennemi en : jeu.getEnnemis()) {
			en.setJeu(jeu);
			if(en instanceof Cactus)
				EnnemiVue.put(en, new VueCactus(en));
			else if(en instanceof Tentacule)
				EnnemiVue.put(en, new VueTentacule(en));
			this.pane.getChildren().add(EnnemiVue.get(en).getSprite());
		}

		pane.getChildren().add(dialog);
		dialog.setVisible(false);
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

					if (jeu.collisionObjet() && this.jeu.getJeanMichel().getPointsVie()!=5) {
						//TODO le faire dans le modèle
						this.pane.getChildren().remove(vueItem.getSprite());
						this.getJeanMichel().pointsVieProperty().set(this.getJeanMichel().getPointsVie()+1);
						if (this.getJeanMichel().getPointsVie() > 5) this.getJeanMichel().pointsVieProperty().set(5);
					}
					if(this.jeu.getJeanMichel().getPointsVie() == 0){
						System.out.println("Vous êtes mort");
						heart0.setImage(new Image("file:./src/app/img/heartempty.png"));
<<<<<<< HEAD
						this.pane.getChildren().remove(vueJeanMichel.getSprite());

=======
						this.pane.getChildren().remove(vueHeros.getSprite());
>>>>>>> 84344544a5277110466a928ec2636a73edf3638f
						dialog.setContentText("GAME OVER");
						dialog.setPrefWidth(110);
						dialog.setPrefHeight(20);
						dialog.setLayoutY(510/2 - dialog.getPrefHeight()/2);
						dialog.setLayoutX(510/2 - dialog.getPrefWidth()/2);
						dialog.setOpacity(.75);
						dialog.setVisible(true);
						getGameLoop().stop();

					}
					else
						this.jeu.update();
					if (Jeu.ennemiRetiré != null) {
						pane.getChildren().remove(EnnemiVue.get(Jeu.ennemiRetiré).getSprite());
						Jeu.ennemiRetiré=null;
						if(jeu.getEnnemis().size() == 2) {					  
							dialog.setContentText("Bravo,tu as tué\n"
									+ "ton premier ennemi");
							dialog.setPrefWidth(170);
							dialog.setPrefHeight(72);
							dialog.setLayoutY(400);
							dialog.setLayoutX(500-dialog.getPrefWidth());
							dialog.setOpacity(.59);
							dialog.setVisible(true);
						}else
							dialog.setVisible(false);
					}
					if (jeu.getEnnemis().size()==0) {
						dialog.setContentText("Bravo,t'as tué\n"
								+ "tout les ennemis");
						dialog.setPrefHeight(72);
						dialog.setVisible(true);
					}

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

	public void verifVie() {
		int vieJM = jeu.getJeanMichel().getPointsVie();
		if (vieJM >= 5) {
			heart4.setImage(heart0.getImage());
		}else {
			heart4.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM >= 4) {
			heart3.setImage(heart0.getImage());
		}else {
			heart3.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM >= 3) {
			heart2.setImage(heart0.getImage());
		}else {
			heart2.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM >= 2) {
			heart1.setImage(heart0.getImage());
		}else {
			heart1.setImage(new Image("file:./src/app/img/heartempty.png"));
		}
		if (vieJM >= 1) {
			heart0.setImage(heart0.getImage());
		}
	}

}

