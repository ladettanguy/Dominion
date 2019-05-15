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
        ListOfCards supplyInferior5 = new ListOfCards();
        for ( Card c : p.getGame().availableSupplyCards()) {
            if(c.getCost() <= 5){
                supplyInferior5.add(c);
            }
        }

        String choose = p.chooseCard("Choissisez une carte qui coute 5max", supplyInferior5, false);
        if(!choose.equals("")) {
            Card ca = p.getGame().removeFromSupply(choose);
            p.addToHand(ca);
        }
        ListOfCards hand = p.getCardsInHand();
        String chooseHand = p.chooseCard("Choissisez une carte de votre main à mettre sur votre deck", hand, false);
        p.addToDraw(hand.getCard(chooseHand));
        p.removeToHand(chooseHand);
    }
}
