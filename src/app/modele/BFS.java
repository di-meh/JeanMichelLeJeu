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
	}
	
	public void algorithme() {
		
		this.queue.clear();
		
		while(!this.tiles.isEmpty()) {
			this.queue.poll();
			//ajouterVoisinsMap();
			for(Map.Entry<Tile, Tile> t : tiles.entrySet()) {
				if(!this.tiles.containsKey(t))
					this.queue.add((Tile) t);
			}
		}
	}
	
	public void ajouterVoisinsMap(Tile t) {
		//verif voisin haut
		//verif voisin bas
		//verif voisin gauche
		//verif voisin droite
	}
	
	public void verifVoisin(int x, int y) {
		
	}
	
	/*public Tile positionToTile(int x, int y) {
	 * 
	 *prend en parametre des coordonnees et renvoie la tile a laquelle ils correspondent
	 *
		return null;
		
	}*/
	
}
