package app.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
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
		this.tiles.put(sommetZero, new Tile(0, 0));
		this.file.add(sommetZero);
		this.tilesMarquees.add(sommetZero);
		
		while(!this.file.isEmpty()) {
			
			/*System.out.println(" x = " + this.file.peek().getX() + " y = " + this.file.peek().getY());
			System.out.println(this.tiles.toString());*/
			
			//affichage();
			sommetsAdjacents(this.file.poll());
		}
		this.tilesMarquees.clear();
	}
	
	public void affichage() {
		for(Entry<Tile, Tile> entry : this.tiles.entrySet()){
			Tile cle = entry.getKey();
			Tile valeur = entry.getValue();
			System.out.println("x = " + cle.getX() + " y = " + cle.getY() + " -> x = " + valeur.getX() + " y = " + valeur.getY()); //affichage console
		}
	}
	
	private void sommetsAdjacents(Tile t) {
		
		// sommet du haut
		Tile th = new Tile(t.getX(), t.getY() + 1, "bla");
		ajouterTile(t, th);
		 
		// sommet du bas
		Tile tb = new Tile(t.getX(), t.getY() - 1, "bla");
		ajouterTile(t, tb);
		
		// sommet de gauche
		Tile tg = new Tile(t.getX() - 1, t.getY(), "bla");
		ajouterTile(t, tg);
		
		// sommet de droite		System.out.println(this.tiles.get(positionEnnemi).toString());
		Tile td = new Tile(t.getX() + 1, t.getY(), "bla");
		ajouterTile(t, td);
	
	}
	
	private void ajouterTile(Tile t, Tile t2) {
		if(!estObstacle(t2) && !estMarque(t2)) {
			this.file.add(t2);
			this.tiles.put(t2, t);
			this.tilesMarquees.add(t2);
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
	
	public int deplacementEnnemi(int x, int y) {
		Tile positionEnnemi = new Tile(x, y);
		
		int nx = positionEnnemi.getX() - this.tiles.get(positionEnnemi).getX();
		int ny = positionEnnemi.getY() - this.tiles.get(positionEnnemi).getY();
		

		if(nx == 0 && ny == 1)
			return 0;
		if(nx == 0 && ny == -1)
			return 1;
		if(nx == 1 && ny == 0)
			return 2;
		if(nx == -1 && ny == 0)
			return 3;
		return 5;
		
	}
	
}




