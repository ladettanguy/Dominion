package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Prêteur sur gages (Moneylender)
 *
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends Action {
    public Moneylender() {
        super("Moneylender", 4);
    }

    @Override
    public void play(Player p) {
        ArrayList<String> choix = new ArrayList<>();
        choix.add("y");choix.add("n");
        for (Card c: p.getCardsInHand()) {
            if (c.getName().equals("Copper")) {
                String s = p.chooseOption("voulez-vous trash un copper \"y\" ou \"n\" ",choix,true);
                if(s.equals("y")){
                    p.removeToHand("Copper");
                    p.incrementMoney(3);
                }
                break;
            }
        }
    }

}