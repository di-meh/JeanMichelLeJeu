package app.modele;

import java.util.HashMap;

public class BFS {

	private Tile sommetZero;
	
	private Terrain terrain;
	
	private HashMap<Tile, Tile> tiles;
	
	private HashMap<Tile, Tile> sommetsMarques;
	
	private int[][] tabObstacles;
	
	private int[][] tabDistance;
	
	public BFS(JeanMichel jm) {
		this.sommetZero = new Tile(jm.getX()/16, jm.getY()/16);
		this.terrain = new Terrain();
		this.tiles = new HashMap<Tile, Tile>();
		this.tabObstacles = this.terrain.getTab2dObs();
		
		setTabDistance();
		
	}
	
	public void algorithme() {
		
		while(this.tiles.size() == 0) {
			this.tiles.put(null, null);
			
			
		}
	}

	public void setTabDistance() {
		for(int x = 0; x < tabObstacles.length; x++) {
			for(int y = 0; y < tabObstacles[x].length; y++) {
				if(tabObstacles[x][y - 1] ;
				|| tabObstacles[x][y + 1] 
				|| tabObstacles[x - 1][y] 
				|| tabObstacles[x + 1][y] ) {
					
				}
			}
		}
	}
	
	
/*	public Tile intToTile(int i) {
		int x = 0;
		int y = 0;
		
		return new Tile(x, y);
	}*/
	
}
