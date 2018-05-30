package app.modele;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage { //contient tous les getters et les setters necessaires a tous les personnages (ennemis, pnjs, Jean Michel)
	
	private String nom;

	protected SimpleIntegerProperty positionX, positionY;
	
	protected SimpleIntegerProperty pointsVie;

	private int tailleX, tailleY;
	
	public Personnage(String n, int px, int py, int tx, int ty) {

		this.nom = n;
		this.positionX = new SimpleIntegerProperty(px);
		this.positionY = new SimpleIntegerProperty(py);
		this.tailleX = tx;
		this.tailleY = ty;
	}
	
	public Personnage(String n, int pv, int px, int py, int tx, int ty) {
		
		this.nom = n;
		this.pointsVie = new SimpleIntegerProperty(pv);
		this.positionX = new SimpleIntegerProperty(px);
		this.positionY = new SimpleIntegerProperty(py);
		this.tailleX = tx;
		this.tailleY = ty;
		
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

	public String getNom() {
		return this.nom;
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
