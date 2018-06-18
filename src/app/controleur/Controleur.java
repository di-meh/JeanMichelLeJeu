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
	private VueItem vueItem;
	private VuePersonnage vueJeanMichel;
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
	private ImageView coeur0;

	@FXML
	private ImageView coeur1;

	@FXML
	private ImageView coeur2;

	@FXML
	private ImageView coeur3;

	@FXML
	private ImageView coeur4;

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
		this.vueItem = new VueCoeur((Coeur)this.jeu.getListeItems().get(0));
		this.vueJeanMichel = new VueJeanMichel(this.jeu.getJeanMichel());
		
		//Ajout des élements dans le Scene Builder
		this.tilemap.getChildren().add(this.vueMap.getTileMap());
		this.pane.getChildren().add(this.vueMap.getTileMapObs());

		//affichage des persos
		this.pane.getChildren().add(vueItem.getSprite());
		this.pane.getChildren().add(vueJeanMichel.getSprite());
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
					if (this.jeu.getJeanMichel().recupererItem() && this.jeu.getJeanMichel().getPointsVie() != 5) {
						this.pane.getChildren().remove(vueItem.getSprite());
						this.getJeanMichel().pointsVieProperty().set(this.getJeanMichel().getPointsVie() + 1);
						if (this.getJeanMichel().getPointsVie() > 5) this.getJeanMichel().pointsVieProperty().set(5);
					}
					if(this.jeu.getJeanMichel().getPointsVie() == 0){
						System.out.println("Vous êtes mort");
						this.coeur0.setImage(new Image("file:./src/app/img/heartempty.png"));
						this.pane.getChildren().remove(vueJeanMichel.getSprite());
						this.dialog.setContentText("GAME OVER");
						this.dialog.setPrefWidth(110);
						this.dialog.setPrefHeight(20);
						this.dialog.setLayoutY(510/2 - dialog.getPrefHeight()/2);
						this.dialog.setLayoutX(510/2 - dialog.getPrefWidth()/2);
						this.dialog.setOpacity(.75);
						this.dialog.setVisible(true);
						getGameLoop().stop();

					}
					else
						this.jeu.update();
					if (Jeu.ennemiRetire != null) {
						this.pane.getChildren().remove(EnnemiVue.get(Jeu.ennemiRetire).getSprite());
						Jeu.ennemiRetire = null;
						if(jeu.getEnnemis().size() == 2) {					  
							this.dialog.setContentText("Bravo, tu as tue\nton premier ennemi");
							this.dialog.setPrefWidth(170);
							this.dialog.setPrefHeight(72);
							this.dialog.setLayoutY(400);
							this.dialog.setLayoutX(500 - dialog.getPrefWidth());
							this.dialog.setOpacity(.59);
							this.dialog.setVisible(true);
						}else
							dialog.setVisible(false);
					}
					if (this.jeu.getEnnemis().size() == 0) {
						this.dialog.setContentText("Bravo, tu as tue\ntous les ennemis");
						this.dialog.setPrefHeight(72);
						this.dialog.setVisible(true);
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

	public JeanMichel getJeanMichel() {
		return this.jeu.getJeanMichel();
	}

	public void verifVie() {
		int vieJM = this.jeu.getJeanMichel().getPointsVie();
		
		if (vieJM >= 5)
			this.coeur4.setImage(coeur0.getImage());
		else
			this.coeur4.setImage(new Image("file:./src/app/img/heartempty.png"));
		
		if (vieJM >= 4)
			this.coeur3.setImage(coeur0.getImage());
		else
			this.coeur3.setImage(new Image("file:./src/app/img/heartempty.png"));
		
		if (vieJM >= 3)
			this.coeur2.setImage(coeur0.getImage());
		else
			this.coeur2.setImage(new Image("file:./src/app/img/heartempty.png"));
		
		if (vieJM >= 2)
			this.coeur1.setImage(coeur0.getImage());
		else
			this.coeur1.setImage(new Image("file:./src/app/img/heartempty.png"));
		
		if (vieJM >= 1)
			this.coeur0.setImage(coeur0.getImage());
	}

}

