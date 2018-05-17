package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import app.modele.Jeu;
import app.modele.Map;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;


public class Controleur implements Initializable {

	private Jeu jeu;
	private Map map;

	private Timeline gameLoop;

	private int temps;

	@FXML
	private Pane pane;

	@FXML
	private TilePane tilemap;

	private Image imagetest;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String nomImage;

		this.tilemap.setPrefColumns(12);
		this.tilemap.setPrefRows(12);
		this.map = new Map();
		this.setJeu(new Jeu(this.map));
		int [][] t2 = this.map.getTab2d();
		for (int x = 0; x< t2.length; x++) {
			for (int y =0; y< t2[x].length; y++) {
				nomImage = this.map.imageDe(t2[x][y]);
				this.imagetest = new Image(nomImage);
				ImageView img = new ImageView();
				img.setImage(imagetest);
				this.tilemap.getChildren().add(img);
			}
		}
		this.pane.getChildren().add(new ImageView(new Image("./app/img/Female_Sprite_face2.png"))); // Image du personnage, à déplacer dans le modèle
		//		init();
		//		gameLoop.play();
	}



	public Jeu getJeu() {
		return jeu;
	}



	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}


	private void init() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(temps==100){
						System.out.println("fini");
						gameLoop.stop();
					}
					else if (temps%5==0){
						System.out.println("un tour");
					}
					temps++;
				})
				);
		gameLoop.getKeyFrames().add(kf);
	}
}

