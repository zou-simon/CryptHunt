
public class Hache extends Arme {
	
	public Hache() {
		super(10, 2); // Prix et dégats
	}

	/*
	 * Retourne l'ascii art de l'arme
	 */
	public String asciiArt() {
		return
		"  ,  /\\  .  \r\n"
		+ " //`-||-'\\\\ \r\n"
		+ "(| -=||=- |)\r\n"
		+ " \\\\,-||-.// \r\n"
		+ "  `  ||  '  \r\n"
		+ "     ||     \r\n"
		+ "     ||     \r\n"
		+ "     ||     \r\n"
		+ "     ||     \r\n"
		+ "     ()";
	}

	/*
	 * Attaquer un destructible
	 * Retourne les degats infligés
	 */
	public double attaquer(Destructible destructible, double force, double dexterite) {
		double degats = this.getDegats() * force;
		destructible.degats(degats);
		return degats;
	}
}
