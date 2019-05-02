package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Braconnier (Poacher)
 *
 * +1 Action.
 * +1 Carte.
 * +1 Pièce.
 * Défaussez une carte de votre main par pile de réserve épuisée.
 */
public class Poacher extends Card {
    public Poacher() {
        super("Poacher", 4);
    }

    public void play(Player p) {
        p.incrementActions(1);
        p.incrementMoney(1);
        p.drawToHand();

        int nbEmptyStacks = 0;    // nombre de piles vides
        for (ListOfCards stack : p.getGame().getSupplyStacks()) {
            // une pile est vide
            if (stack.isEmpty()) nbEmptyStacks += 1;
        }
        for (int i = 0; i < nbEmptyStacks; i++) {
            String chooseHand = p.chooseCard("Choissisez une carte de votre main à déffausée", p.getCardsInHand(), false);
            p.discardCard(p.getHand().getCard(chooseHand));
            p.removeToHand(chooseHand);
        }
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}
