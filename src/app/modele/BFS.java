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
		this.tiles.put(sommetZero, new Tile(0, 0));
		this.file.add(sommetZero);
		this.tilesMarquees.add(sommetZero);
		
		while(!this.file.isEmpty()) {
			
			sommetsAdjacents(this.file.poll());
		}
		this.tilesMarquees.clear();
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
		
		// sommet de droite
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
	
	public int deplacementEnnemi(Ennemi e) {
		Tile positionEnnemiHautGauche = new Tile(e.getX(), e.getY());
		
		//haut
		if(positionEnnemiHautGauche.getX() - this.tiles.get(positionEnnemiHautGauche).getX() == 0 
		&& positionEnnemiHautGauche.getY() - this.tiles.get(positionEnnemiHautGauche).getY() == 1)
			return 0;
		
		//bas
		if(positionEnnemiHautGauche.getX() - this.tiles.get(positionEnnemiHautGauche).getX() == 0 
		&& positionEnnemiHautGauche.getY() - this.tiles.get(positionEnnemiHautGauche).getY() == -1)
			return 1;
		
		//gauche
		if(positionEnnemiHautGauche.getX() - this.tiles.get(positionEnnemiHautGauche).getX() == 1 
		&& positionEnnemiHautGauche.getY() - this.tiles.get(positionEnnemiHautGauche).getY() == 0)
			return 2;
		
		//droite
		if(positionEnnemiHautGauche.getX() - this.tiles.get(positionEnnemiHautGauche).getX() == -1 
		&& positionEnnemiHautGauche.getY() - this.tiles.get(positionEnnemiHautGauche).getY() == 0)
			return 3;
		
		return 4;
		
	}
	
}




