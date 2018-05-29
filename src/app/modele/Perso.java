package app.modele;

import javafx.beans.property.SimpleIntegerProperty;

public class Perso {
	/*private ArrayList<Armes> listeArmes;
	private Armes equipé;*/
//	private ArrayList<Item> listeItem;
	private SimpleIntegerProperty vie;
	private int x;
	private int y;
	
	public Perso() {
		/*//TODO initialiser x, y et listeItem
		this.listeArmes=new ArrayList<>();
		//listeItem = new ArrayList<>();*/
		this.vie = new SimpleIntegerProperty(100);
		//x
		//y
	}
	
	/*public final ArrayList<Armes> getListeArmes() {
		return listeArmes;
	}
	
	public final void AddArmes(Armes arme) {
		this.listeArmes.add(arme);
	}*/
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












