package app.modele;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

public class JeanMichel {//TODO: bosser sur le modèle et sur son affichage dans le controleur
	private ArrayList<Arme> listeArmes;
	private Arme armeEquipée;
	private ArrayList<Item> inventaire;
	private SimpleIntegerProperty vie, argent;
	private int x, y;
	private Image sprite;

	public JeanMichel() {
		//TODO initialiser x, y et listeItem
		this.listeArmes=new ArrayList<>();
		setInventaire(new ArrayList<>());
		this.vie = new SimpleIntegerProperty(100);
		x=0;
		y=0;
		sprite = new Image("./app/img/Female_Sprite_face2.png"); //test de sprite
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
	public Image getSprite() {
		return sprite;
	}
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	public SimpleIntegerProperty getArgent() {
		return argent;
	}
	public void setArgent(SimpleIntegerProperty argent) {
		this.argent = argent;
	}
	public Arme getArmeEquipée() {
		return armeEquipée;
	}
	public void setArmeEquipée(Arme armeEquipée) {
		this.armeEquipée = armeEquipée;
	}
	public ArrayList<Item> getInventaire() {
		return inventaire;
	}
	public void setInventaire(ArrayList<Item> inventaire) {
		this.inventaire = inventaire;
	}

}
