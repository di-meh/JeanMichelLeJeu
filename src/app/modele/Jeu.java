package app.modele;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;


public class Jeu {

	private ObservableList<Ennemi> ennemis;
	private ArrayList<PNJ> pnjs;
	private JeanMichel jeanMichel;
	public static boolean ennemiRetiré=false;

	public Jeu() {
		this.ennemis = FXCollections.observableArrayList();
		this.pnjs = new ArrayList<PNJ>();
		this.jeanMichel = new JeanMichel(null, 0, 0);
		init();
	}

	public void init() {
		//ajouter les ennemis
		//zone1
		addEnnemi(new Ennemi("testEnnemi1",5, 0, 80));
		addEnnemi(new Ennemi("testEnnemi2",5, 80, 0));

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
		
		ennemis.addListener(new ListChangeListener<Ennemi>() {
			@Override
			public void onChanged(Change<? extends Ennemi> c) {
				while (c.next()) {
		             if (c.wasPermutated()) {
		                     for (int i = c.getFrom(); i < c.getTo(); ++i) {
		                          //permutate
		                     }
		                 } else if (c.wasUpdated()) {
		                          //update item
		                 } else {
		                     for (Ennemi remitem : c.getRemoved()) {
		                         ennemis.remove(remitem);
		                     }
		                 }
		             }
			}
			
			
		     });

		 
	}

	public void update() {
		this.ennemis.get(0).seDeplacer();
		for (Ennemi ennemi : ennemis) {
			if(ennemi.getPointsVie()==0) {
				ennemiRetiré=ennemis.remove(ennemi);
			}
		}

	}

	public void addEnnemi(Ennemi e) {
		this.ennemis.add(e);
	}

	public ObservableList<Ennemi> getEnnemis() {
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
