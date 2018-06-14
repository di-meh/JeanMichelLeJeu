package app.modele;

import app.vue.VueEnnemi;

public class Ennemi extends Personnage{

	private int orientation;

	protected Jeu jeu;

	private VueEnnemi vue;
	


	public Ennemi(String n, int pv, int x, int y) {
		super(n, pv, x, y, 12, 29);
		this.orientation = 0;
		System.out.println("Superclass ennemi created");
	}

	public void haut() {
		if(!this.collision.collisionneObstacle(getX(), getY() - 1) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX(), getY() - 1)
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 0, 1)
				//&& !this.getRectangle().intersects(jeu.getJeanMichel().getRectangle())
				) 
		//if (jeu.peutSeDeplacer(orientation))
		{
			this.orientation = 0;
			this.positionY.set(getY() - 1);
			
		}
		else
			this.orientation = 3;
	}

	public void bas() {
		if(!this.collision.collisionneObstacle(getX(), getY() + 1 + getTailleY()) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX(), getY() + 1 + getTailleY())
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 1, 1))
		{
			this.orientation = 1;
			this.positionY.set(getY() + 1);
			
		}
		else
			this.orientation = 2;
	}

	public void gauche() {
		if(!this.collision.collisionneObstacle(getX() - 1, getY()) 
				&& !this.collision.collisionneObstacle(getX() - 1, getY() + getTailleY()) 
				&& !this.collision.collisionneObstacle(getX() - 1, getY() + getTailleY()/2)
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 2, 1))
		{
			this.orientation = 2;
			this.positionX.set(getX() - 1);
			
		}
		else
			this.orientation = 0;
	}

	public void droite() {
		if(!this.collision.collisionneObstacle(getX() + 1 + getTailleX(), getY()) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX() + 1, getY() + getTailleY()) 
				&& !this.collision.collisionneObstacle(getX() + getTailleX() + 1, getY() + getTailleY()/2)
				&& !this.collision.collisionnePerso(this.jeu.getJeanMichel(), this, 3, 1))
		{    
			this.orientation = 3;
			this.positionX.set(getX() + 1);
			
		}
		else
			this.orientation = 1;
	}

	public void seDeplacer() {
		try {
			switch(this.orientation) {
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void setJeu(Jeu j) {
		this.jeu = j;
	}

	public VueEnnemi getVue() {
		return vue;
	}

	public void setVue(VueEnnemi vue) {
		this.vue = vue;
	}

}
