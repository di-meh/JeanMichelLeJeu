package app.modele;

public abstract class PNJ extends Personnage{
	
	public PNJ(String n, int x, int y) {
		super(n, x, y, 0, 0);
		System.out.println("Superclass PNJ created");
	}
	
}
