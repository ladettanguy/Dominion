package fr.umontpellier.iut.dominion.cards.type;

import fr.umontpellier.iut.dominion.cards.Card;

public abstract class Victory extends Card {
    /**
     * Constructeur simple
     *
     * @param name le nom de la carte
     * @param cost le coût de la carte
     */
    public Victory(String name, int cost) {
        super(name, cost);
    }
}
