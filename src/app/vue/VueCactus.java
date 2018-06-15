package app.vue;

import app.modele.Ennemi;

public class VueCactus extends VuePersonnage{

	public VueCactus(Ennemi e) {
		super(e, "file:./src/app/img/cactus.png");
		e.setVue(this);
	}
}
