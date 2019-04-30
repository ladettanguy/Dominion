package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Festival
 *
 * +2 Actions.
 * +1 Achat.
 * +2 Pièces.
 */
public class Festival extends Card {
    public Festival() {
        super("Festival", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(2);
        p.incrementBuys(1);
        p.incrementMoney(2);
    }

}