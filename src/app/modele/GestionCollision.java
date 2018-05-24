package app.modele;

import java.util.ArrayList;

public class GestionCollision {

	private Terrain terrain;
	
	private int[][] tabBasique;
	
	private ArrayList<Integer> obstacles;
	
	private JeanMichel jeanMichel;
	
	public GestionCollision() {
		this.obstacles = new ArrayList<Integer>();
		this.terrain = new Terrain();
		this.tabBasique = this.terrain.getBasique();
		this.jeanMichel = new JeanMichel(null, 0, 0);
	}
	
	public boolean collisione() {
		if(estObstacle(caseDe()))
			return true;
		return false;
	}
	
	public int caseDe() {
		return this.tabBasique[this.jeanMichel.getX()%16][this.jeanMichel.getY()%16];
	}
	
	public boolean estObstacle(int i) {
		for(int o : obstacles) {
			if(i == o)
				return true;
		}
		return false;
	}
	
}
