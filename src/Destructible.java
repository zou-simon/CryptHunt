
public class Destructible extends ObjetJeu {
	
	private double pointsVie;
	
	public Destructible(double pointsVie) {
		this.pointsVie = pointsVie;
	}
	
	/*
	 * Degats sur le destructible
	 */
	public void degats(double points) {
		if (this.pointsVie - points > 0) {
			this.pointsVie -= points;
		} else {
			this.pointsVie = 0;
		}
	}
	
	/*
	 * Retourne les points de vie du destructible
	 */
	public double getPointsVie() {
		return this.pointsVie;
	}

}
