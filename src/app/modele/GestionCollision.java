package app.modele;

import java.util.ArrayList;

public class GestionCollision {

	private Terrain terrain;
	
	
	private ArrayList<Integer> obstacles;
	
	
	public GestionCollision() {
		this.obstacles = new ArrayList<Integer>();
		this.obstacles.add(197);
		this.terrain = new Terrain();
	}
	
	public boolean collisionne(int x, int y) {
		return estObstacle(caseDe(x, y));
	}
	
	public int caseDe(int x, int y) {
		try {
			return this.terrain.getTab2d()[y/16][x/16];
		} catch (Exception e) {
			//Ceci sert à arrêter le joueur lorsqu'il atteint le bord de la map
		}
		return obstacles.get(0); //test de collision sur le côté
		
	}
	
	public boolean estObstacle(int i) {
		for(int o : obstacles) {
			if(i == o)
				return true;
		}
		return false;
	}
	
}
