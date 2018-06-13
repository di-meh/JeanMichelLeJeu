package app.modele;

import java.util.ArrayList;

import javafx.collections.FXCollections;
//import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Jeu {


	private ArrayList<Ennemi> listeEnnemis;
	private ArrayList<PNJ> listePNJs;
	private JeanMichel jeanMichel;
	
	private BFS bfs;
	private ObservableList<Item> listeItems;
	private GestionCollision collision;

	public Jeu() {
		this.listeEnnemis = new ArrayList<Ennemi>();
		this.collision = new GestionCollision();
		this.listePNJs = new ArrayList<PNJ>();
		this.listeItems = FXCollections.observableArrayList();
		this.jeanMichel = new JeanMichel(null, 0, 0);
		this.bfs = new BFS();
		
		this.listeItems.add(new Coeur(20,40));
		init(); //s'oocupe d'ajouter les ennemis/pnj aux listes
	}

	public void init() {
		//ajouter les ennemis
		addEnnemi(new Ennemi2("testEnnemi1",50, 120, 80));
		addEnnemi(new Ennemi2("testEnnemi2",50, 80, 0));

		//zone2

		//ajouter les pnjs
		//zone1
		addPNJ(new PNJArme("testPNJArme", 20, 40));
		addPNJ(new PNJItem("testPNJItem", 125, 40));
		addPNJ(new PNJVie("testPNJVie", 10, 200));
		//zone2
		addPNJ(new PNJArme("testPNJArme", 10, 200));
		addPNJ(new PNJItem("testPNJItem", 125, 40));
		addPNJ(new PNJVie("testPNJVie", 20, 40));

//		this.listeItems.addListener(new ListChangeListener<Item>() {
//			@Override
//			public void onChanged(Change<? extends Item> c) {
//				while(c.next()) {
//					for (Item remitem: c.getRemoved()) {
//						listeItems.remove(remitem);
//					}
//				}
//			}
//		});
	}

	public void update() {
		this.bfs.lancerBFS(this.jeanMichel);
		this.listeEnnemis.get(0).seDeplacer();
	}
	
	public BFS getBFS() {
		return this.bfs;
	}

	public void addEnnemi(Ennemi e) {
		this.listeEnnemis.add(e);
	}

	public ArrayList<Ennemi> getEnnemis() {
		return this.listeEnnemis;
	}

	public void addPNJ(PNJ p) {
		this.listePNJs.add(p);
	}

	public ArrayList<PNJ> getPNJ() {
		return this.listePNJs;
	}

	public JeanMichel getJeanMichel() {
		return jeanMichel;
	}

	public ObservableList<Item> getListeItems() {
		return listeItems;
	}

	public boolean peutSeDeplacer(int orientation) {
		for (Ennemi e: this.listeEnnemis) {

			switch(orientation) {
			case 0: 
				if (!this.collision.collisionneObstacle(jeanMichel.getX(), jeanMichel.getY() - 4) 
						&& !this.collision.collisionneObstacle(jeanMichel.getX() + jeanMichel.getTailleX(), jeanMichel.getY()-4) 
						&& !this.collision.collisionnePerso(e,jeanMichel, 0, 4)
						//&& !this.jeanMichel.getRectangle().intersects(e.getRectangle())
						)
					return true;
				break;
			case 1:
				if (!this.collision.collisionneObstacle(jeanMichel.getX()-4, jeanMichel.getY()) 
						&& !this.collision.collisionneObstacle(jeanMichel.getX() -4, jeanMichel.getY() + jeanMichel.getTailleY()) 
						&& !this.collision.collisionnePerso(e, jeanMichel, 1, 4)
						//&& !this.jeanMichel.getRectangle().intersects(e.getRectangle())
						)
					return true;
				break;
			case 2:
				if (!this.collision.collisionneObstacle(jeanMichel.getX(), jeanMichel.getY() + 4 + jeanMichel.getTailleY()) 
						&& !this.collision.collisionneObstacle(jeanMichel.getX() + jeanMichel.getTailleX(), jeanMichel.getY() + 4 + jeanMichel.getTailleY()) 
						&& !this.collision.collisionnePerso(e, jeanMichel, 2, 4)
						//&& !this.jeanMichel.getRectangle().intersects(e.getRectangle())
						)
					return true;
				break;
			case 3:
				if (!this.collision.collisionneObstacle(jeanMichel.getX() + 4 + jeanMichel.getTailleX(), jeanMichel.getY()) 
						&& !this.collision.collisionneObstacle(jeanMichel.getX() + jeanMichel.getTailleX() + 4, jeanMichel.getY() + jeanMichel.getTailleY()) 
						&& !this.collision.collisionneObstacle(jeanMichel.getX() + jeanMichel.getTailleX() + 4, jeanMichel.getY() + jeanMichel.getTailleY()/2) 
						&& !this.collision.collisionnePerso(e, jeanMichel, 3, 4)
						//&& !this.jeanMichel.getRectangle().intersects(e.getRectangle())
						)
					return true;
				break;
			}
		}
		return false;
	}

	public boolean collisionObjet() {
		for (Item i: listeItems) {
			if (this.getJeanMichel().getX() == i.getX() 
					&& this.getJeanMichel().getY() == i.getY())
				return true;
			//				|| this.jeu.getJeanMichel().getX()+this.jeu.getJeanMichel().getTailleX() == this.jeu.getListeItems().get(0).getX() 
			//				&& this.jeu.getJeanMichel().getY() == this.jeu.getListeItems().get(0).getY()
			//				|| this.jeu.getJeanMichel().getX() == this.jeu.getListeItems().get(0).getX() 
			//				&& this.jeu.getJeanMichel().getY()+this.jeu.getJeanMichel().getTailleY() == this.jeu.getListeItems().get(0).getY()
			//				|| this.jeu.getJeanMichel().getX()+this.jeu.getJeanMichel().getTailleX() == this.jeu.getListeItems().get(0).getX() 
			//				&& this.jeu.getJeanMichel().getY()+this.jeu.getJeanMichel().getTailleY() == this.jeu.getListeItems().get(0).getY()
		}
		return false;
	}

}
