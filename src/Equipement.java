
public abstract class Equipement {
	
	protected double prix;
	
	protected Equipement(double prix) {
		this.prix = prix;
	}
	
	/*
	 * Retourne l'ascii art de l'arme
	 */
	public abstract String asciiArt();

}
