package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Monument (Monument)
 * Coute 4
 * money +2
 * Victory point +1
 */

public class Monument extends Action {
    public Monument() {
        super("Monument", 4);
    }

    @Override
    public void play(Player p) {
    p.incrementVictoryPoint(1);
    p.incrementMoney(2);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }

}
