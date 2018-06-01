package app.modele;

import java.util.ArrayList;

public class GestionCollision {

	private Terrain terrain;

	private ArrayList<Integer> obstacles;


	public GestionCollision() {
		this.obstacles = new ArrayList<Integer>();
		this.terrain = new Terrain();
		
		// Les commentaires dessous sont un test d'ajout des obstacles directement dans l'arraylist au lieu de les ajouter à la main
		// Cependant un "problème" à soulever, est qu'il crée des doublons, mais dans le cas de notre utilisation, cela importe peu
		int[][] tabObs = this.terrain.initMap("src/app/modele/MapMatriceObs.txt");
		
		for (int x = 0; x < tabObs.length; x++) {
			
			for (int y = 0; y < tabObs[x].length; y++) {
				if (tabObs[x][y] !=0) 
					this.obstacles.add(tabObs[x][y]);
			}
			
		}
	}

	public boolean collisionne(int x, int y) {
		return estObstacle(caseDe(x, y));
	}

	public int caseDe(int x, int y) {
		try {
			return this.terrain.getTab2dObs()[y/16][x/16];
		} catch (Exception e) {
			//Ceci sert à arrêter le joueur lorsqu'il atteint le bord de la map
		}
		return obstacles.get(0); //test de collision sur le côté

	}

	public boolean estObstacle(int i) {
		for(int o : obstacles) {
			if(i == o)
				return true;
		}
		return false;
	}
	
	public boolean collisionPerso(Personnage p, Personnage p1, int d) {
		
		switch(d) {
		case 0: verifie(p, p1, 0, -4);
		case 1: verifie(p, p1, -4, 0);
		case 2: verifie(p, p1, 0, 4);
		case 3: verifie(p, p1, 4, 0dd);
				
		}
		return false;
		
	}
	
	public boolean verifie(Personnage p, Personnage p1, int x, int y) {
		
		if(p.getX() == p1.getX() + x 
			&& p.getY() == p1.getY() + y 
			&& p.getX() + p.getTailleX() == p1.getX() + x 
			&& p.getY() + p.getTailleY() == p1.getY() + y )
			return true;
		
		return false;
	}

}
