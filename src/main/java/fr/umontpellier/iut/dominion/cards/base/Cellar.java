package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Cave (Cellar)
 *
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends Card {
    public Cellar() {
        super("Cellar", 2);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.getGame().println("Entrez les cartes à défaussée (une par une) et Appuyer sur ENTER (vide) pour Pass");
        String s = p.getGame().readLine();
        int count = 0;
        while (!s.equals("")){
            Card c = p.removeToHand(s);
            if(c != null) {
                p.discardCard(c);
                count++;
            }
            s = p.getGame().readLine();
        }
        for (int i = 0; i < count; i++) {
            p.drawToHand();
        }
    }

}