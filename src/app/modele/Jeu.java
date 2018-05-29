package app.modele;

//import java.util.ArrayList;


public class Jeu {

	//private ArrayList<Ennemi> ennemis;
	private Ennemi ennemi;
	private JeanMichel jeanMichel;

	public Jeu() {
		//this.ennemis = new ArrayList<Ennemi>();
		this.ennemi = new Ennemi1("test",50, 12, 0, 80);
		this.jeanMichel = new JeanMichel(null, 0, 0);
	}

	public Ennemi getEnnemi() {
		return ennemi;
	}
	
}