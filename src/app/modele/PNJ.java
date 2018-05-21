package app.modele;

import javafx.scene.image.Image;

public abstract class PNJ {

	private String nom;
	
	private int positionX;
	
	private int positionY;
	
	public PNJ(String n, String lien, int x, int y) {
		if (n == null || n.equals(""))
			throw new Error("Creation class ennemi1 impossible : erreur nom incorrect");
		this.nom = n;
		if (x <= 0)
			throw new Error("Creation class ennemi1 impossible : erreur x incorrect");
		this.positionX = x;
		if (y <= 0)
			throw new Error("Creation class ennemi1 impossible : erreur y incorrect");
		this.positionY = y;
		System.out.println("Superclass PNJ created");
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getpositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	public void setPositionY(int y) {
		this.positionX = y;
	}
	
/*	public abstract void deplacement();*/
	
	public abstract void parler(int i);
	
}
