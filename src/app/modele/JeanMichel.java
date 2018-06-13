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
		case Z: if(!this.collision.collisionne(getX(), getY() - 4) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY()-4) 
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 0, 4))
			haut();
		break;
		case Q: if(!this.collision.collisionne(getX() - 4, getY()) 
				&& !this.collision.collisionne(getX() - 4, getY()+getTailleY()) 
				&& !this.collision.collisionne(getX() - 4, getY()+getTailleY()/2) 
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 1, 4))
			gauche();
		break;
		case S: if(!this.collision.collisionne(getX(), getY() + 4 + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX(), getY() + 4 + getTailleY()) 
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 2, 4))
			bas();
		break;
		case D: if(!this.collision.collisionne(getX() + 4 + getTailleX(), getY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()) 
				&& !this.collision.collisionne(getX() + getTailleX() + 4, getY() + getTailleY()/2) 
				&& !this.collision.collisionPerso(this.jeu.getEnnemis().get(0), this, 3, 4))
			droite();
		break;
		case E: System.out.println("Button E pressed"); //attaquer
		break;
		case F: System.out.println("Button F pressed");//pousser/tirer
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

	public Arme getArmeEquipee() {
		return equipee;
	}

	public void setArme(Arme equipee) {
		this.equipee = equipee;
	}

	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie() - atq);
	}

	
}

