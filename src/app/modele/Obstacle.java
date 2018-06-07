package app.modele;

import javafx.geometry.Rectangle2D;

public class Obstacle {
	
	private int id;
	private Rectangle2D rectangle;

	public Obstacle(int id) {
		this.id= id;
	}
	
	public int getId() {
		return id;
	}
	
	public Rectangle2D getRectangle() {
		return rectangle;
	}
}
