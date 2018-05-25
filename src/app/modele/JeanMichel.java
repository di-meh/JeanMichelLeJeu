package app.modele;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class JeanMichel{

	private ArrayList<Arme> inventaireArmes;

	private Arme equipee;

	private int tailleX, tailleY;
	
	//	private ArrayList<Item> listeItem;

	private SimpleIntegerProperty pointsVie;

	private SimpleIntegerProperty positionX, positionY;
	
	private GestionCollision collision;

	public JeanMichel(Arme e, int x, int y) {
		//TODO initialiser x, y et listeItem
		this.tailleX = 16;
		this.tailleY = 32;
		this.inventaireArmes = new ArrayList<>();
		this.setArme(e);
		//listeItem = new ArrayList<>();
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
		case Z: if(!collision.collisionne(getX(), getY() - 4)) haut(); 
		break;
		case Q: if(!collision.collisionne(getX()-4, getY())) gauche();
		break;
		case S: if(!collision.collisionne(getX(), getY() + 4)) bas();
		break;
		case D: if(!collision.collisionne(getX()+4, getY()))droite();
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
//	public void attaquer(/*Ennemi e*/) { TODO
//		try {
//			//			if(equipe.getZoneAdapt().equals(e.getZone())) {
//			//			e.setvie(equipe.getDgtZone());
//			//		}
//			//		else {
//			//			e.setvie(equipe.getDgtPasZone());
//			//		}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}

	public Arme getArmeEquipee() {
		return equipee;
	}

	public void setArme(Arme equipee) {
		this.equipee = equipee;
	}

}
