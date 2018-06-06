package app.modele;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Item {
//	private ImageView img;
//	private String lienIMG;
	
	private String nom;
	private SimpleIntegerProperty x;
	private SimpleIntegerProperty y;
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
	
//	public final ImageView getImg() {
//		return img;
//	}
//	public final String getLienIMG() {
//		return lienIMG;
//	}
//	public final boolean isDeplacable() {
//		return deplacable;
//	}
//	public final boolean isCassable() {
//		return cassable;
//	}
//	
	
}
