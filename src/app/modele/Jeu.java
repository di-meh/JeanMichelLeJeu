package app.modele;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Jeu {


	private JeanMichel heros;
	private Timeline gameLoop;

	private Terrain map;

	public Jeu(Terrain m) {
		this.map = m;
		heros = new JeanMichel(null, 0, 0);
		init();
		getGameLoop().play();
	}

	public Terrain getMap() {
		return this.map;
	}

	public void init() {
		setGameLoop(new Timeline());
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.018), //environ 60 FPS
				// on définit ce qui se passe à chaque frame 
				(ev ->{
					if(heros.getPointsVie()==0){
						System.out.println("Vous êtes mort");
						gameLoop.stop();
					}
				})
				);
		gameLoop.getKeyFrames().add(kf);
	}

	public Timeline getGameLoop() {
		return gameLoop;
	}

	public void setGameLoop(Timeline gameLoop) {
		this.gameLoop = gameLoop;
	}

	public JeanMichel getHeros() {
		return heros;
	}
	
}