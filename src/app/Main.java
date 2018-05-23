package app;

import java.io.File;
import java.net.URL;
import app.controleur.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setTitle("Jean-Michel : le jeu");

			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/app/vue/Map.fxml").toURI().toURL();
			loader.setLocation(url);
			Pane root = loader.load();
			Controleur c = loader.getController();
			Scene scene = new Scene(root, root.getPrefHeight(),root.getPrefWidth());
			scene.setOnKeyPressed(e-> c.getVueJeanMichel().deplacement(e));
			primaryStage.setScene(scene);
			primaryStage.show();

			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
