package app.modele;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class JeanMichel extends Personnage{

	private ArrayList<Item> inventaire;

	private Jeu jeu;

	public JeanMichel(int x, int y) {
		super("Jean-Michel", 5, x, y, 17, 23);
		this.inventaire = new ArrayList<>();
	}

	public void action(KeyEvent e) {
		
		KeyCode value = e.getCode();

		switch(value) {
		case Z: 
			if(!this.collision.collisionneObstacle(getX(), getY() - 4) 
			&& !this.collision.collisionneObstacle(getX() + getTailleX(), getY()-4) 
			&& !this.collision.collisionnePerso(ennemiACote(), this, 0, 4))
				haut();
			break;
		case Q: 
			if(!this.collision.collisionneObstacle(getX() - 4, getY()) 
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
			if(this.collision.collisionnePerso(ennemiACote(), this, 0, 4) 
			|| this.collision.collisionnePerso(ennemiACote(), this, 1, 4)
			|| this.collision.collisionnePerso(ennemiACote(), this, 2, 4)
			|| this.collision.collisionnePerso(ennemiACote(), this, 3, 4))
				this.attaquer(ennemiACote());
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

	public void attaquer(Personnage en) { 
		if (en != null)
			en.estAttaque(1);
	}

	public Jeu getJeu() {
		return this.jeu;

	}

	public void setJeu(Jeu j) {
		this.jeu = j;
	}

	public Ennemi ennemiACote() {
		for (Ennemi e : jeu.getEnnemis()) {
				if(e.caseX() == this.caseX() && e.caseY()== this.caseY() 
				|| e.caseX() == this.caseX() + 1 && e.caseY()== this.caseY() + 1
				|| e.caseX() == this.caseX() - 1 && e.caseY()== this.caseY() - 1 
				|| e.caseX() == this.caseX() + 1 && e.caseY()== this.caseY()
				|| e.caseX() == this.caseX() && e.caseY()== this.caseY() + 1 
				|| e.caseX() == this.caseX() - 1 && e.caseY()== this.caseY()
				|| e.caseX() == this.caseX() && e.caseY()== this.caseY() - 1
				|| e.caseX()==this.caseX()+1 && e.caseY()== this.caseY()-1
				|| e.caseX()==this.caseX()-1 && e.caseY()== this.caseY()+1)
				return e;			
		}
		return null;
	}

	public ArrayList<Item> getInventaire() {
		return this.inventaire;
	}

}
