package app.modele;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Jeu {

	private ObservableList<Ennemi> listeEnnemis;
	
	private JeanMichel jeanMichel;

	private BFS bfs;
	
	private ObservableList<Item> listeItems;

<<<<<<< HEAD
	public static Ennemi ennemiRetire = null;
=======
	public static Ennemi ennemiRetiré = null;
>>>>>>> b0033e78c4380e3e38cd51191e754d4a28b7c212
	
	public Jeu() {
		this.listeEnnemis = FXCollections.observableArrayList();
		this.listeItems = FXCollections.observableArrayList();
		this.jeanMichel = new JeanMichel(0, 0);
		this.bfs = new BFS();
		this.listeItems.add(new Coeur(20, 40));
		init(); //s'oocupe d'ajouter les ennemis/pnj aux listes
	}

	public void init() {
		//ajouter les ennemis
		//zone1
		addEnnemi(new Cactus("Cactus1", 5, 0, 80));
		addEnnemi(new Tentacule("Tentacule1", 5, 256, 456));
		addEnnemi(new Tentacule("Tentacule2", 5, 125, 200));

		listeEnnemis.addListener(new ListChangeListener<Ennemi>() {
			@Override
			public void onChanged(Change<? extends Ennemi> c) {
				while (c.next()) {
					if (c.wasRemoved()) {
						for (Ennemi remitem : c.getRemoved()) {
<<<<<<< HEAD
							ennemiRetire = remitem;
=======
							ennemiRetiré = remitem;
>>>>>>> b0033e78c4380e3e38cd51191e754d4a28b7c212
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
		try {

			for (Ennemi ennemi : listeEnnemis) {
				if(ennemi.getPointsVie() != 0) {
					ennemi.seDeplacer();
				}else {
					listeEnnemis.remove(ennemi);
				}
			} 
		} catch (Exception e) {
		}
	}

	public BFS getBFS() {
		return this.bfs;
	}

	public ObservableList<Ennemi> getEnnemis() {
		return this.listeEnnemis;
	}

	public JeanMichel getJeanMichel() {
		return this.jeanMichel;
	}

	public ObservableList<Item> getListeItems() {
		return listeItems;
	}

}
