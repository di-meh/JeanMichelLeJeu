## Map:
La map du jeu est d'abord créée sur le logiciel Tiled, un logiciel permettant de créer des maps faites de tuiles (ou tiles).
Cette map est ensuite exportée dans un fichier XML, dont la suite de nombres est copiée dans un fichier texte, avec un fichier texte différent par couche créée sur Tiled.
Un BufferedReader pour ce fichier texte dans la classe Terrain est utilisé pour convertir cette suite de nombres en un tableau d'entiers à deux dimensions.
Ce tableau est ensuite utilisé par la classe VueTerrain pour :
	1. affecter à chaque valeur du tableau une image placée dans le dossier app/img.
	2. créer un ImageView qui contiendra l'image précédemment créée.
	3. ajouter ces ImageView dans un TilePane.
Ce procédé est le meme pour la couche des obstacles.


## Collision:

Pour gérer les collisions de manière générale, nous avons créé une classe GestionCollision.
Elle a comme attributs un Terrain et une ArrayList d'entiers servant à stocker tous les nombres provenant du fichier texte contenant les id des obstacles.
Dans le constructeur de GestionCollision, la liste est d'abord remplie de tous les nombres excepté 0, sans prendre compte des doublons.
Ensuite, on utilise un Set d'Integer comme "pivot" : le Set n'acceptant pas les doublons, on le remplit de tous les éléments de la liste.
Enfin, après avoir vidé toute la liste, on la reremplit de tous les éléments du Set. Cela permet de conserver de la mémoire.

Chaque personnage a en attribut la classe GestionCollision.
Voyons comment sont gérées les collisions : 


### Avec obstacles:
Si l'id devant le personnage sur la map appartient a la liste d'obstacles alors il ne peut avancer.
Pour vérifier s'il y a collision, on utilise une méthode collisionneObstacle prenant en paramètre une position x et y, et renvoyant un booléen.
Elle appelle deux méthodes en meme temps: estObstacle et caseDe.
La méthode estObstacle prend en paramètre un int, le compare avec la liste d'obstacles et renvoie true dans le cas où il se trouve bel et bien dans la liste.
Quant à la méthode caseDe, elle prend aussi en paramètre un int x et y, et renvoie un int.
Elle renvoie la valeur de la case "[y/16][x/16]" du tableau d'obstacles du Terrain en attribut.

La méthode collisionneObstacle est appelée à chaque fois que Jean-Michel ou un ennemi veut se déplacer.


### Entre personnages:
Dans la théorie, le principe de vérification est le meme, mais en pratique, le procédé est totalement différent.

La méthode appelée est collisionnePerso, prenant en paramètre deux Personnages, un int représentant la direction, et un autre représentant la distance parcourue à chaque pas.
En fonction de la direction, la méthode vérifie, prenant les deux memes Personnages et deux int de position en paramètre, détermine si le personnage se trouve dans le "carré" occupé par le deuxième personnage, en appelant la méthode pointDansCarré, qui ne prend qu'un Personnage et deux int de position en paramètre.

Tout comme la méthode collisionneObstacle, la méthode collisionnePerso est aussi appelée à chaque fois que Jean-Michel ou un ennemi veut se déplacer.


## Se déplacer:

### Jean-Michel:
Jean-Michel, contrairement à ses ennemis, se déplace de 4 pixels à chaque pas, au lieu d'1 pixel.
A chaque fois que Jean-Michel souhaite se déplacer, on vérifie si, dans la direction dans laquelle il se déplace, il y a un ennemi ou un obstacle.
Si oui, il ne se déplace pas. Si non, il peut donc se déplacer.

### Cactus:
Le Cactus se déplace de manière très basique, ne changeant de direction que lorsque il rencontre un obstacle ou Jean-Michel.
Des qu'il rencontre un obstacle, il se réoriente, et ce, jusqu'à sa mort.

### Tentacule:
Il utilise le BFS pour se déplacer sur la map, en suivant toujours la position de Jean-Michel.
La classe BFS a comme attributs un Terrain, une HashMap de Tiles représentant toutes les tiles de la map, une Queue de Tiles représentant la file, et une ArrayList de Tiles pour stocker les Tiles marquées.

Le BFS est appelé grace à la méthode lancerBFS, qui elle-meme appelle d'autres méthodes: sommetsAdjacents qui ajoute toutes les Tiles adjacentes dans la file, sauf si elles sont déjà marquées.


## Attaquer:

### Jean-Michel:
Lorsque Jean-Michel appuie sur la touche E, la méthode collisionnePerso vérifie s'il y a des ennemis dans les cases tout autour de lui, et les attaque automatiquement.

### Ennemis:
Les cactus n'attaquent pas.
Les tentacules attaquent lorsqu'elles sont en contact avec Jean-Michel: dans la méthode seDeplacer, après s'etre déplacé, la tentacule vérifie s'il y a Jean-Michel dans sa direction et l'attaque.

## Recuperer des objets:
Des que Jean-Michel passe sur un objet, il recupère l'objet.