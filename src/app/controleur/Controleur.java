package app.controleur;

import app.modele.Jeu;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;


public class Controleur {
	
	//TODO Copier information de fichier XMLforFXML.java afin d'extraire les informations à partir d'un fichier xml

    @FXML
    private TilePane map;
    
    public Controleur() {
    	Jeu jeu = new Jeu();
    }

}

