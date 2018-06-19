package app.modele;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestCollision {

	/*private Cactus cactus1 = new Cactus("essai1", 1, 0, 0);
	private Cactus cactus2 = new Cactus("essai2", 1, 0, 0);*/
	
	private Cactus cactusObstacle = new Cactus("essai3", 1, 0, 0);
	
	private GestionCollision gestionCollision = new GestionCollision();
	
	//collision avec objet sur map
	@Test
	public final void testAucuneCollisionObstacle() {
		this.cactusObstacle.setX(96); this.cactusObstacle.setY(96);
		
		assertFalse("vers le haut aucun obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX(), this.cactusObstacle.getY() - 1) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX(), this.cactusObstacle.getY() - 1));
		
		assertFalse("vers le bas aucun obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX(), this.cactusObstacle.getY() + 1 + this.cactusObstacle.getTailleY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX(), this.cactusObstacle.getY() + 1 + this.cactusObstacle.getTailleY()));
		
		assertFalse("vers la gauche aucun obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() - 1, this.cactusObstacle.getY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() - 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY())
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() - 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY()/2));
		
		assertFalse("vers la droite aucun obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + 1 + this.cactusObstacle.getTailleX(), this.cactusObstacle.getY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX() + 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX() + 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY()/2));	
	}
	
	@Test
	public final void testCollisionObstacle() {
		this.cactusObstacle.setX(96); this.cactusObstacle.setY(96);
		assertTrue("vers le haut obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX(), this.cactusObstacle.getY() - 1) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX(), this.cactusObstacle.getY() - 1));
		
		this.cactusObstacle.setX(96); this.cactusObstacle.setY(96);
		assertTrue("vers le bas obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX(), this.cactusObstacle.getY() + 1 + this.cactusObstacle.getTailleY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX(), this.cactusObstacle.getY() + 1 + this.cactusObstacle.getTailleY()));
		
		this.cactusObstacle.setX(96); this.cactusObstacle.setY(96);
		assertTrue("vers la gauche obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() - 1, this.cactusObstacle.getY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() - 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY())
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() - 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY()/2));
		
		this.cactusObstacle.setX(96); this.cactusObstacle.setY(96);
		assertTrue("vers la droite obstacle", this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + 1 + this.cactusObstacle.getTailleX(), this.cactusObstacle.getY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX() + 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY()) 
				|| this.gestionCollision.collisionneObstacle(this.cactusObstacle.getX() + this.cactusObstacle.getTailleX() + 1, this.cactusObstacle.getY() + this.cactusObstacle.getTailleY()/2));	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//collision entre personnages
	@Test
	public final void testAucuneCollision() {
		//cas ou ils sont eloignes
		/*this.cactus1.setX(0); this.cactus2.setY(0);
		this.cactus2.setX(200); this.cactus2.setY(200);
		assertFalse("cactus 1 va vers le haut personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		assertFalse("cactus 1 va vers le bas personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		assertFalse("cactus 1 va vers la gauche personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		assertFalse("cactus 1 va vers la droite personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));
		
		//cas limites (au pixel pres)
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(177);
		assertFalse("cactus 1 va vers le haut limite obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(239);
		assertFalse("cactus 1 va vers le bas limite obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(210); this.cactus2.setY(208);
		assertFalse("cactus 1 va vers la gauche limite obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(238); this.cactus2.setY(208);
		assertFalse("cactus 1 va vers la droite limite obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));*/
	}

	@Test
	public final void testEstUnObstacle() {

	/*	//cas coordonnees inferieurs (donc entre 'dans' l'autre ennemi)
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(178);
		assertTrue("cactus 1 va vers le haut obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(238);
		assertTrue("cactus 1 va vers le bas obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(211); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la gauche obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(237); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la droite obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));
		
		
		//cas coordonnees a la limite
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(179);
		assertTrue("cactus 1 va vers le haut obstacle x=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(237);
		assertTrue("cactus 1 va vers le bas obstacle x=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(212); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la gauche obstacle y=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		
		this.cactus1.setX(224); this.cactus1.setY(208);
		this.cactus2.setX(236); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la droite obstacle y=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));*/
	}

}
