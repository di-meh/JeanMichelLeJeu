package app.modele;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemi {

	private String nom;

	private SimpleIntegerProperty positionX;
	
	private SimpleIntegerProperty positionY;

	private int tailleX, tailleY;
	
	private SimpleIntegerProperty pointsVie;
	
	private GestionCollision collision;
	
	private int attaque;

	public Ennemi(String n, int pv, int atq, int x, int y) {

		this.positionX = new SimpleIntegerProperty(x);
		this.positionY = new SimpleIntegerProperty(y);
		this.tailleX = 12;
		this.tailleY = 29;
		this.nom = n;
		this.pointsVie = new SimpleIntegerProperty(100);
		this.attaque = atq;
		this.collision = new GestionCollision();
		
		System.out.println("Superclass ennemi created");
	}

	public String getNom() {
		return this.nom;
	}

	public SimpleIntegerProperty pointsVieProperty() {
		return this.pointsVie;
	}

	public void setPointsVie(SimpleIntegerProperty v) {
		this.pointsVie = v;
	}
	
	public int getPointsVie() {
		return this.pointsVie.getValue();
	}

	public void setPointsVie(int val) {
		this.pointsVie.setValue(val);
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

	public abstract void deplacement();
	
	public void haut() {
		if(!collision.collisionne(getX(), getY() - 4) && !collision.collisionne(getX()+getTailleX(), getY()-4))
				this.positionY.set(getY()-1);
	}

	public void bas() {
		if(!collision.collisionne(getX(), getY() + 4 + getTailleY()) && !collision.collisionne(getX()+getTailleX(), getY()+4+getTailleY()))
				this.positionY.set(getY()+1);
	}

	public void gauche() {
		if(!collision.collisionne(getX()-4, getY()) && !collision.collisionne(getX()-4, getY()+getTailleY()) && !collision.collisionne(getX()-4, getY()+getTailleY()/2))
				this.positionX.set(getX()-1);
	}

	public void droite() {
		if(!collision.collisionne(getX() + 4 + getTailleX(), getY()) && !collision.collisionne(getX()+getTailleX()+4, getY()+getTailleY()) && !collision.collisionne(getX()+getTailleX()+4, getY()+getTailleY()/2))
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
	
	public int attaque() {
		return this.attaque;
	}

	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie()-atq);
	}
	
}
