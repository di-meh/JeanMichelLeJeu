package app.modele;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage { //contient tous les getters et les setters necessaires a tous les personnages (ennemis, pnjs, Jean Michel)

	private String nom;

	protected SimpleIntegerProperty positionX, positionY;
	
	protected SimpleIntegerProperty pointsVie;
	
	private int tailleX, tailleY;

	private int orientation;

	protected GestionCollision collision;

	public Personnage(String n, int pv, int px, int py, int tx, int ty) {
		this.nom = n;
		this.pointsVie = new SimpleIntegerProperty(pv);
		this.positionX = new SimpleIntegerProperty(px);
		this.positionY = new SimpleIntegerProperty(py);
		this.tailleX = tx;
		this.tailleY = ty;
		this.collision = new GestionCollision();

		this.setOrientation(0);
	}

	public SimpleIntegerProperty pointsVieProperty() {
		return this.pointsVie;
	}

	public int getPointsVie() {
		return this.pointsVie.getValue();
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
		return this.tailleX;
	}

	public int getTailleY() {
		return this.tailleY;
	}

	public int getOrientation() {
		return this.orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public void attaquer(Personnage en) { 
		if (en != null && System.currentTimeMillis()%99 == 0) {
			en.estAttaque(1);
		}
	}
	
	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie() - atq);	
	}
	
	public int caseX() {
		return this.getX()/16;
	}
	
	public int caseY() {
		return this.getY()/16;
	}

}
