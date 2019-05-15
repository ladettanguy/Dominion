package fr.umontpellier.iut.dominion.cards.extension_Seaside;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Bazaar
 *
 * +1 Carte.
 * +2 Actions.
 * +1 Gold
 */
public class Bazaar extends Action {
    public Bazaar() {
        super("Bazaar", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(2);
        p.incrementMoney(1);
    }

}