package app.modele;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class JeanMichel {

	private ArrayList<Arme> inventaireArmes;

	private Arme equipee;

	//	private ArrayList<Item> listeItem;

	private SimpleIntegerProperty pointsVie;

	private SimpleIntegerProperty positionX;

	private SimpleIntegerProperty positionY;

	public JeanMichel(Arme e, int x, int y) {
		//TODO initialiser x, y et listeItem
		this.inventaireArmes = new ArrayList<>();
		this.equipee = e;
		//listeItem = new ArrayList<>();
		this.pointsVie = new SimpleIntegerProperty(100);
		this.positionX = new SimpleIntegerProperty(x);
		this.positionY = new SimpleIntegerProperty(y);
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
	
	public void haut() {
		this.positionY.subtract(1);
	}
	
	public void bas() {
		this.positionY.add(1);
	}
	
	public void gauche() {
		this.positionX.subtract(1);
	}
	
	public void droite() {
		this.positionX.add(1);
	}


//	public void deplacer(KeyEvent e) {
//		
//		KeyCode value = e.getCode();
//		switch(value) {
//		case Z: this.positionY.subtract(1);
//		break;
//		case Q: this.positionX.subtract(1);
//		break;
//		case S: this.positionY.add(1);
//		break;
//		case D: this.positionX.add(1);
//		break;
//
//		}
//	}



	public void attaquer(/*Ennemi e*/) {
		try {
			//			if(equipe.getZoneAdapt().equals(e.getZone())) {
			//			e.setvie(equipe.getDgtZone());
			//		}
			//		else {
			//			e.setvie(equipe.getDgtPasZone());
			//		}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
