package app.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
	
	public final ArrayList<Arme> getListeArmes() {
		return inventaireArmes;
	}
	
	public final void AddArmes(Arme a) {
		this.inventaireArmes.add(a);
	}
	
	
	
	public final SimpleIntegerProperty pointsVieProperty() {
		return this.pointsVie;
	}
	
	public final void setPointsVie(SimpleIntegerProperty v) {
		this.pointsVie = v;
	}
	public final int getPointsVie() {
		return this.pointsVie.getValue();
	}
	
	public final void setPointsVie(int val) {
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
