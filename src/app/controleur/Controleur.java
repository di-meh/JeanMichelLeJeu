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
import javafx.scene.image.Image;
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


	private Image imagetest;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		String nomImage;

		this.tilemap.setPrefColumns(12);
		this.tilemap.setPrefRows(12);
		this.map = new Terrain();
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
		this.pane.getChildren().add(new ImageView(new Image("./app/modele/Essaianim.png")));

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

