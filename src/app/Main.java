package app;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setTitle("Jean-Michel");
			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/app/vue/Map.fxml").toURI().toURL();
			loader.setLocation(url);
//			System.out.println(loader.getLocation());
			Pane root = loader.load();	
			Scene scene = new Scene(root, root.getPrefHeight(),root.getPrefWidth());
			primaryStage.setScene(scene);
			primaryStage.show();

			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
