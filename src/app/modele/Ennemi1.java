package app.modele;

public class Ennemi1 extends Ennemi {

	public Ennemi1(String n, int pv, int atq, int x, int y) {
		super(n, pv, atq, x, y);
	}

	@Override
	public void deplacement() {
		for(int i = 0; i < 20; i++) {
			droite();
			System.out.println("Je vais a droite");
		}
			
	}

}
