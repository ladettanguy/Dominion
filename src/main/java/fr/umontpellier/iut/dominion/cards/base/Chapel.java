package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Chapelle (Chapel)
 *
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends Card {
    public Chapel() {
        super("Chapel", 2);
    }

    @Override
    public void play(Player p) {
        p.getGame().println("Entrez les cartes à Écartez (une par une et max:4) et Appuyer sur ENTER (vide) pour Pass");
        String s = p.getGame().readLine();
        int count = 0;
        while (count < 4 && !s.equals("")){
            Card c = p.removeToHand(s);
            if(c != null) count++;
            s = p.getGame().readLine();
        }
    }
}