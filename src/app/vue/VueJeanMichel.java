package app.vue;

import app.modele.JeanMichel;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
//import java.util.ArrayList;

public class VueJeanMichel {

	private JeanMichel heros;

	private Image sprite = new Image("./app/img/Female_Sprite_face2.png");
	//private ArrayList<Integer> obstacles;

	//private SimpleIntegerProperty positionX, positionY;

	public VueJeanMichel(JeanMichel heros) {
		this.heros = heros;
		//this.obstacles = new ArrayList<Integer>();

	}

	public void deplacement(KeyEvent e) {
		KeyCode value = e.getCode();

		switch(value) {
		case Z: this.heros.haut(); 
		break;
		case Q: this.heros.gauche();
		break;
		case S: this.heros.bas();
		break;
		case D: this.heros.droite();
		break;
		default:
			break;
		}
	}

	public String getImage() {
		return "./app/img/Female_Sprite_face2.png";
	}


	public Image getSprite() {
		return sprite;
	}

	//	public boolean collision(int x, int y) {
	//		
	//		/*if() {
	//			return true;
	//		}*/
	//		//TODO faire la lite qui contient les id des images a obstacles
	//		return false;
	//	}


}

