package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

public class City extends Action {
    public City() {
        super("City", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(2);
        p.drawToHand();

        int nbEmptyStacks = 0;    // nombre de piles vides
        for (ListOfCards stack : p.getGame().getSupplyStacks()) {
            // une pile est vide
            if(stack.isEmpty()) nbEmptyStacks += 1 ;
            if(nbEmptyStacks == 2) break;
        }
        if(nbEmptyStacks >= 1) p.drawToHand();
        if(nbEmptyStacks >= 2){
            p.incrementBuys(1);
            p.incrementMoney(1);
        }
    }
}
