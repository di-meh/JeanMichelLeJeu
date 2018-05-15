import javafx.scene.image.Image;

public abstract class PNJ {

	private String nom;
	
	private Image tileset;
	
	private int positionX;
	
	private int positionY;
	
	public PNJ(String n, String lien, int x, int y) {
		this.nom = n;
		this.tileset = new Image(lien);
		this.positionX = x;
		this.positionY = y;
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
		this.positionX += x;
	}
	
	public void setPositionY(int y) {
		this.positionX += y;
	}
	
	public void deplacement() {
		for(int i = 0; i <= 2; i++) {
			setPositionX(1);
			setPositionX(1);
			setPositionX(-1);
			setPositionX(-1);
		}
	}
	
	
}
