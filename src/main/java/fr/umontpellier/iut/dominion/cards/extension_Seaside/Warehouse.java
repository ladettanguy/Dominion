package fr.umontpellier.iut.dominion.cards.extension_Seaside;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Warehouse
 *
 * +1 Action.
 * +3 Carte.
 * Défaussez 3 cartes.
 */
public class Warehouse extends Action {
    public Warehouse() {
        super("Warehouse", 3);
    }

    public void play(Player p) {
        p.incrementActions(1);
        for (int i = 0; i < 3; i++) {
            p.drawToHand();
        }

        for (int i = 0; i < 3; i++) {
            String chooseHand = p.chooseCard("Choissisez une carte de votre main à déffauser", p.getCardsInHand(), false);
            p.discardCard(p.getCardsInHand().getCard(chooseHand));
            p.removeToHand(chooseHand);
        }
    }

}
