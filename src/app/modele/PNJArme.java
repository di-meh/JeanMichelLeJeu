package app.modele;

public class PNJArme extends PNJ{

	public PNJArme(int x, int y) {
		super("truc5", "machin5", x, y);
		System.out.println("Class PNJArme created");
	}

	public void parler() {
		//menu pour discussion avec perso
		int i = 0;
		
		while(i != 5) {
			System.out.println("Hey ! Tu veux des infos sur les armes d'la region ?");
			switch(i) {
			case 1: System.out.println("OK alors ...");
			case 2: System.out.println("OK salut.");
			}
		}
	}
	
/*
	switch(i){
		case 1:("Hey ! Tu veux des infos sur les armes d'la region ?");
		case 2: System.out.println("Ok salut !");
		case 3: System.out.println("Alors, voila c'que j'sais : ");
	}
*/
	
}
