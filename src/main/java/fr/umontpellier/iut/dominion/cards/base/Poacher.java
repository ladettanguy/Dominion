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

        ListOfCards avaibleStacks =  p.getGame().availableSupplyCards();
        int nbAvaibleStacks = 0;
        for (Card c : avaibleStacks){
            nbAvaibleStacks += 1;
        }
        int nbEmptyStacks = 17 - nbAvaibleStacks;
        ListOfCards hand = p.getHand();

        if (nbEmptyStacks == 1){
           String chooseHand = p.chooseCard("Choissisez une carte de votre main à mettre sur votre deck", hand, !hand.isEmpty());
            p.removeToHand(chooseHand);
        }

        if (nbEmptyStacks == 2){
            String chooseHand = p.chooseCard("Choissisez une carte de votre main à mettre sur votre deck", hand, !hand.isEmpty());
            p.removeToHand(chooseHand);
            ListOfCards hand2 = p.getHand();
            String chooseHand2 = p.chooseCard("Choissisez une carte de votre main à mettre sur votre deck", hand2, !hand2.isEmpty());
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
