package app;

import java.io.File;
import java.net.URL;

import app.modele.Ennemi;
import app.modele.Ennemi1;
import app.modele.Ennemi2;
import app.modele.Ennemi3;
import app.modele.Ennemi4;
import app.modele.PNJ;
import app.modele.PNJArme;
import app.modele.PNJItem;
import app.modele.PNJVie;
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

			
			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/app/vue/Map.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());

			Pane root = loader.load();	
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
