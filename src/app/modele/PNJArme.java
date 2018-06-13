package app.modele;

public class PNJArme extends PNJ{

	public PNJArme(String n, int x, int y) {
		super(n, x, y);
		System.out.println("Class PNJArme created");
	}
	
	public void parler(int i) {
		
		while(i != 2) {
			switch(i) {
			case 0: System.out.println("Hey ! Tu veux des infos sur les armes d'la region ?");
			break;
			case 1: System.out.println("Alors, voila la devinette : ");
			break;
			default: System.out.println("Ok salut !");
			break;
			}
		}
	}

	
}
