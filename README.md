# Mini-projet : CryptHunt
 
Jeu RPG basé sur une interaction textuelle en Java.

### Histoire : 
*Le village de Ch'haïsseu vient d'être brûlé par des monstres de la crypte.<br>
En revenant d'une séance de coupe de bois, notre héros dont la race peut être choisie, va explorer la crypte pour les tuer.*

### Les consignes : 

- Des menus de choix s’affichent sur la console
- L’utilisateur choisit une action en tapant au clavier (Java: classe Scanner)
- On doit créer son Personnage (nom, propriétés, argent, XP, mana)
	- Celui-ci peut-être choisi parmis un ensemble de castes (Sorcier, Elfe, ...)
	- Chaque type possède des caractéristiques différentes
- Le système de jeu permet:
	- D’acheter des armes dans un magasin
	- Changer son inventaire (équipement, à minima les armes)
	- Se déplacer sur une carte virtuelle (matrice 2D): avant, arrière, gauche, droite
		- Le joueur commence en bas à gauche et doit arriver en haut à droite
		- Cette carte contient aléatoirement des monstres et obstacles
		- Lors de la rencontre avec des objets, on peut choisir de combattre ou fuir
		- Système de combat aléatoire donnant des points d’XP

### Les races :

|        | Vie | Force | Dextérité |
|:------:|:---:|:-----:|:---------:|
| Humain |  25 |   3   |     0     |
|  Elfe  |  18 |   1   |     4     |
|  Nain  |  20 |   2   |     1     |

### Les équipements :

|       | Prix |             Degats            |
|:-----:|:----:|:-----------------------------:|
|  Epée |   7  | 0,5 * Force + 0,5 * Dextérité |
| Hache |  10  |           2 * Force           |
|  Arc  |  10  |         2 * Dextérité         |

|                | Prix |          Effet          |
|:--------------:|:----:|:-----------------------:|
| Potion de soin |   6  | Soigne 10 points de vie |

### Les monstres :

|                 | Points de vie | Force |
|:---------------:|:-------------:|:-----:|
|      Zombie     |    12 - 16    |   2   |
| Chauve Souriant |     8 - 11    |   1   |

- Les coffres contient aléatoirement un montant de 1 à 6.
- Les rochers ont des points de vie entre 1 et 4.
- Les degats de base sans arme sont de 1.
- Chaque niveau est sur 10 points d'expérience.
- Un niveau rapporte une force et une dextérité en plus.
- Chaque fin de combat le personnage gagne entre 1 et 20 points d'expérience.

> LP Projet Web 2021-2022