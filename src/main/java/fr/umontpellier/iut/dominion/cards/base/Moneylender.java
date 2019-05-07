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
        ListOfCards list = p.getCardsInHand();
        for (Card c: list) {
            if (c.getName().equals("Copper")){
                p.removeToHand("Copper");
                p.incrementMoney(3);
                break;
            }
        }
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}