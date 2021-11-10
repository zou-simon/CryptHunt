import java.util.Scanner;

public class Personnage extends ObjetJeu {
	
	private Equipement[] sac;
	private String nom;
	private double pointsVie;
	private double pointsVieMax;
	private double force;
	private double dexterite;
	private double argent;
	private int niveau = 0;
	private double exp = 0;
	private Arme main; // Arme dans la main
	private Scanner scanner = new Scanner(System.in);
	
	public Personnage(String nom, double pointsVie, double force, double dexterite, double argent) {
		this.sac = new Equipement[3];
		this.nom = nom;
		this.pointsVie = pointsVie;
		this.pointsVieMax = pointsVie;
		this.force = force;
		this.dexterite = dexterite;
		this.argent = argent;
		this.main = new Poing();
	}
	
	/*
	 * Retourne les points de vie du personnage
	 */
	public double getPointsVie() {
		return this.pointsVie;
	}
	
	/*
	 * Soigner le personnage
	 */
	public void soigner(double pointsVie) {
		if (this.pointsVie + pointsVie < this.pointsVieMax) {
			this.pointsVie += pointsVie;
		} else {
			this.pointsVie = this.pointsVieMax;
		}
	}
	
	/*
	 * Degats sur le personnage
	 */
	public void degats(double points) {
		if (this.pointsVie - points > 0) {
			this.pointsVie -= points;
		} else {
			this.pointsVie = 0;
		}
	}
	
	/*
	 * Ajouter un nouveau equipement dans son sac
	 * Ne prend pas en compte l'équipement dans la main
	 */
	public boolean ajouterEquipement(Equipement equipement) {
		int place = 0; // Nombre de place dans le sac
		int i = 0;
		while (i < this.sac.length) {
			if (this.sac[i] == null) {
				place++;
			}
			i++;
		}
		if (place == 0) {
			int choix = 0;
			int choixEquipement = 0;
			System.out.println("Le sac est plein !\n\n"
					+ "1 - Remplacer l'équipement\n"
					+ "2 - Jeter l'équipement");
			while (choix < 1 || choix > 2) {
				System.out.print("Que veux-tu faire ? ");
				choix = Integer.parseInt(scanner.nextLine());
				System.out.println();
				
				if (choix == 1) {
					for (i = 0; i < this.sac.length; i++) {
						System.out.println((i + 1) + "e poche: " + this.sac[i].getClass().getName());
						System.out.println(this.sac[i].asciiArt());
					}
					while (choixEquipement < 1 || choixEquipement > 3) {
						System.out.print("Quelle poche remplacer (1e, 2e ou 3e) ? ");
						choixEquipement = Integer.parseInt(scanner.nextLine());
					}
					System.out.println("Tu as remplacé l'équipement " 
							+ this.sac[choixEquipement - 1].getClass().getName()
							+ " par " + equipement.getClass().getName() + ".");
					this.sac[choixEquipement - 1] = equipement;
				} else if (choix == 2) {
					System.out.println("Tu as jeté l'équipement acheté.\n");
					return false;
				} else {
					System.out.println("(1: Remplacer, 2: Jeter)");
				}
			}
			System.out.println();
		} else {
			i = 0;
			while (i < this.sac.length) {
				if (this.sac[i] == null) {
					this.sac[i] = equipement;
					return true;
				}
				i++;
			}
		}
		return true;
	}
	
	/*
	 * Afficher son sac, avec des options 
	 * (Prendre une arme dans la main, Boire une potion, Jeter un équipement et Fermer son sac) 
	 */
	public void ouvrirSac() {
		while (true) {
			for (int i = 0; i < this.sac.length; i++) {
				System.out.print((i + 1) + "e poche: ");
				if (this.sac[i] != null) {
					System.out.println(this.sac[i].getClass().getName());
					System.out.println(this.sac[i].asciiArt());
				} else {
					System.out.println("Vide");
				}
			}
			System.out.println();
		
			int choix = 0;
			int choixEquipement = 0;
			System.out.println("1 - Prendre une arme dans la main\n"
				+ "2 - Boire une potion\n"
				+ "3 - Jeter un équipement\n"
				+ "4 - Fermer son sac");
			while (choix < 1 || choix > 4) {
				System.out.print("Que veux-tu faire ? ");
				choix = Integer.parseInt(scanner.nextLine());
				System.out.println();
				
				if (choix > 0 && choix < 4) {
					while (choixEquipement < 1 || choixEquipement > 3) {
						System.out.print("Quelle poche (1e, 2e ou 3e) ? ");
						choixEquipement = Integer.parseInt(scanner.nextLine());
					}
					Equipement equipement = this.sac[choixEquipement - 1];
					if (equipement == null) { // Vérifier s'il y a un équipement
						System.out.println("Il n'y a rien dans la " + choixEquipement + "e poche.");
					} else {
						if (choix == 1) {
							if (equipement.getClass().getName() == "PotionSoin") { // Vérifier si c'est une potion de soin
								System.out.println("Tu ne peux pas te défendre avec une potion !");
							} else if (equipement.getClass().getName() == "Arc" ||
									equipement.getClass().getName() == "Hache" ||
									equipement.getClass().getName() == "Epee") { // Vérifier si c'est une arme
								if (this.main.getClass().getName() != "Poing") { // Vérifier s'il y a une arme dans la main
									this.sac[choixEquipement - 1] = this.main; // Remettre l'arme dans le sac
								} else {
									this.sac[choixEquipement - 1] = null;
								}
								this.main = (Arme) equipement; // Equiper l'arme
								System.out.println("Tu as pris l'" + equipement.getClass().getName() + " dans la main.");
							}
						} else if (choix == 2) {
							if (equipement.getClass().getName() == "Arc" ||
									equipement.getClass().getName() == "Hache" ||
									equipement.getClass().getName() == "Epee") { // Vérifier si c'est une potion de soin
								System.out.println("Tu ne peux pas te boire une arme !");
							} else if (equipement.getClass().getName() == "PotionSoin") { // Vérifier si c'est une arme
								PotionSoin potion = (PotionSoin) equipement;
								potion.boire(this);
								this.sac[choixEquipement - 1] = null;
								System.out.println("Tu as bu la potion de soin. Points de vie: " + this.pointsVie + "/" + this.pointsVieMax);
							}
						} else if (choix == 3) {
							this.sac[choixEquipement - 1] = null;
							System.out.println("Tu as jeté l'équipement de la " + choixEquipement + "e poche.");
						}
					}
				} else if (choix == 4) {
					return;
				} else {
					System.out.println("(1: Prendre, 2: Boire, 3: Jeter)");
				}
			}
			System.out.println();
		}
		
	}
	
	/*
	 * Ajouter de l'expérience au personnage
	 * A chaque 10 points d'exp le personnage, augmente de niveau, force et dexterite
	 */
	public void ajouterExp(double exp) {
		int i = 0;
		this.exp += exp;
		while (this.exp >= 10) {
			this.niveau++;
			this.exp -= 10;
			this.force++;
			this.dexterite++;
			i++;
		}
		if (i > 0) {
			System.out.println("Tu as gagné " + i + " niveau(x) !\n"
					+ "+ " + i + " Force\n"
					+ "+ " + i + " Dextérité\n");
		}
	}
	
	/*
	 * Afficher les informations du personnage
	 * (Race, Nom, Points de vie, Force, Dextérité, Argent, Niveau et Arme s'il en a une dans la main)
	 */
	public void seDiagnostiquer() {
		System.out.print("\t[" + this.getClass().getName() + "] " + this.nom + "\n"
					+ "\tPoints de vie: " + this.pointsVie + "/" + this.pointsVieMax + "\n"
					+ "\tForce: " + this.force + "\n"
					+ "\tDextérité: " + this.dexterite + "\n"
					+ "\tArgent: " + this.argent + "\n"
					+ "\tNiveau: " + this.niveau + " (" + this.exp + "/10)\n");
		if (this.main != null) {
			System.out.println("\tArme dans la main: " + this.main.getClass().getName() + "\n");
		} else {
			System.out.println();
		}
	}
	
	/*
	 * Retourne la quantité d'argent du personnage
	 */
	public double getArgent() {
		return this.argent;
	}
	
	/*
	 * Ajouter de l'argent au personnage
	 */
	public void ajouterArgent(double argent) {
		this.argent += argent;
	}
	
	/*
	 * Retirer l'argent au personnage
	 */
	public boolean retirerArgent(double argent) {
		if (this.argent - argent >= 0) {
			this.argent -= argent;
			return true;
		} else {
			System.out.println("Tu n'as pas assez d'argent pour acheter cet équipement.\n"
					+ "Il te manque " + Math.abs(this.argent - argent) + " d'argent pour l'acheter.\n");
			return false;
		}
	}
	
	/*
	 * Retourne l'arme dans la main
	 */
	public Arme getMain() {
		return this.main;
	}
	
	/*
	 * Retourne la force du personnage
	 */
	public double getForce() {
		return this.force;
	}
	
	/*
	 * Retourne la dextérité du personnage
	 */
	public double getDexterite() {
		return this.dexterite;
	}
	
}
