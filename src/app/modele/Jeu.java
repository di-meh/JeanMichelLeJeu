package app.modele;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Jeu {

	private Map map;
	private JeanMichel heros;
	private Timeline gameLoop;

	private int temps;


	public Jeu(Map m) {
		//TODO Faire la classe Jeu, qui contiendra la gameloop et les différents objectifs 
		this.map = m;
		heros = new JeanMichel();
		init();
		getGameLoop().play();
	}

	public Map getMap() {
		return this.map;
	}
	
	public void init() {
		setGameLoop(new Timeline());
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.018), //environ 60 FPS
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(heros.getVie().intValue()==0){
						System.out.println("Vous êtes mort");
						gameLoop.stop();
					}
					else if (temps%5==0){
						System.out.println("un tour");
					}
					temps++;
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
}