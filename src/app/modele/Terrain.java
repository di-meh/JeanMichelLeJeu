package app.modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Terrain {


//	private int[] tab_1d = {
//			210,210,210,210,210,210,210,210,210,210,210,210,
//			210,210,210,210,210,210,211,210,210,210,210,210,
//			210,210,186,210,210,210,210,210,187,210,210,210,
//			210,210,210,210,187,210,210,210,210,210,210,210,
//			210,210,211,210,210,210,210,210,210,187,210,210,
//			210,210,210,210,210,210,186,210,210,210,210,210,
//			210,210,210,210,210,210,210,210,210,210,210,210,
//			210,210,210,210,210,210,210,211,210,210,210,210,
//			210,210,210,187,210,210,210,210,210,210,210,210,
//			210,210,210,210,186,210,210,210,210,186,210,210,
//			210,210,186,210,210,210,210,211,210,210,210,210,
//			210,210,210,210,210,210,210,210,210,210,210,210};
//
//	private int[] tab_1d_obs = {
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,197,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,0,0,0,0
//	};
	private int[][] tab_2d, tab_2d_obs;

	private String urlMapBase = "src/app/modele/MapMatriceBase.txt", urlMapObs = "src/app/modele/MapMatriceObs.txt";
	
	
	private static final int tailleTab = 12;	


	public Terrain() {
//		this.tab_2d = tab1dTo2d(tab_1d);
//		this.tab_2d_obs = tab1dTo2d(tab_1d_obs);
		
		this.tab_2d = initMap(urlMapBase);
		this.tab_2d_obs = initMap(urlMapObs);
	}

	public int[][] getTab2dBase() {
		return this.tab_2d;
	}

	public int[][] initMap(String url) { //Méthode permettant de générer une map via un text file
		
		//Première version, à améliorer
		
		int[][] tab2d = new int[tailleTab][tailleTab];
		String ligne = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(url));
			int x = 0;
			
			do {
				int y = 0;
				try {
					ligne = br.readLine();
				}catch (Exception e) {
					e.printStackTrace();
				}
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


	public int[][] tab1dTo2d(int [] tab1d) {
		int [][] tab2d = new int[tailleTab][tailleTab];
		for (int x = 0; x< tab2d.length; x++) {
			for (int y = 0; y< tab2d[x].length; y++) {
				tab2d[y][x] = tab1d[x+tailleTab*y];
			}
		}
		return tab2d;
	}



	public int getTailleTab() {
		return tailleTab;
	}


	public int[][] getTab2dObs() {
		return tab_2d_obs;
	}


	public void setTab2dObs(int[][] tab_2d_obs) {
		this.tab_2d_obs = tab_2d_obs;
	}


}

