package app.modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Terrain {

	private int[][] tab_2d, tab_2d_obs, tab_2d_obs_mov;
	private String urlMapBase = "src/app/modele/MapMatriceBase.txt", urlMapObs = "src/app/modele/MapMatriceObs.txt", urlMapObsMov = "src/app/modele/MapMatriceObsMov.txt";

	private static final int tailleTab = 32;

	//private static final int tailleTabY;


	public Terrain() {
		this.tab_2d = initMap(urlMapBase);
		this.tab_2d_obs = initMap(urlMapObs);
		this.tab_2d_obs_mov = initMap(urlMapObsMov);
	}


	public int[][] initMap(String url) { //Méthode permettant de générer une map via un text file

		//Première version, améliorable mais fonctionnelle

		int[][] tab2d = new int[tailleTab][tailleTab];
		String ligne = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(url));
			int x = 0; 
			do {
				int y = 0;
				ligne = br.readLine();
				if (ligne!=null) {
					StringTokenizer s = new StringTokenizer(ligne, ",");
					while (s.hasMoreTokens()) {
						tab2d[x][y] = Integer.parseInt(s.nextToken());
						y++;
					}
					x++;
				}

			}while (ligne != null);
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
		return tab_2d_obs;
	}
	public int[][] getTab2dObsMov() {
		return tab_2d_obs_mov;
	}

	public String getUrlBase() {
		return urlMapBase;
	}

	public String getUrlObs() {
		return urlMapObs;
	}

	public String getUrlMov() {
		return urlMapObsMov;
	}


	public void setTab2dObs(int[][] tab_2d_obs) {
		this.tab_2d_obs = tab_2d_obs;
	}

}
