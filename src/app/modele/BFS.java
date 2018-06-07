package app.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	private Terrain terrain;
	
	private HashMap<Tile, Tile> tiles;
	
	private Queue<Tile> file;
	
	private ArrayList<Tile> tilesMarquees;
	
	public BFS() {
		
		this.terrain = new Terrain();
		this.file = new LinkedList<Tile>();
		this.tiles = new HashMap<Tile, Tile>();
		this.tilesMarquees = new ArrayList<Tile>();
		
	}

	public void lancerBFS(JeanMichel jm) {
		
		Tile sommetZero = new Tile(jm.getX(), jm.getY());
		this.tiles.put(sommetZero, null);
		this.file.add(sommetZero);
		
		while(!this.file.isEmpty()) {
			
			System.out.println("tile 0 :" + this.file.peek().toString());
			
			this.tilesMarquees.add(this.file.peek());
			sommetsAdjacents(this.file.poll());
		}
	}
	
	private void sommetsAdjacents(Tile t) {
		
		
		// sommet du haut
		Tile t2 = new Tile(t.getX(), t.getY() + 1);
		ajouterTile(t, t2);
		
		// sommet du bas
		Tile t3 = new Tile(t.getX(), t.getY() - 1);
		ajouterTile(t, t3);
		
		// sommet de gauche
		Tile t4 = new Tile(t.getX() - 1, t.getY() + 1);
		ajouterTile(t, t4);
		
		// sommet de droite
		Tile t5 = new Tile(t.getX() + 1, t.getY());
		ajouterTile(t, t5);
	
	}
	
	private void ajouterTile(Tile t, Tile t2) {
		if(!estObstacle(t2)) {
			if(!estMarque(t2))
				this.file.add(t2);
			this.tiles.put(t2, t);
		}
	}
	
	private boolean estObstacle(Tile t) {
		if(t.getX() < 0 || t.getX() >= 32
		|| t.getY() < 0 || t.getY() >= 32)
			return true;
		return this.terrain.getTab2dObs()[t.getY()][t.getX()] != 0;
	}
	
	private boolean estMarque(Tile t) {
		for(Tile tm : this.tilesMarquees) {
			if(tm.equals(t))
				return true;
		}
		return false;
	}
	
	public int deplacementEnnemi(Ennemi e) {
		Tile te = new Tile(e.getX(), e.getTailleY());
		
		int x = te.getX() - this.tiles.get(te).getX();
		int y = te.getY() - this.tiles.get(te).getY();
		
		if(x == 0 && y == 0)
			return 0;
		if(x == 0 && y == 1)
			return 1;
		if(x == 1 && y == 0)
			return 2;
		if(x == 1 && y == 1)
			return 3;
		return 2;
	}
	
}









/*@SuppressWarnings("unlikely-arg-type")
	public void algorithme() {
		
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




