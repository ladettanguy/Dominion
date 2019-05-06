package fr.umontpellier.iut.dominion.cards.type;

import fr.umontpellier.iut.dominion.cards.Card;

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
}
