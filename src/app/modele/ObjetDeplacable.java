package app.modele;

import java.util.ArrayList;

public class ObjetDeplacable {
	
	private int id;
	
	private int x, y;

	private int Ox, Oy;
	
	private ArrayList<ObjetDeplacable> objetsdeplacables;

	public ObjetDeplacable(int id,int x, int y, int Ox, int Oy) { //TODO gérér l'orientation et les ArrayList pour les obstacles
		this.id = id;
		this.x = x;
		this.y = y;
		this.Ox = Ox;
		this.Oy = Oy;
		objetsdeplacables = new ArrayList<>();
	}
	
	public int getID() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getOX() {
		return Ox;
	}
	public int getOY() {
		return Oy;
	}
	public ArrayList<ObjetDeplacable> getListe() {
		return objetsdeplacables;
	}
}
