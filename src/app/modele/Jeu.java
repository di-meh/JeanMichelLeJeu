package app.modele;

import java.util.ArrayList;


public class Jeu {

	private ArrayList<Ennemi> ennemis;
	private JeanMichel jeanMichel;

	public Jeu() {
		this.ennemis = new ArrayList<Ennemi>();
		this.ennemis.add(new Ennemi("test",50, 0, 80));
		this.jeanMichel = new JeanMichel(null, 0, 0);
	}

	public Ennemi getEnnemi() {
		return ennemis.get(0);
	}

	public JeanMichel getJeanMichel() {
		return jeanMichel;
	}
	
}