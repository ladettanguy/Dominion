package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Bibliothèque (Library)
 *
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté.
 * Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends Action {
    public Library() {
        super("Library", 5);
    }

    @Override
    public void play(Player p) {
        while(p.getHand().size() < 7){
            Card c = p.drawToHand();
            if(c.getTypes().contains(CardType.Action)){
                ArrayList<String> choices = new ArrayList<>();
                choices.add("y");choices.add("n");
                String s = p.chooseOption("Voulez-vous d&faussez la carte ?", choices, false);
                if (s.equals("y")){
                     p.discardCard(c);
                     p.removeToHand(c.getName());
                }
            }
        }
    }

}