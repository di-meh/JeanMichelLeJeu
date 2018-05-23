package app.modele;

public class Arme {
	
	private String nom;
	
	private boolean estDansSaZone;
	
	private int degatDansZone;
	
	private int degatHorsZone;

	public Arme(String n, boolean z, int dz, int hz) {
		this.nom = n;
		this.estDansSaZone = z;
		this.degatDansZone = dz;
		this.degatDansZone = hz;
	}


	public final String getNom() {
		return this.nom;
	}

	public final boolean getZoneAdapt() {
		return this.estDansSaZone;
	}

	public final int getDegat() {
		if(this.estDansSaZone)
			return this.degatDansZone;
		return this.degatHorsZone;
	}

}
