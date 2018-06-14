package app.modele;

import app.vue.VueEnnemi;

public abstract class Ennemi extends Personnage{

	private int orientation;

	protected Jeu jeu;

	private VueEnnemi vue;
	


	public Ennemi(String n, int pv, int x, int y) {
		super(n, pv, x, y, 12, 29);
		this.orientation = 0;
		System.out.println("Superclass ennemi created");
	}
	
	public abstract void seDeplacer();

	public void setJeu(Jeu j) {
		this.jeu = j;
	}

	public VueEnnemi getVue() {
		return vue;
	}

	public void setVue(VueEnnemi vue) {
		this.vue = vue;
	}

}
