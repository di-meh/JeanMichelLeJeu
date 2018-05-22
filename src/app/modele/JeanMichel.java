package app.modele;

import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;

public class JeanMichel {
	
	private ArrayList<Arme> inventaireArmes;
	
	private Arme equipee;
	
//	private ArrayList<Item> listeItem;
	
	private SimpleIntegerProperty pointsVie;
	
	private int positionX;
	
	private int positionY;
	
	public JeanMichel(Arme e, int x, int y) {
		//TODO initialiser x, y et listeItem
		this.inventaireArmes = new ArrayList<>();
		this.equipee = e;
		//listeItem = new ArrayList<>();
		this.pointsVie = new SimpleIntegerProperty(100);
		this.positionX = x;
		this.positionY = y;
	}
	
	public final ArrayList<Arme> getListeArmes() {
		return inventaireArmes;
	}
	
	public final void AddArmes(Arme a) {
		this.inventaireArmes.add(a);
	}
	
	public final SimpleIntegerProperty getPointsVie() {
		return this.pointsVie;
	}
	
	public final int getX() {
		return this.positionX;
	}
	
	public final int getY() {
		return this.positionY;
	}
	
	public final void setPointsVie(SimpleIntegerProperty v) {
		this.pointsVie = v;
	}
	
	public final void setX(int x) {
		this.positionX = x;
	}
	
	public final void setY(int y) {
		this.positionY = y;
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
