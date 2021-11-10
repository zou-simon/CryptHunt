
public class Coffre extends ObjetJeu {
	
	private double contenu;

	public Coffre() {
		this.contenu = (int) (Math.random() * 7) + 1; // Argent entre 1 et 6
	}
	
	/*
	 * Retourne le contenu du coffre
	 */
	public double getContenu() {
		return this.contenu;
	}

}
