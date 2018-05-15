package app.modele;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;

public class PersoPrinc {
	private ArrayList<Armes> listeArmes;
//	private ArrayList<Item> listeItem;
	private SimpleIntegerProperty vie;
	private int x;
	private int y;
	public PersoPrinc() {
		//TODO initialiser x, y et listeItem
		listeArmes=new ArrayList<>();
		//listeItem = new ArrayList<>();
		vie = new SimpleIntegerProperty(100);
		//x
		//y
		
	}
	public final ArrayList<Armes> getListeArmes() {
		return listeArmes;
	}
	public final void AddArmes(Armes arme) {
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

}
