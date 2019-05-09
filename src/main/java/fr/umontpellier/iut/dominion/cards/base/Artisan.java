package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Artisan
 *
 * Gagnez une carte coûtant jusqu'à 5 Pièces dans votre main.
 * Mettez une carte de votre main sur votre deck.
 */
public class Artisan extends Action {
    public Artisan() {
        super("Artisan", 6);
    }

    @Override
    public void play(Player p) {
        ListOfCards supply = p.getGame().availableSupplyCards();
        ListOfCards supplyInferior5 = new ListOfCards();
        for ( Card c : supply) {
            if(c.getCost() <= 5){
                supplyInferior5.add(c);
            }
        }

        String choose = p.chooseCard("Choissisez une carte de votre défausse", supplyInferior5, !supplyInferior5.isEmpty());
        Card ca = p.getGame().removeFromSupply(choose);
        p.addToHand(ca);

        ListOfCards hand = p.getHand();
        String chooseHand = p.chooseCard("Choissisez une carte de votre main à mettre sur votre deck", hand, !hand.isEmpty());
        Card c = p.getHand().getCard(chooseHand);
        p.addToDraw(c);
        p.removeToHand(chooseHand);
    }
}
