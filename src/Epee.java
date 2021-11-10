
public class Epee extends Arme {
	
	public Epee() {
		super(7, 0.5); // Prix et dégats
	}

	/*
	 * Retourne l'ascii art de l'arme
	 */
	public String asciiArt() {
		return
		"        \\\n" +
        " _      ||_______________\n" +
        "(_|%|%|%|[_______________>\n" +
        "        ||\n" +
        "         \\";
	}

	/*
	 * Attaquer un destructible
	 * Retourne les degats infligés
	 */
	public double attaquer(Destructible destructible, double force, double dexterite) {
		double degats = this.getDegats() * force + this.getDegats() * dexterite;
		destructible.degats(degats);
		return degats;
	}

}
