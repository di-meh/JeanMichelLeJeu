package app.modele;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class JeanMichel extends Personnage{

	private ArrayList<Arme> inventaireArmes;

	private Arme equipee;

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

	public Arme getArmeEquipee() {
		return equipee;
	}

	public void setArme(Arme equipee) {
		this.equipee = equipee;
	}

	public void estAttaque(int atq) {
		this.pointsVie.setValue(getPointsVie() - atq);
	}


	public Jeu getJeu() {
		return this.jeu.getJeu();

	}

	public void setJeu(Jeu j) {
		this.jeu = j;
		
	}

	public int parler() {
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		
		String menuParler = "1. Oui \n"
				+ "2. Non \n"
				+ "3. J'ai pas compris \n"
				+ "4. Au revoir";
		
		while (menu < 5) {
			
			System.out.println(menuParler);
			System.out.println();
			
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1: System.out.println("Oui");
			return 1;
			case 2: System.out.println("Non");
			return 2;
			case 3: System.out.println("Pas compris");
			return 3;
			case 4: System.out.println("Au revouir");
			return 4;
			}
		}
		sc.close();
		return 5;
	}
	
}






