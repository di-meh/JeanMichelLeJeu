package app.modele;

public class GestionCollision {
	private Terrain map;
	
	public GestionCollision(Terrain t) {
		this.map = t;
	}
	
	public boolean peutSeDéplacer() {
		
		/*
		 * Ebauche du code
		 * 
		 * if (map.getTab2d()[positionXPerso/map.getTailleTab()][positionYPerso/map.getTailleTab()] > numéro donné aux obstacles)
		 * 	return true;	il peut donc avancer
		 * else return false;	dans ce cas là, il ne peut pas avancer.
		 * 
		 * Il faudrait vérifier le pixel de chaque coin du sprite du personnage et le comparer avec chaque case de la matrice.
		 * 
		 * Cela signifierait donc faire un if pour chacun de ces pixels
		 * 
		 * 
		 * 
		 */
		return true;
	}
}
