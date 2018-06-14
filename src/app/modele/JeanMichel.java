package app.modele;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class JeanMichel extends Personnage{

	private ArrayList<Arme> inventaireArmes;

	private ArrayList<Item> inventaire;

	private Arme equipee;

	private Jeu jeu;

	public JeanMichel(Arme e, int x, int y) {
		super("Jean-Michel", 5, x, y, 17, 23);
		this.inventaire = new ArrayList<>();
		this.inventaireArmes = new ArrayList<>();
		this.equipee = e;
		//listeItem = new ArrayList<>();
		System.out.println("Jean-Michel is ready");
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
		case Z: 
			if(!this.collision.collisionneObstacle(getX(), getY() - 4) 
					&& !this.collision.collisionneObstacle(getX() + getTailleX(), getY()-4) 
					&& !this.collision.collisionnePerso(ennemiACote(), this, 0, 4)) haut();
		case Q: 
			if(!this.collision.collisionneObstacle(getX()-4, getY()) 
					&& !this.collision.collisionneObstacle(getX() -4, getY() + getTailleY()) 
					&& !this.collision.collisionnePerso(ennemiACote(), this, 1, 4))
				gauche();
			break;
		case S: 
			if(!this.collision.collisionneObstacle(getX(), getY() + 4 + getTailleY()) 
					&& !this.collision.collisionneObstacle(getX() + getTailleX(), getY() + 4 + getTailleY()) 
					&& !this.collision.collisionnePerso(ennemiACote(), this, 2, 4))
				bas();
			break;
		case D: 
			if(!this.collision.collisionneObstacle(getX() + 4 + getTailleX(), getY()) 
					&& !this.collision.collisionneObstacle(getX() + getTailleX() + 4, getY() + getTailleY()) 
					&& !this.collision.collisionneObstacle(getX() + getTailleX() + 4, getY() + getTailleY()/2) 
					&& !this.collision.collisionnePerso(ennemiACote(), this, 3, 4))
				droite();
			break;
		case E:
			if(this.collision.collisionnePerso(ennemiACote(), this, 0, 4) || this.collision.collisionnePerso(ennemiACote(), this, 1, 4)||this.collision.collisionnePerso(ennemiACote(), this, 2, 4)||this.collision.collisionnePerso(ennemiACote(), this, 3, 4))
				this.attaquer(ennemiACote());
			break;
		case F: System.out.println("Button F pressed");//pousser/tirer
		//pousser(e);
		break;
		case K: System.out.println("Button K pressed"); //changer d'arme
		this.setPointsVie(getPointsVie()+1);
		break;
		case L:
		break;
		case M: System.out.println("Button M pressed"); //afficher map
		break;
		default:break;


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

	public void attaquer(Personnage en) { 
		if (en != null ) {
			en.estAttaque(1);
		}
	}
	public Arme getArmeEquipee() {
		return equipee;
	}

	public Jeu getJeu() {
		return this.jeu;

	}

	public void setJeu(Jeu j) {
		this.jeu = j;
	}

	public Ennemi ennemiACote() {
		for (Ennemi e : jeu.getEnnemis()) {
			if((int)e.getX()/16 == (int)((this.getX())/16) && (int)e.getY()/16 == (int)((this.getY())/16)
			|| (int)e.getX()/16 == (int)((this.getX()+4)/16) && (int)e.getY()/16 == (int)((this.getY()+4)/16)
			|| (int)e.getX()/16 == (int)((this.getX()-4)/16) && (int)e.getY()/16 == (int)((this.getY()-4)/16)
			|| (int)e.getX()/16 == (int)((this.getX())/16) && (int)e.getY()/16 == (int)((this.getY()-4)/16)
			|| (int)e.getX()/16 == (int)((this.getX()+4)/16) && (int)e.getY()/16 == (int)((this.getY())/16)
			|| (int)e.getX()/16 == (int)((this.getX())/16) && (int)e.getY()/16 == (int)((this.getY()+4)/16)
			|| (int)e.getX()/16 == (int)((this.getX()+4)/16) && (int)e.getY()/16 == (int)((this.getY()-4)/16)
			|| (int)e.getX()/16 == (int)((this.getX()-4)/16) && (int)e.getY()/16 == (int)((this.getY()+4)/16)
			|| (int)e.getX()/16 == (int)((this.getX()-4)/16) && (int)e.getY()/16 == (int)((this.getY())/16)) 
				return e;			
		}
		return null;
	}

	public ArrayList<Item> getInventaire() {
		return this.inventaire;
	}

	public void ramasserItem() {
		//this.jeu.setItem(null);
	}

}
