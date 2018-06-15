package app.modele;

public abstract class Ennemi extends Personnage{

	protected Jeu jeu;


	public Ennemi(String n, int pv, int x, int y, int tx, int ty) {
		super(n, pv, x, y, tx, ty);
		System.out.println("Superclass ennemi created");
	}

	public abstract void seDeplacer();

	public void setJeu(Jeu j) {
		this.jeu = j;
	}

}
