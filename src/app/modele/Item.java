package app.modele;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Item {

	private String nom;
	private SimpleIntegerProperty x, y;
	private int tailleX, tailleY;
	
	public Item(String nom, int x, int y) {
		this.nom = nom;
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
	}
	
	//constructeur pour les items dont la taille est indeterminee
	public Item(String nom, int x, int y, int tailleX, int tailleY) {
		this(nom, x, y);
		this.tailleX = tailleX;
		this.tailleY = tailleY;
	}

	public int getX() {
		return this.x.get();
	}

	public int getY() {
		return this.y.get();
	}

	public SimpleIntegerProperty XProperty() {
		return this.x;
	}
	
	public SimpleIntegerProperty YProperty() {
		return this.y;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getTailleX() {
		return this.tailleX;
	}
	
	public int getTailleY() {
		return this.tailleY;
	}

}