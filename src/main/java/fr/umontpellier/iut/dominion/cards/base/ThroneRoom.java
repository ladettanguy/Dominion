package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.ListOfCards;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Card {
    public ThroneRoom() {
        super("Throne Room", 4);
    }

    /*@Override
    public void play(Player p) {
        ListOfCards list = p.getCardsInHand();
        ListOfCards jouable = new ListOfCards();
        for (Card c: list) {
            if (c.getTypes().contains(CardType.Action))jouable.add(c);
        }
        String s = p.chooseCard("choisissez une carte à jouer deux foix parmi les suivante",jouable,true);
        p.playCard(s);
        p.playCard(s);
        p.
    }*/
}