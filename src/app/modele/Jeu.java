package app.modele;

import java.util.ArrayList;

public class Jeu {

	private ArrayList<Ennemi> ennemis;
	
	private JeanMichel jeanMichel;
	
	private BFS bfs;

	public Jeu() {
		this.ennemis = new ArrayList<Ennemi>();
		this.jeanMichel = new JeanMichel(null, 0, 0);
		this.bfs = new BFS();
		
		init(); //s'oocupe d'ajouter les ennemis/pnj aux listes
	}

	public void init() {
		//ajouter les ennemis
		//zone1
		addEnnemi(new Ennemi2("testEnnemi1",50, 120, 80));
		addEnnemi(new Ennemi2("testEnnemi2",50, 80, 0));

	}

	public void update() {
		this.bfs.lancerBFS(this.jeanMichel);
		this.ennemis.get(0).seDeplacer();
	}
	
	public BFS getBFS() {
		return this.bfs;
	}

	public void addEnnemi(Ennemi e) {
		this.ennemis.add(e);
	}

	public ArrayList<Ennemi> getEnnemis() {
		return this.ennemis;
	}

	public JeanMichel getJeanMichel() {
		return jeanMichel;
	}

	public Jeu getJeu() {
		return this;
	}

}
