
public class Poing extends Arme {

	public Poing() {
		super(0, 1); // Prix et dégats
	}
	
	public String asciiArt() { return null; }

	/*
	 * Attaquer un destructible
	 * Retourne les degats infligés
	 */
	public double attaquer(Destructible destructible, double force, double dexterite) {
		double degats = this.getDegats();
		destructible.degats(degats);
		return degats;
	}
	
}
