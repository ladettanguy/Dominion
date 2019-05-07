package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Action {
    public ThroneRoom() {
        super("Throne Room", 4);
    }

    @Override
    public void play(Player p) {
        ListOfCards list = p.getHand();
        ListOfCards jouable = new ListOfCards();
        for (Card c: list)
            if (c.getTypes().contains(CardType.Action))jouable.add(c);
        String s;
        s = p.chooseCard("choisissez une carte à jouer deux foix parmi les suivante",jouable, jouable.isEmpty());
        Card c = list.getCard(s);
        p.playCard(s);
        if(c != null) c.play(p);

    }
}