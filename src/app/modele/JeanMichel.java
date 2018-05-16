package app.modele;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;

public class JeanMichel {//TODO: bosser sur le modèle et sur son affichage dans le controleur
	private ArrayList<Arme> listeArmes;
	private Arme equipé;
//	private ArrayList<Item> listeItem;
	private SimpleIntegerProperty vie;
	private int x;
	private int y;
	public JeanMichel() {
		//TODO initialiser x, y et listeItem
		this.listeArmes=new ArrayList<>();
		//listeItem = new ArrayList<>();
		this.vie = new SimpleIntegerProperty(100);
		//x
		//y
		
	}
	public final ArrayList<Arme> getListeArmes() {
		return listeArmes;
	}
	public final void AddArmes(Arme arme) {
		this.listeArmes.add(arme);
	}
	public final SimpleIntegerProperty getVie() {
		return vie;
	}
	public final void setVie(SimpleIntegerProperty vie) {
		this.vie = vie;
	}
	public final int getX() {
		return x;
	}
	public final void setX(int x) {
		this.x = x;
	}
	public final int getY() {
		return y;
	}
	public final void setY(int y) {
		this.y = y;
	}
	public void attaquer(/*Ennemi e*/) {
		try {
//			if(equipé.getZoneAdapt().equals(e.getZone())) {
//			e.setvie(equipé.getDgtZone());
//		}
//		else {
//			e.setvie(equipé.getDgtPasZone());
//		}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
