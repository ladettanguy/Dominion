package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Or (Gold)
 *
 * 3 Pièces
 */
public class Gold extends Treasure {
    public Gold() {
        super("Gold", 6);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(3);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Treasure);
        return list;
    }
}
