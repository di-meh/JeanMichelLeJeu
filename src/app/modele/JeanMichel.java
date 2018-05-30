package app.modele;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class JeanMichel extends Personnage{

	private ArrayList<Arme> inventaireArmes;

	private Arme equipee;

	private GestionCollision collision;

	
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
		case Z: if(!collision.collisionne(getX(), getY() - 4) && !collision.collisionne(getX()+getTailleX(), getY()-4) /* et collision avec ennemis et pnj*/ ) haut();
		break;
		case Q: if(!collision.collisionne(getX()-4, getY()) && !collision.collisionne(getX()-4, getY()+getTailleY()) && !collision.collisionne(getX()-4, getY()+getTailleY()/2) /* et collision avec ennemis et pnj*/ ) gauche();
		break;
		case S: if(!collision.collisionne(getX(), getY() + 4 + getTailleY()) && !collision.collisionne(getX()+getTailleX(), getY()+4+getTailleY()) /* et collision avec ennemis et pnj*/ ) bas();
		break;
		case D: if(!collision.collisionne(getX() + 4 + getTailleX(), getY()) && !collision.collisionne(getX()+getTailleX()+4, getY()+getTailleY()) && !collision.collisionne(getX()+getTailleX()+4, getY()+getTailleY()/2) /* et collision avec ennemis et pnj*/ ) droite();                              
		break;
		case E: System.out.println("Button E pressed"); //attaquer
		break;
		case F: System.out.println("Button F pressed"); //pousser/tirer
		break;
		case K: System.out.println("Button K pressed"); //changer d'arme
		break;
		case L: System.out.println("Button L pressed"); //parler
		break;
		case M: System.out.println("Button M pressed"); //afficher map
		break;
		default:
			break;
		}
	}

	public void haut() {
		this.positionY.set(getY()-4);
	}

	public void bas() {
		this.positionY.set(getY()+4);
	}

	public void gauche() {
		this.positionX.set(getX()-4);
	}

	public void droite() {
		this.positionX.set(getX()+4);
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








