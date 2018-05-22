package app.vue;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class VueJeanMichel {
	
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
