package app.vue;

import app.modele.Coeur;
import app.modele.Item;

public class VueCoeur extends VueItem {
	public VueCoeur(Item item) {
		super(item, "file:src/app/img/coeur.png");
	}
	
	public VueCoeur(Coeur c) {
		super(c, "file:src/app/img/coeur.png");
	}
}
