package app.modele;

public class PNJVie extends PNJ{

	public PNJVie(int x, int y) {
		super("truc7", "machin7", x, y);
		System.out.println("Class PNJVie created");
	}
	
	public void parler(int i) {
		//menu pour discussion avec persos
		
		while(i != 4) {
			switch(i){
			case 1: System.out.println("Toi la ! Besoin de vie ?");
			case 2: System.out.println("Ok salut !");
			case 3: donnerVie();
			}
		}
	}

	private void donnerVie() {
		// TODO methode qui prend argent perso et donne vie en echange
		
	}
	
}
