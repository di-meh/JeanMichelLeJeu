package app.modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;

public abstract class Item {

	private String nom;
	private SimpleIntegerProperty x, y;
	private int tailleX, tailleY;
	private Rectangle2D rectangle;
	//	private boolean deplacable;
	//	private boolean cassable;

	//La dimension d'objet cassable est à revoir
	
	public Item(String nom, int x, int y) {
		this.nom = nom;
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		//		deplacable=dplcbl;
		//		cassable=cssble;
	}
	public Item(String nom, int x, int y, int tailleX, int tailleY) {
		this(nom, x, y);
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		rectangle = new Rectangle2D(x, y, tailleX, tailleY);
	}
	


	public int getX() {
		return x.get();
	}

	public int getY() {
		return y.get();
	}

	public SimpleIntegerProperty XProperty() {
		return x;
	}
	public SimpleIntegerProperty YProperty() {
		return y;
	}
	public String getNom() {
		return nom;
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
}
	//	public final boolean isDeplacable() {
	//		return deplacable;
	//	}
	//	public final boolean isCassable() {
	//		return cassable;
	//	}
	//	
