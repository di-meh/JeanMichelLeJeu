package app.modele;

public class Ennemi2 extends Ennemi{

	public Ennemi2(String n, int pv, int x, int y) {
		super(n, pv, x, y);
		
	}

	@Override
	public void seDeplacer() {
		switch(this.jeu.getBFS().deplacementEnnemi(this.getX(), this.getY())) {
		case 0: haut();
		break;
		case 1: bas();
		break;
		case 2: gauche();
		break;
		case 3: droite();
		break;
		}
	}
	
	public void haut() {
		if(!this.collision.collisionne(getX(), getY() - 1) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY() - 1)
				&& !this.collision.collisionPerso(this.jeu.getJeanMichel(), this, 0, 1)) {
			this.positionY.set(getY() - 1);
		}
	}

	public void bas() {
		if(!this.collision.collisionne(getX(), getY() + 1 + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY() + 1 + getTailleY())
				&& !this.collision.collisionPerso(this.jeu.getJeanMichel(), this, 1, 1)) {
			this.positionY.set(getY() + 1);
		}
	}

	public void gauche() {
		if(!this.collision.collisionne(getX() - 1, getY()) 
				&& !this.collision.collisionne(getX() - 1, getY() + getTailleY()) 
				&& !this.collision.collisionne(getX() - 1, getY() + getTailleY()/2)
				&& !this.collision.collisionPerso(this.jeu.getJeanMichel(), this, 2, 1)) {
			this.positionX.set(getX() - 1);
		}
	}

	public void droite() {
		if(!this.collision.collisionne(getX() + 1 + getTailleX(), getY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 1, getY() + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 1, getY() + getTailleY()/2)
				&& !this.collision.collisionPerso(this.jeu.getJeanMichel(), this, 3, 1)) {
			this.positionX.set(getX() + 1);
		}
	}

}
