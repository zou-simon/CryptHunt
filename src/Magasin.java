import java.util.Scanner;

public class Magasin extends ObjetJeu {
	
	private Scanner scanner = new Scanner(System.in);
	
	/*
	 * Afficher la boutique
	 */
	public void afficher(Personnage personnage) {
		System.out.println("Bienvenue dans la magasin !");
		while (true) {
			int choix = 0;
			System.out.println("Argent: " + personnage.getArgent() + "\n"
				+ "1 - Epée (Prix 7)\n"
				+ "2 - Hache (Prix 10)\n"
				+ "3 - Arc (Prix 10)\n"
				+ "4 - Potion de soin (Prix 6)\n"
				+ "5 - Sortir du magasin");
			while (choix < 1 || choix > 5) {
				System.out.print("Que veux-tu acheter ? ");
				choix = Integer.parseInt(scanner.nextLine());
				System.out.println();
			
				switch (choix) {
					case 1:
						if (personnage.retirerArgent(7)) {
							if (personnage.ajouterEquipement(new Epee())) {
								System.out.println("Tu as acheté une Epee !\n"
									+ "N'oublie pas de le prendre en main, il est dans ton sac.\n");
							}
						}
						break;
					case 2:
						if (personnage.retirerArgent(10)) {
							if (personnage.ajouterEquipement(new Hache())) {
								System.out.println("Tu as acheté une Hache !\n"
									+ "N'oublie pas de le prendre en main, il est dans ton sac.\n");
							}
						}
						break;
					case 3:
						if (personnage.retirerArgent(10)) {
							if (personnage.ajouterEquipement(new Arc())) {
								System.out.println("Tu as acheté une Arc !\n"
									+ "N'oublie pas de le prendre en main, il est dans ton sac.\n");
							}
						}
						break;
					case 4:
						if (personnage.retirerArgent(6)) {
							if (personnage.ajouterEquipement(new PotionSoin())) {
								System.out.println("Tu as acheté une Potion de soin !\n"
									+ "Il est dans ton sac.\n");
							}
						}
						break;
					case 5:
						System.out.println("Tu es sorti du magasin !\n");
						return;
					default:
						System.out.println("(1: Epée, 2: Hache, 3: Arc, 4: Potion de soin)");
						break;
				}
			}
		}
	}
	
}
