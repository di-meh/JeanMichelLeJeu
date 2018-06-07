package app.modele;

public abstract class Ennemi extends Personnage{

	protected GestionCollision collision;

	protected Jeu jeu;
	
	
	public Ennemi(String n, int pv, int x, int y) {
		super(n, pv, x, y, 12, 29);
		this.collision = new GestionCollision();


		System.out.println("Superclass ennemi created");
	}


	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie()-atq);
	}

	public abstract void seDeplacer();
	
	public void setJeu(Jeu j) {
		this.jeu = j;
	}
	
}
