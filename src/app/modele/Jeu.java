package app.modele;

public class Jeu {

	private Terrain map;

	public Jeu(Terrain m) {
		//TODO Faire la classe Jeu, qui contiendra la gameloop et les différents objectifs 
		this.map = m;
	}

	public Terrain getMap() {
		return this.map;
	}

}