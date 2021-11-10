import java.util.Scanner;

public class Jeu {
	
	private Personnage personnage;
	private Crypte crypte;
	private Scanner scanner = new Scanner(System.in);
	
	public Jeu() {
		this.crypte = new Crypte(5, 5); // Taille de la crypte (ligne, colonne)
		System.out.println("Bienvenue sur Crypt'Hunt !\n"
			+ "// Le village de Ch'ha�sseu vient d'�tre br�l� par les monstres de la crypte.\n"
			+ "// En revenant au village, notre h�ros d�couvre l'�tat du village et part explorer la crypte.");
		initPersonnage(); // Initialiser le personnage (nom et race)
		this.crypte.construire(this.personnage);
		menu(); // Afficher le menu principal
	}
	
	/*
	 * Choix du nom et de la race
	 */
	public void initPersonnage() {
		String nom = null;
		int race = 0;
		while (nom == null || nom.isEmpty()) {
			System.out.print("Entre le nom de ton personnage: ");
			nom = scanner.nextLine();
		}
		System.out.println();
		System.out.println("1 - Humain:\n"
				+ "\tPoints de vie: 20\n"
				+ "\tForce: 2\n"
				+ "\tDext�rit�: 1\n"
				+ "\tArgent: 2\n"
			+ "2 - Elfe:\n"
				+ "\tPoints de vie: 18\n"
				+ "\tForce: 1\n"
				+ "\tDext�rit�: 4\n"
				+ "\tArgent: 0\n"
			+ "3 - Nain:\n"
				+ "\tPoints de vie: 25\n"
				+ "\tForce: 3\n"
				+ "\tDext�rit�: 0\n"
				+ "\tArgent: 5");
		while (race < 1 || race > 3) {
			System.out.print("Choisis ta race: ");
			race = Integer.parseInt(scanner.nextLine());
		
			switch (race) {
				case 1:
					this.personnage = new Humain(nom);
					break;
				case 2:
					this.personnage = new Elfe(nom);
					break;
				case 3:
					this.personnage = new Nain(nom);
					break;
				default:
					System.out.println("(1: Humain, 2: Elfe, 3: Nain)");
					break;
			}
		}
		System.out.println("Notre h�ro " + nom + " est un " + personnage.getClass().getName() + " !\n");
	}
	
	/*
	 * Afficher le menu principal
	 */
	public void menu() {
		while (this.personnage.getPointsVie() > 0 && !this.crypte.fin()) {
			int choix = 0;
			this.crypte.afficher(); // Afficher la map
			System.out.println("1 - Se d�placer\n"
				+ "2 - Ouvrir son sac\n"
				+ "3 - Se diagnostiquer");
			while (choix < 1 || choix > 3) {
				System.out.print("Que veux-tu faire ? ");
				choix = Integer.parseInt(scanner.nextLine());
				System.out.println();
			
				switch (choix) {
					case 1:
						this.crypte.seDeplacer(this.personnage); // Afficher le menu pour se d�placer
						break;
					case 2:
						this.personnage.ouvrirSac(); // Afficher le menu du sac (l'inventaire)
						break;
					case 3:
						this.personnage.seDiagnostiquer(); // Afficher les informations du personnage
						break;
					default:
						System.out.println("(1: D�placer, 2: Inventaire, 3: Profil)");
						break;
				}
			}
		}
		if (this.personnage.getPointsVie() > 0) {
			this.gagne();
		} else {
			this.perdu();
		}
	}
	
	/*
	 * Jeu perdu
	 */
	public void perdu() {
		System.out.println("Game Over. Tu es mort !");
	}
	
	/*
	 * Jeu gagn�
	 */
	public void gagne() {
		System.out.println("Bravo. Tu t'es veng� !");
		this.personnage.seDiagnostiquer();
	}

}
