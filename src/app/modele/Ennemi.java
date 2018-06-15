package app.modele;

import app.vue.VueCactus;
import app.vue.VuePersonnage;
import app.vue.VueTentacule;

public abstract class Ennemi extends Personnage{

	protected Jeu jeu;

	private VuePersonnage vue;

	public Ennemi(String n, int pv, int x, int y) {
		super(n, pv, x, y, 12, 29);
		System.out.println("Superclass ennemi created");
	}
	
	public abstract void seDeplacer();

	public void setJeu(Jeu j) {
		this.jeu = j;
	}

	public VuePersonnage getVue() {
		return vue;
	}

	public void setVue(VueCactus vue) {
		this.vue = vue;
	}

	public void setVue(VueTentacule vue) {
		this.vue = vue;
	}
	
}
