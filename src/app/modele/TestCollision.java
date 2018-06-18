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
		this.cactus1.setX(0); this.cactus2.setY(0);
		this.cactus2.setX(200); this.cactus2.setY(200);
		
		assertFalse("cactus 1 va vers le haut personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 0, 1));
		assertFalse("cactus 1 va vers le bas personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 1, 1));
		assertFalse("cactus 1 va vers la gauche personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 2, 1));
		assertFalse("cactus 1 va vers la droite personne", this.gestionCollision.collisionnePerso(cactus1, cactus2, 3, 1));
	}
	
	@Test
	public void testEstUnObstacle() {
		this.cactus1.setX(0); this.cactus2.setY(0);
		this.cactus2.setX(200); this.cactus2.setY(200);
		
		
		
		
		this.cactus1.setX(0); this.cactus2.setY(0);
		this.cactus2.setX(200); this.cactus2.setY(200);
		
		
		
		
		this.cactus1.setX(0); this.cactus2.setY(0);
		this.cactus2.setX(200); this.cactus2.setY(200);
		
		
		
		
		this.cactus1.setX(0); this.cactus2.setY(0);
		this.cactus2.setX(200); this.cactus2.setY(200);
		
		
		
		
	}
	
	
	
}
