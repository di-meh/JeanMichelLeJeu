package app.modele;

public class PNJItem  extends PNJ{

	public PNJItem(String n, int x, int y) {
		super(n, x, y);
		System.out.println("Class PNJItem created");
	}

	public void parler(int i) {
		
		while(i != 4) {
			switch(i){
			case 0: System.out.println("Hey ! Tu veux des infos sur les items d'la region ?");//inserer objet region
			case 1: System.out.println("Ok salut !");
			case 2: System.out.println("Alors, voila c'que j'sais : ");
			}
		}
	}

	
}
