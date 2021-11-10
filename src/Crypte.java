import java.util.Scanner;

public class Crypte {
	
	private int ligneMax, colonneMax;
	private ObjetJeu[][] crypte;
	private Scanner scanner = new Scanner(System.in);
	
	/*
	 * Position du personnage
	 */
	private class Position {
		public int ligne;
		public int colonne;
		public Position(int ligne, int colonne) {
			this.ligne = ligne;
			this.colonne = colonne;
		}
	}
	private Position position;
	
	public Crypte(int ligneMax, int colonneMax) {
		this.ligneMax = ligneMax;
		this.colonneMax = colonneMax;
		this.crypte = new ObjetJeu[this.ligneMax][this.colonneMax];
		this.position = new Position(ligneMax - 1, 0); // Position de départ
	}
	
	/*
	 * Initialiser la crypte
	 * (Ajout du personnage, obstacles et monstres)
	 */
	public void construire(Personnage personnage) {
		int random;
		for (int i = 0; i < this.crypte.length; i++) {
			for (int j = 0; j < this.crypte[i].length; j++) {
				random = ((int) (Math.random() * 5));
				switch (random) {
					case 0:
						crypte[i][j] = new Coffre();
						break;
					case 1:
						crypte[i][j] = new Zombie();
						break;
					case 2:
						crypte[i][j] = new ChauveSouriant();
						break;
					case 3:
						crypte[i][j] = new Rocher();
						break;
					case 4:
						crypte[i][j] = new Magasin();
						break;
				}
			}
		}
		this.crypte[this.ligneMax - 1][0] = personnage;
	}
	
	/*
	 * Afficher la map de la crypte
	 */
	public void afficher() {
		String affichage;
		
		System.out.println("----------------:FIN:");
		for (int i = 0; i < this.crypte.length; i++) {
			affichage = "|";
			for (int j = 0; j < this.crypte[i].length; j++) {
				if (this.crypte[i][j] == null) {
					affichage += "   |";
				} else if (this.crypte[i][j].getClass().getName() == "Humain" 
						|| this.crypte[i][j].getClass().getName() == "Nain"
						|| this.crypte[i][j].getClass().getName() == "Elfe") {
					affichage += " O |";
				} else {
					affichage += " ? |";
				}
			}
			System.out.println(affichage);
			if (i != this.crypte.length - 1) System.out.println("|-------------------|");
		}	
		System.out.println(":DEB:----------------\n");
	}
	
	/*
	 * Afficher le menu pour se déplacer
	 */
	public void seDeplacer(Personnage personnage) {
		int choix = 0;
		int ligne = this.position.ligne;
		int colonne = this.position.colonne;
		System.out.println("1 - Haut\n"
			+ "2 - Bas\n"
			+ "3 - Gauche\n"
			+ "4 - Droite");
		while (choix < 1 || choix > 4) {
			System.out.print("Où veux-tu aller ? ");
			choix = Integer.parseInt(scanner.nextLine());
			System.out.println();
		
			switch (choix) {
				case 1:
					if (this.position.ligne == 0) {
						System.out.println("Attention, il y a un mur !");
						this.seDeplacer(personnage);
						return;
					} else {
						ligne = this.position.ligne - 1;
					}
					break;
				case 2:
					if (this.position.ligne + 1 == this.ligneMax) {
						System.out.println("Attention, il y a un mur !");
						this.seDeplacer(personnage);
						return;
					} else {
						ligne = this.position.ligne + 1;
					}
					break;
				case 3:
					if (this.position.colonne == 0) {
						System.out.println("Attention, il y a un mur !");
						this.seDeplacer(personnage);
						return;
					} else {
						colonne = this.position.colonne - 1;
					}
					break;
				case 4:
					if (this.position.colonne + 1 == this.colonneMax) {
						System.out.println("Attention, il y a un mur !");
						this.seDeplacer(personnage);
						return;
					} else {
						colonne = this.position.colonne + 1;
					}
					break;
				default:
					System.out.println("(1: Haut, 2: Bas, 3: Gauche, 4: Droite)");
					break;
			}
			
			if (this.crypte[ligne][colonne] != null) {
				ObjetJeu contenu = this.crypte[ligne][colonne];
				System.out.println("Il y a un " + contenu.getClass().getName() + " !");
				this.action(contenu, personnage);
				this.deplacer(ligne, colonne, personnage);
			} else {
				System.out.println("Il n'y a rien ici !\n");
				this.deplacer(ligne, colonne, personnage);
			}
		}
	}
	
	/*
	 * Déplacer le personnage
	 */
	public void deplacer(int ligne, int colonne, Personnage personnage) {
		this.crypte[ligne][colonne] = personnage;
		this.crypte[this.position.ligne][this.position.colonne] = null;
		this.position.ligne = ligne;
		this.position.colonne = colonne;
	}
	
	/*
	 * Executer les actions de chaque salle de la crypte
	 */
	public void action(ObjetJeu objetJeu, Personnage personnage) {
		int choix = 0;
		if (objetJeu.getClass().getName() == "Coffre") {
			while (choix < 1 || choix > 2) {
				System.out.println("Veux-tu ouvrir le coffre ?\n"
						+ "1 - Oui\n"
						+ "2 - Non");
				choix = Integer.parseInt(scanner.nextLine());
			}
			
			if (choix == 1) {
				double contenu = ((Coffre) objetJeu).getContenu();
				personnage.ajouterArgent(contenu);
				System.out.println("Tu as gagné " + contenu + " d'argent !\n");
			} else if (choix == 2) {
				System.out.println("Dommage, tu as raté une récompense !\n");
			}
		} else if (objetJeu.getClass().getName() == "Zombie") {
			while (choix < 1 || choix > 2) {
				System.out.println("Veux-tu combattre le zombie ?\n"
						+ "1 - Oui\n"
						+ "2 - Non");
				choix = Integer.parseInt(scanner.nextLine());
			}
			
			if (choix == 1) {
				this.combat((Monstre) objetJeu, personnage);
			} else if (choix == 2) {
				System.out.println("Tu as fui le combat !\n");
			}
		} else if (objetJeu.getClass().getName() == "ChauveSouriant") {
			while (choix < 1 || choix > 2) {
				System.out.println("Veux-tu combattre le chauve souriant ?\n"
						+ "1 - Oui\n"
						+ "2 - Non");
				choix = Integer.parseInt(scanner.nextLine());
			}
			
			if (choix == 1) {
				this.combat((Monstre) objetJeu, personnage);
			} else if (choix == 2) {
				System.out.println("Tu as fui le combat !\n");
			}
		} else if (objetJeu.getClass().getName() == "Rocher") {
			while (choix < 1 || choix > 2) {
				System.out.println("Veux-tu casser le rocher ?\n"
						+ "1 - Oui\n"
						+ "2 - Non");
				choix = Integer.parseInt(scanner.nextLine());
			}
			
			if (choix == 1) {
				this.combat((Rocher) objetJeu, personnage);
			} else if (choix == 2) {
				System.out.println("Tu as fui ce ROCHER !\n");
			}
		} else if (objetJeu.getClass().getName() == "Magasin") {
			while (choix < 1 || choix > 2) {
				System.out.println("Veux-tu rentrer dans la magasin ?\n"
						+ "1 - Oui\n"
						+ "2 - Non");
				choix = Integer.parseInt(scanner.nextLine());
			}
			
			if (choix == 1) {
				((Magasin) objetJeu).afficher(personnage);
			} else if (choix == 2) {
				System.out.println("Tu es parti !\n");
			}
		}
	}
	
	/*
	 * Lancer le combat entre le personnage et le destructible
	 */
	public void combat(Destructible destructible, Personnage personnage) {
		int i = 1;
		while (destructible.getPointsVie() > 0 && personnage.getPointsVie() > 0) {
			System.out.println(i + "e tour !");
			System.out.println("Tu as fait " 
					+ personnage.getMain().attaquer(destructible, personnage.getForce(), personnage.getDexterite())
					+ " de degats !\n"
					+ destructible.getClass().getName() 
					+ " lui reste " + destructible.getPointsVie() + " points de vie.");
			if (destructible.getPointsVie() > 0) {
				if (destructible.getClass().getName() == "Zombie" 
						|| destructible.getClass().getName() == "ChauveSouriant") {
					personnage.degats(((Monstre) destructible).getForce());
					System.out.println(destructible.getClass().getName() + " a fait " 
							+ ((Monstre) destructible).getForce()
							+ " de degats !\n"
							+ "Il te reste " + personnage.getPointsVie() + " points de vie.\n");
				} else {
					System.out.println("...\n...\n");
				}
			} else {
				System.out.println("\nLe " + destructible.getClass().getName() + " ne fait plus partie de ce monde.\n");
				if (destructible.getClass().getName() == "Zombie" 
						|| destructible.getClass().getName() == "ChauveSouriant") {
					personnage.ajouterExp((int) (Math.random() * 21) + 1);
				}
				return;
			}
			i++;
		}
	}
	
	/*
	 * Vérifier si le personnage est arrivé à la fin
	 */
	public boolean fin() {
		if (this.position.ligne == 0 && this.position.colonne == this.colonneMax - 1)
			return true;
		return false;
	}

}
