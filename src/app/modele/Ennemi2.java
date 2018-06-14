package app.modele;

public class Ennemi2 extends Ennemi{

	public Ennemi2(String n, int pv, int x, int y) {
		super(n, pv, x, y);
	}

	@Override
	public void seDeplacer() {
		switch(this.jeu.getBFS().deplacementEnnemi(this)) {
		case 0: haut();
		if(this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 0, 1))
			this.attaquer(this.jeu.getJeanMichel());
		break;
		case 1: bas();
		if(this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 1, 1))
			this.attaquer(this.jeu.getJeanMichel());
		break;
		case 2: gauche();
		if(this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 2, 1))
			this.attaquer(this.jeu.getJeanMichel());
		break;
		case 3: droite();
		if(this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 3, 1))
			this.attaquer(this.jeu.getJeanMichel());
		break;
		}
	}
	
	public void haut() {
		if(!this.collision.collisionneObstacle(getX(), getY() - 1) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX(), getY() - 1)
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 0, 1)) {
			this.positionY.set(getY() - 1);
		}
	}

	public void bas() {
		if(!this.collision.collisionneObstacle(getX(), getY() + 1 + getTailleY()) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX(), getY() + 1 + getTailleY())
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 1, 1)) {
			this.positionY.set(getY() + 1);
		}
	}

	public void gauche() {
		if(!this.collision.collisionneObstacle(getX() - 1, getY()) 
				&& !this.collision.collisionneObstacle(getX() - 1, getY() + getTailleY()) 
				&& !this.collision.collisionneObstacle(getX() - 1, getY() + getTailleY()/2)
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 2, 1)) {
			this.positionX.set(getX() - 1);
		}
	}

	public void droite() {
		if(!this.collision.collisionneObstacle(getX() + 1 + getTailleX(), getY()) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX() + 1, getY() + getTailleY()) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX() + 1, getY() + getTailleY()/2)
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 3, 1)) {    
			this.positionX.set(getX() + 1);
		}
	}

}
