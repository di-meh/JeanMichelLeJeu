package app.modele;

public class Ennemi extends Personnage{

	private GestionCollision collision;

	private int orientation;

	private Jeu jeu;
	
	
	public Ennemi(String n, int pv, int x, int y) {
		super(n, pv, x, y, 12, 29);
		this.collision = new GestionCollision();
		this.orientation = 0;

		System.out.println("Superclass ennemi created");
	}

	public void haut() {
		if(!this.collision.collisionne(getX(), getY() - 1) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY() - 1)
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 0, 1)) {
			this.positionY.set(getY() - 1);
			this.orientation = 0;
		}
		else
			this.orientation = 1;
	}

	public void bas() {
		if(!this.collision.collisionne(getX(), getY() + 1 + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY() + 1 + getTailleY())
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 1, 1)) {
			this.positionY.set(getY() + 1);
			this.orientation = 1;
		}
		else
			this.orientation = 0;
	}

	public void gauche() {
		if(!this.collision.collisionne(getX() - 1, getY()) 
				&& !this.collision.collisionne(getX() - 1, getY() + getTailleY()) 
				&& !this.collision.collisionne(getX() - 1, getY() + getTailleY()/2)
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 2, 1)) {
			this.positionX.set(getX() - 1);
			this.orientation = 2;
		}
		else
			this.orientation = 3;
	}

	public void droite() {
		if(!this.collision.collisionne(getX() + 1 + getTailleX(), getY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 1, getY() + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 1, getY() + getTailleY()/2)
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 3, 1)) {    
			this.positionX.set(getX() + 1);
			this.orientation = 3;
		}
		else
			this.orientation = 2;
	}

	/*	public int attaque() {
		if()
			return this.attaque;
	}*/

	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie()-atq);
	}

	public void seDeplacer() {
		switch(this.orientation) {
		case 0: haut();
		break;
		case 1: bas();
		break;
		case 2: droite();
		break;
		case 3: gauche();
		break;
		}
	}
	
	public void setJeu(Jeu j) {
		this.jeu = j;
	}
	
}
