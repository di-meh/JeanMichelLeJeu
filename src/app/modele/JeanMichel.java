package app.modele;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class JeanMichel extends Personnage{

	private ArrayList<Arme> inventaireArmes;

	private Arme equipee;

	private int tailleX, tailleY;
	
	private GestionCollision collision;

	private Jeu jeu;

	public JeanMichel(Arme e, int x, int y) {
		super("Jean-Michel", 100, x, y, 17, 23);
		this.inventaireArmes = new ArrayList<>();
		this.setArme(e);
		this.collision = new GestionCollision();
		//listeItem = new ArrayList<>();
	}

	public ArrayList<Arme> getListeArmes() {
		return inventaireArmes;
	}

	public void addArmes(Arme a) {
		this.inventaireArmes.add(a);
	}

	public void action(KeyEvent e) {
		KeyCode value = e.getCode();

		switch(value) {
		case Z: if(!this.collision.collisionne(getX(), getY() - 4) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY()-4) 
				/*&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0))*/)
			haut();
		break;
		case Q: if(!this.collision.collisionne(getX() - 4, getY()) 
				&& !this.collision.collisionne(getX() - 4, getY()+getTailleY()) 
				&& !this.collision.collisionne(getX() - 4, getY()+getTailleY()/2) 
				/*&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0))*/)
			gauche();
		break;
		case S: if(!this.collision.collisionne(getX(), getY() + 4 + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY() + 4 + getTailleY()) 
				/*&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0))*/)
			bas();
		break;
		case D: if(!this.collision.collisionne(getX() + 4, getY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()/2) 
				/*&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0))*/)
			droite();
		break;
		case E: System.out.println("Button E pressed"); //attaquer
		break;
		case F: System.out.println("Button F pressed");//pousser/tirer
				pousser(e);
		break;
		case K: System.out.println("Button K pressed"); //changer d'arme
		break;
		case L: parler();
		break;
		case M: System.out.println("Button M pressed"); //afficher map
		break;
		default:
			break;
		}
	}

	public void haut() {
		this.positionY.set(getY() - 4);
	}

	public void bas() {
		this.positionY.set(getY() + 4);
	}

	public void gauche() {
		this.positionX.set(getX() - 4);
	}

	public void droite() {
		this.positionX.set(getX() + 4);
	}

	//	public void attaquer(/*Ennemi e*/) { TODO
	//		try {
	//			//			if(equipe.getZoneAdapt().equals(e.getZone())) {
	//			//			e.setvie(equipe.getDgtZone());
	//			//		}
	//			//		else {
	//			//			e.setvie(equipe.getDgtPasZone());
	//			//		}
	//		} catch (Exception e) {
	//			// TODO: handle exception
	//		}
	//
	//	}

	public Arme getArmeEquipee() {
		return equipee;
	}

	public void setArme(Arme equipee) {
		this.equipee = equipee;
	}

	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie()-atq);
	}

	public void repondre() {
		int i = 0;

		while(i != 4) {
			switch(i) {
			case 1: System.out.println("Oui");
			case 2: System.out.println("Non");
			case 3: System.out.println("J'ai pas compris");
			}
		}
	}

	public void parler() {

	}

	public void pousser(KeyEvent c) { //TODO gérer le cas de tirer
		// Impossible de gérer deux keypress à la suite à travers deux méthodes différentes 
		
		KeyCode value = c.getCode();
		switch (value) {
		case Z:if(!this.collision.collisionne(getX(), getY() - 4) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY()-4)) System.out.println("Bouton Z presséééééééééééééééééééééééééééééé");
		break;
		case S:if(!this.collision.collisionne(getX(), getY() + 4 + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY() + 4 + getTailleY())) System.out.println("Bouton S presséééééééééééééééééééééééééééééé");
		break;
		case Q:if(!this.collision.collisionne(getX() - 4, getY()) 
				&& !this.collision.collisionne(getX() - 4, getY()+getTailleY()) 
				&& !this.collision.collisionne(getX() - 4, getY()+getTailleY()/2)) System.out.println("Bouton Q presséééééééééééééééééééééééééééééé");
		break;
		case D: if(!this.collision.collisionne(getX() + 4 + getTailleX(), getY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()/2)) System.out.println("Bouton D presséééééééééééééééééééééééééééééé");
		break;
		default: break;
		}
	}

	public Jeu getJeu() {
		return this.jeu.getJeu();

	}

}

/*
 * 
 * personnageCible.recevoirDegats(arme.getDegatArme());

                if(personnageCible.getHp() <= 0)
                {
                        this.lvl += 1;
                }
 * 
 * 
 */

