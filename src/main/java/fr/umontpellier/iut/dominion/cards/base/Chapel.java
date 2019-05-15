package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Chapelle (Chapel)
 *
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends Action {
    public Chapel() {
        super("Chapel", 2);
    }

    @Override
    public void play(Player p) {
        String s = p.chooseCard("Entrez les cartes à Écartez (une par une et max:4) et Appuyer sur ENTER (vide) pour Pass",p.getCardsInHand(),true);
        int count = 0;
        while (count < 4 && !s.equals("")){
            Card c = p.removeToHand(s);
            if(c != null) count++;
            s = p.chooseCard("Entrez les cartes à Écartez (une par une et max:4) et Appuyer sur ENTER (vide) pour Pass",p.getCardsInHand(),true);
        }
    }

}