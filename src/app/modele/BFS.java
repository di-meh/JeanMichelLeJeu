package app.modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS {

	private Tile sommetZero;
	
	private Terrain terrain;
	
	private HashMap<Tile, Tile> tiles;
	
	private Queue<Tile> queue;
	
	public BFS(JeanMichel jm) {
		
		this.terrain = new Terrain();
		this.queue = new LinkedList<Tile>();
		this.sommetZero = new Tile(jm.getX()/16, jm.getY()/16);
		this.tiles = new HashMap<Tile, Tile>();
		
		this.tiles.put(sommetZero, null);
		this.queue.add(sommetZero);
		
		algorithme();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void algorithme() {
		
		this.queue.clear();
		
		while(!this.tiles.isEmpty()) {
			ajouterVoisinsMap(this.queue.peek());
			this.queue.poll();
			for(Map.Entry<Tile, Tile> t : tiles.entrySet()) {
				if(!this.tiles.containsKey(t))
					this.queue.add((Tile) t);
			}
		}
	}
	
	public void ajouterVoisinsMap(Tile t) {
		
		if(verifVoisin(t.getX(), t.getY() + 1)) { //verif voisin haut
			this.tiles.put(new Tile(t.getX(), t.getY() + 1), t);
		}
		
		if(verifVoisin(t.getX(), t.getY() - 1)) { //verif voisin bas
			this.tiles.put(new Tile(t.getX(), t.getY() - 1), t);
		}
		
		if(verifVoisin(t.getX() + 1, t.getY())) { //verif voisin droite
			this.tiles.put(new Tile(t.getX() + 1, t.getY()), t);
		}
		
		if(verifVoisin(t.getX() - 1, t.getY())) { //verif voisin gauche
			this.tiles.put(new Tile(t.getX() - 1, t.getY() + 1), t);
		}
	}
	
	public boolean verifVoisin(int x, int y) {
		for(int i = 0; i < this.terrain.getTab2dObs().length; i++){
			for(int j = 0; j < this.terrain.getTab2dObs()[i].length; j++) {
				
				if(i == x && j == y) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*public Tile positionToTile(int x, int y) {
	 	prend en parametre des coordonnees et renvoie la tile a laquelle ils correspondent
		
		return new Tile(x ,y);
		
	}*/
	
}
