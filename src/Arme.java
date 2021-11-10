
public abstract class Arme extends Equipement {
	
	private double degats;
	
	public Arme(double prix, double degats) {
		super(prix);
		this.degats = degats;
	}
	
	/*
	 * Retourne les degats de l'arme
	 */
	public double getDegats() {
		return this.degats;
	}
	
	/*
	 * Attaquer un destructible
	 * Retourne les degats infligés
	 */
	public abstract double attaquer(Destructible destructible, double force, double dexterite);

}
