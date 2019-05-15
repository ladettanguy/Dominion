package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Cave (Cellar)
 *
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends Action {
    public Cellar() {
        super("Cellar", 2);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        String s = p.chooseCard("Entrez les cartes à défaussée (une par une) et Appuyer sur ENTER (vide) pour Pass",p.getCardsInHand(),true);
        int count = 0;
        while (!s.equals("")){
            Card c = p.removeToHand(s);
            if(c != null) {
                p.discardCard(c);
                count++;
            }
            s = p.chooseCard("Entrez les cartes à défaussée (une par une) et Appuyer sur ENTER (vide) pour Pass",p.getCardsInHand(),true);
        }
        for (int i = 0; i < count; i++) {
            p.drawToHand();
        }
    }
}