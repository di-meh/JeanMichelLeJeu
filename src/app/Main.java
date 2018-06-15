package app;

import java.io.File;
import java.net.URL;
import app.controleur.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			System.out.println("Voici les touches: \nZ: Haut\nQ: Gauche\nS: Bas\nD: Droite\nE: Attaquer");
			primaryStage.setTitle("Jean-Michel : le jeu");

			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/app/vue/Map.fxml").toURI().toURL();
			loader.setLocation(url);
			BorderPane root = loader.load();	
			Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
			Controleur c = loader.getController();
			scene.setOnKeyPressed(e-> c.getJeanMichel().action(e));
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}