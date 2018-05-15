package app;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception { //TODO Faire en sorte que la boucle fonctionne et que le modèle soit fonctionnel.

		try {

			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/app/vue/Map.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());

			Pane root = loader.load();	
//			TilePane jeu = new TilePane();
//
//			Image img = new Image("./app/img/tile_herbe.jpg");
//			ImageView iv = new ImageView();
//			iv.setImage(img);
//			iv.setFitWidth(16);
//			iv.setPreserveRatio(true);
//			jeu.getChildren().add(iv);
//			root.getChildren().add(jeu);
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
