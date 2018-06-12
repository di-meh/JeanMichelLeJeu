package app.modele;

import java.util.ArrayList;

public class Jeu {

	private ArrayList<Ennemi> ennemis;
	
	private ArrayList<PNJ> pnjs;
	
	private JeanMichel jeanMichel;
	
	private BFS bfs;

	public Jeu() {
		this.ennemis = new ArrayList<Ennemi>();
		this.pnjs = new ArrayList<PNJ>();
		this.jeanMichel = new JeanMichel(null, 0, 0);
		this.bfs = new BFS();
		
		init(); //s'oocupe d'ajouter les ennemis/pnj aux listes
	}

	public void init() {
		//ajouter les ennemis
		//zone1
		addEnnemi(new Ennemi2("testEnnemi1",50, 120, 80));
		addEnnemi(new Cactus("testEnnemi2",50, 80, 0));

		//zone2
		addEnnemi(new Cactus("testEnnemi1",50, 0, 80));
		addEnnemi(new Cactus("testEnnemi2",50, 80, 0));

		//ajouter les pnjs
		//zone1
		addPNJ(new PNJArme("testPNJArme", 20, 40));
		addPNJ(new PNJItem("testPNJItem", 125, 40));
		addPNJ(new PNJVie("testPNJVie", 10, 200));
		//zone2
		addPNJ(new PNJArme("testPNJArme", 10, 200));
		addPNJ(new PNJItem("testPNJItem", 125, 40));
		addPNJ(new PNJVie("testPNJVie", 20, 40));
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

	public void addPNJ(PNJ p) {
		this.pnjs.add(p);
	}

	public ArrayList<PNJ> getPNJ() {
		return this.pnjs;
	}

	public JeanMichel getJeanMichel() {
		return jeanMichel;
	}

	public Jeu getJeu() {
		return this;
	}

}
