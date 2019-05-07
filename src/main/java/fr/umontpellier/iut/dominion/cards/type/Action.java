package fr.umontpellier.iut.dominion.cards.type;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Action extends Card {
    /**
     * Constructeur simple
     *
     * @param name le nom de la carte
     * @param cost le coût de la carte
     */
    public Action(String name, int cost) {
        super(name, cost);

    }

    public List<CardType> getTypes(){
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }

}
