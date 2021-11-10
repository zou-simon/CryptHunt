
public class Arc extends Arme {
	
	public Arc() {
		super(10, 2); // Prix et dégats
	}
	
	/*
	 * Retourne l'ascii art de l'arme
	 */
	public String asciiArt() {
		return
		"   (		\n" +
		"    \\		\n" +
		"     )		\n" +
		"##-------->\n" +
		"     )		\n" +
		"    /		\n" +
		"   (";
	}

	/*
	 * Attaquer un destructible
	 * Retourne les degats infligés
	 */
	public double attaquer(Destructible destructible, double force, double dexterite) {
		double degats = this.getDegats() * dexterite;
		destructible.degats(degats);
		return degats;
	}

}
