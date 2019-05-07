package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Victory;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Platine (Platinum)
 *
 * 5 Pièces
 */

public class Platinum extends Victory {
    public Platinum() { super("Platinum", 9); }

    @Override
    public void play(Player p) {
       p.incrementMoney(5);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Treasure);
        return list;
    }
}
