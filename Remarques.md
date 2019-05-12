Bien le bonjours et premierement je tiens a m'escuser d'avance des faute d'orthographe qu'il risque fortement de suivre 
dans ce document Remarques.md 

pour commencer a parler du projet :
Je tien a préciser que je n'est pas installer l'interface graphique

Pour MoneyLender Mr Poupet nous as dit recement sur piazza de de rajouter :
game.setInput("Copper");
dans le test, Cependant j'ai trouver plus judicieux de ne pas faire un chooseCard et plutot un chooseOption car faire un chooseCard inclus
de faire une list contenant tous les copper et puis je trouve sa stupid de faire une list contenant que des copper puis demander au joueur
de ecrire: Copper; autant qu'il disent si oui ou non et qu'on remove le premier copper vu qu'il sont tous pareil dans tous les cas.


ensuite j'ai tenter de faire le plus de carte possible de l'extension "prosperity"
Je n'ai pas eux le temps de tous faire mais celle-ci changer pas mal de méthode dans Player car elle avais des effet dans inPlay.
du coup je vous est fais un listing de chaque carte et de quelle méthode a changer cette carte :

-Bishop ---> à changer Player.getVictoryPoints() car j'ai du rajouter un compteur de victoryPoints en plus et l'aditionner dans 
             cette méthode avec la valeur des carte Victory déja présente dans le jeu
               
-Expand ---> son effet m'as Beaucoup fais penser à Remodel et donc j'ai décider pour eviter de dupliquer le code de crée une classe 
             abstraite que j'ia nommé TrashAndChangeACard qui hérite de Action et dont remodel & Expand hérite pour optimiser tous sa
            
-Grand Market ---> ne peut pas etre acheter si un copper est dans inPlay donc Player.buyCard() à été changé aller voir pour plus de 
                    précision

-Hoard --->  gagne un gold si elle est dans inPlay et qu'on buy une carte victory. Player.buyCard à donc été changé aller voir pour 
            plus de précision

-King's Court ---> meme chose que pour expand . elle resemble a ThroneRoom j'ia donc fais pareille que avec remodel. 
                  ActionPlaySeveralTimes à donc été crée
                  
-Mint ---> discard tout les treasure de inPlay quadn elle est buy, donc Player.buyCard à été modifier aller voir pour plus de précision

-Peddler ---> -2 cost par carte action dans inPlay. donc Player.buyCard à été modifier aller voir pour plus de précision.

-Quarry ---> -2 au carte action tant quelle est dans inPlay. donc Player.buyCard à été modifier aller voir pour plus de précision

-Royal Seal ---> Tant quelle est dans inPlay acheter une carte la fais revenir au dessus de draw. donc Player.gain à été modifier 
               aller voir pour plus de précision

-Talisman ---> Copie une carte action , acheter , dans la discard tant que talisman et dans inPlay donc Player.buyCard à été modifier 
               aller voir pour plus de précision

-Watchtower ---> Carte réaction qui permet de quadn on gagne une carte de la trash ou de la mettre au dessus du deck. donc Player.gain 
                à été modifier aller voir pour plus de précision
               
Heuresement pour vous les carte asser spécial s'arrete la je n'en n'ai pas fais plus.
Bon ç savoir j'ai crée mes propre test sur ces carte d'extension qui se trouve dans CardsTestExtension dans le dossier des 
test de carte normaux.


J'ai aussi modifier Game.isFinish() pour que la pile de colony arrete le jeu si elle est vide, en plus de celle des province ou des 3 stack vide.

 
