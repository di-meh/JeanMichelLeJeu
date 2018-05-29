package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.StringTokenizer;

import app.controleur.Controleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		
		String thisLine = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/app/modele/MapMatrice.txt"));

			while ((thisLine = br.readLine())!= null) {
				System.out.println(thisLine);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {

			primaryStage.setTitle("Jean-Michel : le jeu");

			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/app/vue/Map.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());
			BorderPane root = loader.load();	
			Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
			Controleur c = loader.getController();
			scene.setOnKeyPressed(e-> c.getJeanMichel().deplacement(e));
			primaryStage.setScene(scene);
			primaryStage.show();

			



		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
