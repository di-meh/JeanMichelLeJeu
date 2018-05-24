package app.modele;

public abstract class Ennemi{

	private String nom;
	
	private int pointsVie;
	
	private int attaque;
	
	private int positionX;
	
	private int positionY;
	
	public Ennemi(String n, int pv, int atq, int x, int y) {
		if (n == null || n.equals(""))
			throw new Error("Creation superclass ennemi impossible : erreur nom incorrect");
		this.nom = n;
		if (pv <= 0)
			throw new Error("Creation superclass ennemi impossible : erreur points vie incorrect");
		this.pointsVie = pv;
		if (atq <= 0)
			throw new Error("Creation superclass ennemi impossible : erreur attaque incorrect");
		this.attaque = atq;
		if (x <= 0)
			throw new Error("Creation superclass ennemi impossible : erreur x incorrect");
		this.positionX = x;
		if (y <= 0)
			throw new Error("Creation superclass ennemi impossible : erreur y incorrect");
		this.positionY = y;
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
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public void setAttaque(int atq) {
		this.attaque += atq;
	}
	
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	public void setPositionY(int y) {
		this.positionY = y;
	}
	
	public void setVie(int pv) {
		this.pointsVie = pv;
	}
	
	public void perdreVie(int pv) {
		this.pointsVie -= pv;
	}
	
	public abstract void deplacement();
	
}
