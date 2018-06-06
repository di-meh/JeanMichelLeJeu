package app.modele;

import java.util.ArrayList;

public class GestionCollision {

	private Terrain terrain;

	private ArrayList<Integer> obstacles, obstacles_mov;

	public GestionCollision() {
		this.obstacles = new ArrayList<Integer>();
		this.obstacles_mov = new ArrayList<Integer>();
		this.terrain = new Terrain();
		
		// Les commentaires dessous sont un test d'ajout des obstacles directement dans l'arraylist au lieu de les ajouter à la main
		// Cependant un "problème" à soulever, est qu'il crée des doublons, mais dans le cas de notre utilisation, cela importe peu
		int[][] tabObs = this.terrain.initMap(this.terrain.getUrlObs());
		int [][] tabMov = this.terrain.initMap(this.terrain.getUrlMov());

		for (int x = 0; x< tabObs.length; x++) {
			for (int y = 0; y<tabObs[x].length; y++) {
				if (tabObs[x][y] !=0) 
					this.obstacles.add(tabObs[x][y]);
			}
			
		}

		for (int x = 0; x<tabMov.length; x++) {
			for (int y = 0; y<tabMov[x].length; y++) {
				if (tabMov[x][y] != 0)
					this.obstacles_mov.add(tabMov[x][y]);
			}
		}
	}

	public boolean collisionne(int x, int y) {
		if(x<0 || y<0)
			return true;
		return estObstacle(caseDe(x, y));
	}

	public int caseDe(int x, int y) {
		try {
			int cas = this.terrain.getTab2dObs()[y/16][x/16];
			if (cas == 0)
				cas = this.terrain.getTab2dObsMov()[y/16][x/16];
			return cas;
			
		} catch(Exception e) {
			return this.obstacles.get(0);
		}
		
	}

	public boolean estObstacle(int i) {
		for(int o : obstacles)
			if(i == o)
				return true;
		for (int o : obstacles_mov)
			if (i == o) {
				return true;
			}
				
		return false;
	}

	public boolean collisionPerso(Personnage p, Personnage p1, int d, int pas) {
		switch(d) {
		case 0: return verifie(p, p1, 0, -pas);
		case 1: return verifie(p, p1, -pas, 0);
		case 2: return verifie(p, p1, 0, pas);
		case 3: return verifie(p, p1, pas, 0);
		}
		return false;
	}

	public boolean verifie(Personnage p, Personnage p1, int x, int y) {
		
		if(pointdansCarre(p, p1.getX() + x, p1.getY() + y)
		|| pointdansCarre(p, p1.getX() + x + p.getTailleX(), p1.getY() + y)
		|| pointdansCarre(p, p1.getX() + x, p1.getY() + y + p1.getTailleY())
		|| pointdansCarre(p, p1.getX() + x + p1.getTailleX(), p1.getY() + y + p1.getTailleY()))
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
