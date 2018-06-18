package app.modele;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestCollision {

	private Cactus cactus1 = new Cactus("essai1", 1, 0, 0);
	private Cactus cactus2 = new Cactus("essai2", 1, 0, 0);
	
	private GestionCollision gestionCollision = new GestionCollision();
	
	//test collision entre les personnages
	@Test
	public void testAucuneCollision() {
		//cas ou ils sont eloignes
		this.cactus1.setX(0); this.cactus2.setY(0);
		this.cactus2.setX(200); this.cactus2.setY(200);
		assertFalse("cactus 1 va vers le haut personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		assertFalse("cactus 1 va vers le bas personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		assertFalse("cactus 1 va vers la gauche personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		assertFalse("cactus 1 va vers la droite personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));
		
		//cas limites (au pixel pres)
/*pb*/		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(178);
		assertFalse("cactus 1 va vers le haut obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(238);
		assertTrue("cactus 1 va vers le bas obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(211); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la gauche obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(237); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la droite obstacle", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));
	}

	@Test
	public void testEstUnObstacle() {

		//cas coordonnees a la limite
/*pb*/		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(179);
		assertFalse("cactus 1 va vers le haut obstacle x=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(237);
		assertTrue("cactus 1 va vers le bas obstacle x=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(212); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la gauche obstacle y=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(236); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la droite obstacle y=", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));
		
		
		//cas coordonnees inferieurs (donc 'dans' l'autre ennemi)
/*pb*/		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(180);
		assertFalse("cactus 1 va vers le haut obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(224); this.cactus2.setY(236);
		assertTrue("cactus 1 va vers le bas obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(211); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la gauche obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		
		this.cactus1.setX(224); this.cactus2.setY(208);
		this.cactus2.setX(235); this.cactus2.setY(208);
		assertTrue("cactus 1 va vers la droite obstacle <", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));
	}

}
