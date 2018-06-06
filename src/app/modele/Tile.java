package app.modele;

public class Tile {

	private int x;
	
	private int y;
	
	private boolean estMarque;
	
	public Tile(int nx, int ny) {
		this.x = nx;
		this.y = ny;
		this.estMarque = false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getEstMarque() {
		return this.estMarque;
	}
	
	public void setEstMarque() {
		this.estMarque = true;
	}
}
