package app.modele;

public class PNJItem  extends PNJ{

	public PNJItem(int x, int y) {
		super("truc6", "machin6", x, y);
		System.out.println("Class PNJItem created");
	}

	public void parler(int i) {
		//menu pour discussion avec perso
		
		while(i != 4) {
			switch(i){
			case 1: System.out.println("Hey ! Tu veux des infos sur les items d'la region ?");//inserer objet region
			case 2: System.out.println("Ok salut !");
			case 3: System.out.println("Alors, voila c'que j'sais : ");
			}
		}
	}

	/*@Override
	public void deplacement() {
		
	}*/
	
}
