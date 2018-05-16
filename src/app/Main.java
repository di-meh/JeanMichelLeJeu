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
		
		//test ennemi
		Ennemi e2 = new Ennemi1("ennemiBase", "/truc/tructruc");
		Ennemi e3 = new Ennemi2("ennemiBase", "/truc/tructruc");
		Ennemi e4 = new Ennemi3("ennemiBase", "/truc/tructruc");
		Ennemi e5 = new Ennemi4("ennemiBase", "/truc/tructruc");
		
		//test pnj
		PNJ p1 = new PNJArme(5, 3);
		PNJ p2 = new PNJItem(5, 3);
		PNJ p3 = new PNJVie(5, 3);

		try {

			
			FXMLLoader loader = new FXMLLoader();
			URL url = new File("src/app/vue/Map.fxml").toURI().toURL();
			loader.setLocation(url);
			System.out.println(loader.getLocation());

			Pane root = loader.load();	
			TilePane jeu = new TilePane();

			Image img = new Image("./app/img/tile_herbe.jpg");
			ImageView iv = new ImageView();
			iv.setImage(img);
			iv.setFitWidth(16);
			iv.setPreserveRatio(true);
			jeu.getChildren().add(iv);
			root.getChildren().add(jeu);
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
