package app.modele;

public class PNJVie extends PNJ{

	public PNJVie(String n, int x, int y) {
		super(n, x, y);
		System.out.println("Class PNJVie created");
	}
	
	public void parler(int i) {
		
		while(i != 4) {
			switch(i){
			case 0: System.out.println("Toi la ! Besoin de vie ?");
			case 1: System.out.println("Ok salut !");
			case 2: System.out.println("Une vie coute 50 pieces");
				vendreVie(); //recuperer somme argent
			}
		}
	}

	private void vendreVie() {
		/*if()
			System.out.println("Vous n'avez pas assez d'argent au revoir !");
		else
			setArgent(argent)
		*/
	}
	
}
