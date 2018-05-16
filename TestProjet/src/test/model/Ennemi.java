import javafx.scene.image.Image;

public abstract class Ennemi {

	private String nom;
	
	private Image tileset;
	
	private int pointsVie;
	
	private int attaque;
	
	private int positionX;
	
	private int positionY;
	
	public Ennemi(String n, String lien, int pv, int atq, int x, int y) {
		this.nom = n;
		this.tileset = new Image(lien);
		this.pointsVie = pv;
		this.attaque = atq;
		this.positionX = x;
		this.positionY = y;
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
		this.positionX += x;
	}
	
	public void setPositionY(int y) {
		this.positionY += y;
	}
	
	public void setVie(int pv) {
		this.pointsVie += pv;
	}
	
	public void attaquer() {
		
	}
	
	public abstract void deplacement();
	
}
