package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Victory;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Jardins (Gardens)
 *
 * Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).
 */
public class Gardens extends Victory {
    public Gardens() {
        super("Gardens", 4);
    }

    public int getVictoryValue(Player p){
        ListOfCards list = new ListOfCards();
        list.addAll(p.getCardsInDraw());
        list.addAll(p.getCardsInDiscard());
        list.addAll(p.getCardsInInplay());
        list.addAll(p.getCardsInHand());
        return list.size()/10;
    }

}