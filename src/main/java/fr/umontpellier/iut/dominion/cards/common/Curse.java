package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Malédiction (Curse)
 *
 * -1 VP
 */
public class Curse extends Card {
    public Curse() {
        super("Curse", 0);
    }

    public int getVictoryValue(Player p){
        return -1;
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Curse);
        return list;
    }
}