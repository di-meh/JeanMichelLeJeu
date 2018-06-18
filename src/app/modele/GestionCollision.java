package app.modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GestionCollision {

	private Terrain terrain;

	private ArrayList<Integer> obstacles;

	public GestionCollision() {
		this.terrain = new Terrain();
		
		int[][] tabObs = this.terrain.initMap(this.terrain.getUrlObs());

		this.obstacles = remplissageTableau(tabObs);
	}
	
	private ArrayList<Integer> remplissageTableau(int [][] tab) {
		ArrayList<Integer> liste = new ArrayList<>();

		for (int x = 0 ; x < tab.length; x++) {
			for (int y = 0; y < tab[x].length; y++) {
				if (tab[x][y] != 0)
					liste.add(tab[x][y]);
			}
		}
		Set<Integer> pivot = new HashSet<>();
		pivot.addAll(liste);
		liste.clear();
		liste.addAll(pivot);
		return liste;
	}

	public boolean collisionneObstacle(int x, int y) {
		if (x < 0 || y < 0) return true;
		return estObstacle(caseDe(x, y));
	}


	private int caseDe(int x, int y) {
		try {
			return this.terrain.getTab2dObs()[y/16][x/16];

		} catch(Exception e) {
			return this.obstacles.get(0);
		}
	}

	private boolean estObstacle(int i) {
		for(int o : obstacles)
			if(i == o)
				return true;
		return false;
	}

	public boolean collisionnePerso(Personnage p, Personnage p1, int d, int pas) {
		switch(d) {
		case 0: return verifie(p, p1, 0, -pas);
		case 1: return verifie(p, p1, -pas, 0);
		case 2: return verifie(p, p1, 0, pas);
		case 3: return verifie(p, p1, pas, 0);
		}
		return false;
	}

	private boolean verifie(Personnage p, Personnage p1, int x, int y) {
		if(p == null || p1 == null) return false;
		if(pointdansCarre(p, p1.getX() + x, p1.getY() + y)
		|| pointdansCarre(p, p1.getX() + x + p.getTailleX(), p1.getY() + y)
		|| pointdansCarre(p, p1.getX() + x, p1.getY() + y + p.getTailleY())
		|| pointdansCarre(p, p1.getX() + x + p.getTailleX(), p1.getY() + y + p.getTailleY()))
			return true;
		return false;
	}

	private boolean pointdansCarre(Personnage p, int x, int y) {
		if(x >= p.getX() && x <= p.getX() + p.getTailleX() && y >= p.getY() && y <= p.getY() + p.getTailleY()
		|| x >= p.getX() && x <= p.getX() + p.getTailleX() && y >= p.getY() && y <= p.getY() + p.getTailleY())
			return true;
		return false;
	}
}
