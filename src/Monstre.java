
public class Monstre extends Destructible {
	
	private double force;

	public Monstre(double pointsVie, double force) {
		super(pointsVie);
		this.force = force;
	}
	
	/*
	 * Retourne la force du monstre
	 */
	public double getForce() {
		return this.force;
	}

}
