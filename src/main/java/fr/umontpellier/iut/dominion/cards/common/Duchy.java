package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Victory;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Duché (Duchy)
 *
 * 3 VP
 */
public class Duchy extends Victory {

    public Duchy() {
        super("Duchy", 5);
    }

    public int getVictoryValue(Player p){
        return 3;
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Victory);
        return list;
    }
}