package app.modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;


public abstract class Personnage { //contient tous les getters et les setters necessaires a tous les personnages (ennemis, pnjs, Jean Michel)

	private String nom;

	protected SimpleIntegerProperty positionX, positionY;
	protected SimpleIntegerProperty pointsVie;
	private Rectangle2D rectangle;
	private int tailleX, tailleY;
	

	private int orientation;

	protected GestionCollision collision;

	public Personnage(String n, int px, int py, int tx, int ty) {

		this.nom = n;
		this.positionX = new SimpleIntegerProperty(px);
		this.positionY = new SimpleIntegerProperty(py);
		this.tailleX = tx;
		this.tailleY = ty;
		this.rectangle = new Rectangle2D(px, py, tx, ty);
		this.setOrientation(0);
	}

	public Personnage(String n, int pv, int px, int py, int tx, int ty) {

		this.nom = n;
		this.pointsVie = new SimpleIntegerProperty(pv);
		this.positionX = new SimpleIntegerProperty(px);
		this.positionY = new SimpleIntegerProperty(py);
		this.tailleX = tx;
		this.tailleY = ty;
		this.rectangle = new Rectangle2D(px, py, tx, ty);
		this.collision = new GestionCollision();

		this.setOrientation(0);
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

	public int getTailleY() {
		return tailleY;
	}

	public Rectangle2D getRectangle() {
		return rectangle;
	}


	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}


	public void attaquer(Personnage en) { 
		//		try {
		//						if(equipee.getZoneAdapt().equals(en.getZone())) {
		//						en.estAttaque(equipee.getDgtZone());
		//					}
		//					else {
		//				task		en.estAttaque(equipee.getDgtPasZone());
		//					}
		//		} catch (Exception e) {
		//			// TODO: handle exception
		//		}
		if (en != null && System.currentTimeMillis()%99==0) {
			en.estAttaque(1);
			
		}
	}
	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie()-atq);	
	}
	public int caseX() {
		return getX()/16;
	}
	public int caseY() {
		return getY()/16;
	}
	
}
