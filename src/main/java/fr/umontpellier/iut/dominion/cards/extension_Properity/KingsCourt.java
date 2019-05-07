package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte court du trône (King's Court)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la trois fois.
 */

public class KingsCourt  extends Action {
    public KingsCourt() {
        super("King's Court", 7);
    }

    @Override
    public void play(Player p) {
        ListOfCards action = new ListOfCards();
        for (Card c: p.getCardsInHand()) if (c.getTypes().contains(CardType.Action))action.add(c);
        String s = p.chooseCard("choisissez une carte à jouer trois fois parmi les suivantes",action , action.isEmpty());
        Card c = p.getHand().getCard(s);
        p.playCard(s);
        if(c != null){c.play(p);c.play(p);}
    }
}
