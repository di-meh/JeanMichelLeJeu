package app;

import java.io.File;
import java.net.URL;

import app.modele.Perso;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainTest extends Application{
	
	public static void main(String[] args) {
		Perso p = new Perso();
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
			Scene scene = new Scene(root, 192, 192);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
