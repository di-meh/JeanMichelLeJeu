package app.modele;

public class PNJVie extends PNJ{

	public PNJVie(int x, int y) {
		super("truc7", "machin7", x, y);
		System.out.println("Class PNJVie created");
	}
	
	public void parler() {
		//menu pour discussion avec perso
		System.out.println("Toi la ! Besoin de vie ?");
	}
	
}
