
public abstract class Potion extends Equipement {
	
	public Potion(double prix) {
		super(prix);
	}
	
	/*
	 * Utiliser la potion
	 */
	public abstract void boire(Personnage personnage);

}
