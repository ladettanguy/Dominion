package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Victory;

import java.util.ArrayList;
import java.util.List;

// coute 11 et donne 10 Victory Point
/**
 * Carte Colonie (Colony)
 *
 * 10 VP
 */

public class Colony extends Victory {
    public Colony() {
        super("Colony", 11);
    }

    public int getVictoryValue(Player p){
        return 10;
    }
}
