package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 */
public class Silver extends Card {
    public Silver() {
        super("Silver", 3);
    }

    @Override
    public void play(Player p) {
        Card c = p.getInPlay().getCard("Merchant");
        if (c != null) {
            p.incrementMoney(1);
            p.removeToInPlay(c);
            p.discardCard(c);
        }
        p.incrementMoney(2);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Treasure);
        return list;
    }
}
