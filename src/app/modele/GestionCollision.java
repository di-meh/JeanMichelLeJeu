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
		if(estObstacle(caseDe(x, y)))
			return true;
		return false;
	}
	
	public int caseDe(int x, int y) {
		return this.terrain.getTab2d()[x/16][y/16];
	}
	
	public boolean estObstacle(int i) {
		for(int o : obstacles) {
			if(i == o)
				return true;
		}
		return false;
	}
	
}
