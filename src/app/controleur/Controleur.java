package app.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import app.modele.Jeu;
import app.modele.Terrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable{

	private Jeu jeu;
	private Terrain map;

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
		
		//TODO new PersoPinc
		// new PersoPrincVue(...)
		
		this.map = new Terrain();
		//TODO faire un new terrainVue(this.terrain) et c'est terrainVue qui construit les images.
		
		
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
		
		this.pane.getChildren().add(new ImageView(new Image("./app/img/Female_Sprite_face2.png")));
		this.pane.getChildren().add(new ImageView(new Image("./app/img/Female_Sprite_face2.png")));
		pane.getChildren().get(1).setLayoutX(84);
		pane.getChildren().get(1).setLayoutY(84);
	}



	public Jeu getJeu() {
		return jeu;
	}


	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	
	public void gererfleche(KeyEvent e) {
		
		KeyCode value = e.getCode();
		switch (value) {
		case Z : pane.getChildren().get(1).setLayoutY(pane.getChildren().get(1).getLayoutY()-5);
			//TODO appeler une méthode sur le personnage qui déplace le y
			break;
		case Q : pane.getChildren().get(1).setLayoutX(pane.getChildren().get(1).getLayoutX()-5);
			break;
		case S : pane.getChildren().get(1).setLayoutY(pane.getChildren().get(1).getLayoutY()+5);
			break;
		case D : pane.getChildren().get(1).setLayoutX(pane.getChildren().get(1).getLayoutX()+5);
			break;
		default:
			break;
		}
	}

	

}

