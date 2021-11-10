# Mini-projet : CryptHunt
 
Jeu RPG bas� sur une interaction textuelle en Java.

### Histoire : 
*Le village de Ch'ha�sseu vient d'�tre br�l� par des monstres de la crypte.<br>
En revenant d'une s�ance de coupe de bois, notre h�ros dont la race peut �tre choisie, va explorer la crypte pour les tuer.*

### Les consignes : 

- Des menus de choix s�affichent sur la console
- L�utilisateur choisit une action en tapant au clavier (Java: classe Scanner)
- On doit cr�er son Personnage (nom, propri�t�s, argent, XP, mana)
	- Celui-ci peut-�tre choisi parmis un ensemble de castes (Sorcier, Elfe, ...)
	- Chaque type poss�de des caract�ristiques diff�rentes
- Le syst�me de jeu permet:
	- D�acheter des armes dans un magasin
	- Changer son inventaire (�quipement, � minima les armes)
	- Se d�placer sur une carte virtuelle (matrice 2D): avant, arri�re, gauche, droite
		- Le joueur commence en bas � gauche et doit arriver en haut � droite
		- Cette carte contient al�atoirement des monstres et obstacles
		- Lors de la rencontre avec des objets, on peut choisir de combattre ou fuir
		- Syst�me de combat al�atoire donnant des points d�XP

### Les races :

|        | Vie | Force | Dext�rit� |
|:------:|:---:|:-----:|:---------:|
| Humain |  25 |   3   |     0     |
|  Elfe  |  18 |   1   |     4     |
|  Nain  |  20 |   2   |     1     |

### Les �quipements :

|       | Prix |             Degats            |
|:-----:|:----:|:-----------------------------:|
|  Ep�e |   7  | 0,5 * Force + 0,5 * Dext�rit� |
| Hache |  10  |           2 * Force           |
|  Arc  |  10  |         2 * Dext�rit�         |

|                | Prix |          Effet          |
|:--------------:|:----:|:-----------------------:|
| Potion de soin |   6  | Soigne 10 points de vie |

### Les monstres :

|                 | Points de vie | Force |
|:---------------:|:-------------:|:-----:|
|      Zombie     |    12 - 16    |   2   |
| Chauve Souriant |     8 - 11    |   1   |

- Les coffres contient al�atoirement un montant de 1 � 6.
- Les rochers ont des points de vie entre 1 et 4.
- Les degats de base sans arme sont de 1.
- Chaque niveau est sur 10 points d'exp�rience.
- Un niveau rapporte une force et une dext�rit� en plus.
- Chaque fin de combat le personnage gagne entre 1 et 20 points d'exp�rience.

> LP Projet Web 2021-2022