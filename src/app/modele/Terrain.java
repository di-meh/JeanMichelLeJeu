package app.modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Terrain {

	private int[][] tab_2d, tab_2d_obs;
	
	private String urlMapBase = "src/app/modele/MapMatriceBase.txt", urlMapObs = "src/app/modele/MapMatriceObs.txt";

	private static final int tailleTab = 32;

	public Terrain() {
		this.tab_2d = initMap(urlMapBase);
		this.tab_2d_obs = initMap(urlMapObs);
	}

	public int[][] initMap(String url) { //Méthode permettant de générer une map via un texte file
		
		int[][] tab2d = new int[tailleTab][tailleTab];
		String ligne = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(url));
			int x = 0; 
			do {
				int y = 0;
				ligne = br.readLine();
				if (ligne != null) {
					StringTokenizer s = new StringTokenizer(ligne, ",");
					while (s.hasMoreTokens()) {
						tab2d[x][y] = Integer.parseInt(s.nextToken());
						y++;
					}
					x++;
				}

			} while (ligne != null);
			br.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return tab2d;
	}

	public int getTailleTab() {
		return tailleTab;
	}
	
	public int[][] getTab2dBase() {
		return this.tab_2d;
	}

	public int[][] getTab2dObs() {
		return this.tab_2d_obs;
	}

	public String getUrlObs() {
		return this.urlMapObs;
	}
}
