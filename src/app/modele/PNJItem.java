package app.modele;

public class PNJItem  extends PNJ{

	public PNJItem(int x, int y) {
		super("truc6", "machin6", x, y);
		System.out.println("Class PNJItem created");
	}

	public void parler() {
		//menu pour discussion avec perso
		int i = 0;
		
		while(i != 5) {
			System.out.println("Hey ! Tu veux des infos sur les items d'la region ?");//inserer objet region
			switch(i) {
			case 1: System.out.println("OK alors ...");
			case 2: System.out.println("OK salut.");
			}
		}
	}
	
}
