package app.modele;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemi {

	private String nom;

	private SimpleIntegerProperty positionX;
	
	private SimpleIntegerProperty positionY;
	
	private int pointsVie;

	private int tailleX, tailleY;
	
	private int attaque;
	
	private GestionCollision collision;

	public Ennemi(String n, int pv, int atq, int x, int y) {

		this.positionX = new SimpleIntegerProperty(x);
		this.positionY = new SimpleIntegerProperty(y);
		this.tailleX = 12;
		this.tailleY = 29;
		this.nom = n;
		this.pointsVie = pv;
		this.attaque = atq;
		this.collision = new GestionCollision();
		
		System.out.println("Superclass ennemi created");
	}

	public String getNom() {
		return this.nom;
	}

	public int getVie() {
		return this.pointsVie;
	}

	public int getAttaque() {
		return this.attaque;
	}

	public int getX() {
		return this.positionX.getValue();
	}

	public int getY() {
		return this.positionY.getValue();
	}
	
	public final SimpleIntegerProperty XProperty() {
		return this.positionX;
	}

	public final void setX(SimpleIntegerProperty x) {
		this.positionX = x;
	}
	
	public final SimpleIntegerProperty YProperty() {
		return this.positionY;
	}
	
	public final void setY(SimpleIntegerProperty y) {
		this.positionY = y;
	}

	public void setAttaque(int atq) {
		this.attaque = atq;
	}

	public void setVie(int pv) {
		this.pointsVie = pv;
	}

	public void perdreVie(int pv) {
		this.pointsVie -= pv;
	}

	public abstract void deplacement();
	
	public void haut() {
		if(!collision.collisionne(getX(), getY() - 4))
				this.positionY.set(getY()-1);
	}

	public void bas() {
		if(!collision.collisionne(getX()-4, getY()))
				this.positionY.set(getY()+1);
	}

	public void gauche() {
		if(!collision.collisionne(getX(), getY() + 4 + getTailleY()))
				this.positionX.set(getX()-1);
	}

	public void droite() {
		if(!collision.collisionne(getX() + 4 + getTailleX(), getY()))
			this.positionX.set(getX()+1);
	}
	
	public int getTailleX() {
		return tailleX;
	}

	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}

}
