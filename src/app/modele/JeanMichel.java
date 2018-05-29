package app.modele;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class JeanMichel{

	private ArrayList<Arme> inventaireArmes;

	private Arme equipee;

	private int tailleX, tailleY;
	
	private SimpleIntegerProperty pointsVie;

	private SimpleIntegerProperty positionX, positionY;
	
	private GestionCollision collision;

	public JeanMichel(Arme e, int x, int y) {
		this.setTailleX(17);
		this.setTailleY(23);
		this.inventaireArmes = new ArrayList<>();
		this.setArme(e);
		this.pointsVie = new SimpleIntegerProperty(100);
		this.positionX = new SimpleIntegerProperty(x);
		this.positionY = new SimpleIntegerProperty(y);
		this.collision = new GestionCollision();
	}

	public ArrayList<Arme> getListeArmes() {
		return inventaireArmes;
	}

	public void AddArmes(Arme a) {
		this.inventaireArmes.add(a);
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

	public final SimpleIntegerProperty XProperty() {
		return this.positionX;
	}

	public final void setX(SimpleIntegerProperty x) {
		this.positionX = x;
	}

	public final int getX() {
		return this.positionX.getValue();
	}

	public final void setX(int x) {
		this.positionX.setValue(x);
	}

	public final SimpleIntegerProperty YProperty() {
		return this.positionY;
	}

	public final void setY(SimpleIntegerProperty y) {
		this.positionY = y;
	}

	public final int getY() {
		return this.positionY.getValue();
	}

	public final void setY(int y) {
		this.positionX.setValue(y);
	}
	
	public void deplacement(KeyEvent e) {
		KeyCode value = e.getCode();

		switch(value) {
		case Z: if(!collision.collisionne(getX(), getY() - 4) && !collision.collisionne(getX()+getTailleX(), getY()-4)) haut();
		break;
		case Q: if(!collision.collisionne(getX()-4, getY()) && !collision.collisionne(getX()-4, getY()+getTailleY()) && !collision.collisionne(getX()-4, getY()+getTailleY()/2)) gauche(); 
		break;
		case S: if(!collision.collisionne(getX(), getY() + 4+getTailleY()) && !collision.collisionne(getX()+getTailleX(), getY()+4+getTailleY())) bas(); 
		break;
		case D: if(!collision.collisionne(getX()+4+getTailleX(), getY()) && !collision.collisionne(getX()+getTailleX()+4, getY()+getTailleY()) && !collision.collisionne(getX()+getTailleX()+4, getY()+getTailleY()/2)) droite(); 
		break;
		default:
			break;
		}
	}

	public void haut() {
		this.positionY.set(getY()-4);
	}

	public void bas() {
		this.positionY.set(getY()+4);
	}

	public void gauche() {
		this.positionX.set(getX()-4);
	}

	public void droite() {
		this.positionX.set(getX()+4);
	}

	public Arme getArmeEquipee() {
		return equipee;
	}

	public void setArme(Arme equipee) {
		this.equipee = equipee;
	}

	public int getTailleX() {
		return tailleX;
	}

	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}

}
