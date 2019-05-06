package fr.umontpellier.iut.dominion.cards.type;

import fr.umontpellier.iut.dominion.cards.Card;

public abstract class Treasure extends Card {
    /**
     * Constructeur simple
     *
     * @param name le nom de la carte
     * @param cost le coût de la carte
     */
    public Treasure(String name, int cost) {
        super(name, cost);
    }


}
