package app.modele;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
//import javafx.collections.ListChangeListener;

public class Jeu {

	private ArrayList<PNJ> listePNJs;
	private ObservableList<Ennemi> ennemis;
	private JeanMichel jeanMichel;
	
	private BFS bfs;
	private ObservableList<Item> listeItems;
	private GestionCollision collision;

	public static Ennemi ennemiRetiré=null;
	public Jeu() {
		this.collision = new GestionCollision();
		this.listePNJs = new ArrayList<PNJ>();
		this.listeItems = FXCollections.observableArrayList();
		this.ennemis = FXCollections.observableArrayList();
		this.jeanMichel = new JeanMichel(null, 0, 0);
		this.bfs = new BFS();
		
		this.listeItems.add(new Coeur(20,40));
		init(); //s'oocupe d'ajouter les ennemis/pnj aux listes
	}

	public void init() {
		//ajouter les ennemis
		//zone1
		addEnnemi(new Ennemi("testEnnemi1",5, 0, 80));
		addEnnemi(new Ennemi("testEnnemi4",5, 80, 60));
		addEnnemi(new Ennemi("testEnnemi5",5, 400, 0));
		addEnnemi(new Ennemi2("testEnnemi1",5, 120, 80));
		addEnnemi(new Ennemi2("testEnnemi2",5, 80, 0));

		//zone2

		//ajouter les pnjs
		//zone1
//		addPNJ(new PNJArme("testPNJArme", 20, 40));
//		addPNJ(new PNJItem("testPNJItem", 125, 40));
//		addPNJ(new PNJVie("testPNJVie", 10, 200));
//		//zone2
//		addPNJ(new PNJArme("testPNJArme", 10, 200));
//		addPNJ(new PNJItem("testPNJItem", 125, 40));
//		addPNJ(new PNJVie("testPNJVie", 20, 40));
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
		ennemis.addListener(new ListChangeListener<Ennemi>() {
			@Override
			public void onChanged(Change<? extends Ennemi> c) {
				while (c.next()) {
					if (c.wasRemoved()) {
						for (Ennemi remitem : c.getRemoved()) {
							ennemiRetiré=remitem;
						}
					}
				}
			}});
	}

	private void addEnnemi(Ennemi e) {
		this.ennemis.add(e);
	}

	public void update() {
		this.bfs.lancerBFS(this.jeanMichel);
			for (Ennemi ennemi : ennemis) {
				if(ennemi.getPointsVie() != 0) {
					ennemi.seDeplacer();
				}else {
					ennemis.remove(ennemi);
				}
			} 
	}
	
	public BFS getBFS() {
		return this.bfs;
	}

	public ObservableList<Ennemi> getEnnemis() {
		return this.ennemis;
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
		for (Ennemi e: this.ennemis) {

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

	public boolean collisionObjet() { //TODO gérer les collisions
		for (Item i: listeItems) {
			if (this.getJeanMichel().getX() == i.getX() && this.getJeanMichel().getY() == i.getY()
				|| this.getJeanMichel().getX()+this.getJeanMichel().getTailleX() == i.getX() && this.getJeanMichel().getY() == i.getY()
				|| this.getJeanMichel().getX() == i.getX() && this.getJeanMichel().getY()+this.getJeanMichel().getTailleY() == i.getY()
				|| this.getJeanMichel().getX()+this.getJeanMichel().getTailleX() == i.getX() && this.getJeanMichel().getY()+this.getJeanMichel().getTailleY() == i.getY())
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
