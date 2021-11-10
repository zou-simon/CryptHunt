
public class PotionSoin extends Potion {
	
	public PotionSoin() {
		super(6); // Prix
	}

	/*
	 * Retourne l'ascii art de la potion
	 */
	public String asciiArt() {
		return 
		"      _____\r\n"
		+ "     `.___,'\r\n"
		+ "      (___)\r\n"
		+ "      <   >\r\n"
		+ "       ) (\r\n"
		+ "      /`-.\\\r\n"
		+ "     /     \\\r\n"
		+ "    / _    _\\\r\n"
		+ "   :,' `-.' `:\r\n"
		+ "    \\       /\r\n"
		+ "     `.___.'\r\n";
	}

	/*
	 * Utiliser la potion
	 */
	public void boire(Personnage personnage) {
		personnage.soigner(10); // Soigne le personnage de 10 points de vie
	}

}
