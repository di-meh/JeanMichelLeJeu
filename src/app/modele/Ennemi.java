package app.modele;

public class Ennemi extends Personnage{

	private GestionCollision collision;

	private int orientation;

	public Ennemi(String n, int pv, int x, int y) {
		super(n, pv, x, y, 12, 29);
		this.collision = new GestionCollision();
		this.orientation = 0;

		System.out.println("Superclass ennemi created");
	}

	public void haut() {
		if(!collision.collisionne(getX(), getY() - 4) 
				&& !collision.collisionne(getX() + getTailleX(), getY() - 4)) {
			this.positionY.set(getY() - 1);
			this.orientation = 0;
		}
		else
			this.orientation = 1;
	}

	public void bas() {
		if(!collision.collisionne(getX(), getY() + 4 + getTailleY()) 
				&& !collision.collisionne(getX() + getTailleX(), getY() + 4 + getTailleY())) {
			this.positionY.set(getY() + 1);
			this.orientation = 1;
		}
		else
			this.orientation = 0;
	}

	public void gauche() {
		if(!collision.collisionne(getX() - 4, getY()) 
				&& !collision.collisionne(getX() - 4, getY() + getTailleY()) 
				&& !collision.collisionne(getX() - 4, getY() + getTailleY()/2)) {
			this.positionX.set(getX() - 1);
			this.orientation = 2;
		}
		else
			this.orientation = 3;
	}

	public void droite() {
		if(!collision.collisionne(getX() + 4 + getTailleX(), getY()) 
				&& !collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()) 
				&& !collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()/2)) {    
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

}
