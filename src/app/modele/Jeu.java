package app.modele;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Jeu {

	private ObservableList<Ennemi> listeEnnemis;
	private JeanMichel jeanMichel;
	
	private BFS bfs;
	private ObservableList<Item> listeItems;

	public static Ennemi ennemiRetiré=null;
	public Jeu() {
		this.listeEnnemis = FXCollections.observableArrayList();
		this.listeItems = FXCollections.observableArrayList();
		this.jeanMichel = new JeanMichel(null, 0, 0);
		this.bfs = new BFS();
		this.listeItems.add(new Coeur(20,40));
		init(); //s'oocupe d'ajouter les ennemis/pnj aux listes
	}

	public void init() {
		//ajouter les ennemis
		//zone1
		addEnnemi(new Ennemi("testEnnemi1", 5, 0, 80));
		addEnnemi(new Ennemi2("testEnnemi1", 5, 256, 500));
		addEnnemi(new Ennemi2("testEnnemi2", 5, 125, 200));

		listeEnnemis.addListener(new ListChangeListener<Ennemi>() {
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
		listeItems.addListener(new ListChangeListener<Item>() {

			@Override
			public void onChanged(Change<? extends Item> c) {
				while(c.next()) {
					for (Item remitem: c.getRemoved()) {
						listeItems.remove(remitem);
					}
				}
			}
			
		});
	}

	private void addEnnemi(Ennemi e) {
		this.listeEnnemis.add(e);
	}

	public void update() {
		this.bfs.lancerBFS(this.jeanMichel);
			for (Ennemi ennemi : listeEnnemis) {
				if(ennemi.getPointsVie() != 0) {
					ennemi.seDeplacer();
				}else {
					listeEnnemis.remove(ennemi);
				}
			} 
	}
	
	public BFS getBFS() {
		return this.bfs;
	}

	public ObservableList<Ennemi> getEnnemis() {
		return this.listeEnnemis;
	}

	public JeanMichel getJeanMichel() {
		return jeanMichel;
	}

	public ObservableList<Item> getListeItems() {
		return listeItems;
	}
	public boolean collisionObjet() { //TODO gérer les collisions
		for (Item i: listeItems) {
			if (this.getJeanMichel().getX() == i.getX() && this.getJeanMichel().getY() == i.getY()
				|| this.getJeanMichel().getX() + this.getJeanMichel().getTailleX() == i.getX() && this.getJeanMichel().getY() == i.getY()
				|| this.getJeanMichel().getX() == i.getX() && this.getJeanMichel().getY() + this.getJeanMichel().getTailleY() == i.getY()
				|| this.getJeanMichel().getX() + this.getJeanMichel().getTailleX() == i.getX() && this.getJeanMichel().getY() + this.getJeanMichel().getTailleY() == i.getY())
				return true;
		}
		return false;
	}

}
