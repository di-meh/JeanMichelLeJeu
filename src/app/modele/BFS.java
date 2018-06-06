package app.modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private Tile sommetZero;
	
	private Terrain terrain;
	
	private HashMap<Tile, Tile> tiles;
	
	private Queue<Tile> file;
	
	public BFS(JeanMichel jm) {
		
		this.terrain = new Terrain();
		this.file = new LinkedList<Tile>();
		this.sommetZero = new Tile(jm.getX()/16, jm.getY()/16);
		this.tiles = new HashMap<Tile, Tile>();
		
		this.tiles.put(sommetZero, null);
		this.file.add(sommetZero);
		
		while(!this.file.isEmpty()) {
			this.file.peek().setEstMarque();
			sommetsAdjacents(this.file.poll());
		}
	}

	private void sommetsAdjacents(Tile t) {
		
		// sommet du haut
		if(!estObstacle(new Tile(t.getX(), t.getY() + 1))) {
			if(t.getEstMarque())
				this.file.add(new Tile(t.getX(), t.getY() + 1));
			this.tiles.put(t, new Tile(t.getX(), t.getY() + 1));
		}
		
		// sommet du bas
		if(!estObstacle(new Tile(t.getX(), t.getY() - 1))) {
			if(t.getEstMarque())
				this.file.add(new Tile(t.getX(), t.getY() - 1));
			this.tiles.put(t, new Tile(t.getX(), t.getY() - 1));
		}
		
		// sommet de gauche
		if(!estObstacle(new Tile(t.getX() - 1, t.getY() + 1))) {
			if(t.getEstMarque())
				this.file.add(new Tile(t.getX() - 1, t.getY() + 1));
			this.tiles.put(t, new Tile(t.getX() - 1, t.getY() + 1));
		}
		
		// sommet de droite
		if(!estObstacle(new Tile(t.getX() + 1, t.getY()))) {
			if(t.getEstMarque())
				this.file.add(new Tile(t.getX() + 1, t.getY()));
			this.tiles.put(t, new Tile(t.getX() + 1, t.getY()));
		}
	}
	
	private boolean estObstacle(Tile t) {
		
		for(int x = 0; x < this.terrain.getTab2dObs().length; x++) {
			for(int y = 0; y < this.terrain.getTab2dObs()[x].length; y++) {
				if(t.getX() == x && t.getY() == y)
					return true;	
			}
		}
		return false;
	}
	
	public void demarque() {
		
	}

	public void marque() {
		
	}
	
}









/*@SuppressWarnings("unlikely-arg-type")
	public void algorithme() {
		
		this.queue.clear();
		
		while(!this.queue.isEmpty()) {
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
	
	public Tile positionToTile(int x, int y) {
	 	prend en parametre des coordonnees et renvoie la tile a laquelle ils correspondent
		
		return new Tile(x ,y);
		
	}*/




