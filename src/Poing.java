
public class Poing extends Arme {

	public Poing() {
		super(0, 1); // Prix et d�gats
	}
	
	public String asciiArt() { return null; }

	/*
	 * Attaquer un destructible
	 * Retourne les degats inflig�s
	 */
	public double attaquer(Destructible destructible, double force, double dexterite) {
		double degats = this.getDegats();
		destructible.degats(degats);
		return degats;
	}
	
}
