package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Carte Vassal
 *
 * +2 Pièces.
 * Défaussez la première carte de votre deck. Si c'est une carte Action, vous pouvez la jouer.
 */
public class Vassal extends Card {
    public Vassal() {
        super("Vassal", 3);
    }


    @Override
    public void play(Player p) {
        p.incrementMoney(2);
        Card c = p.removeToDraw(0);
        if (c.getTypes().contains(CardType.Action)){
            ArrayList<String> list = new ArrayList<String>();
            list.add("y"); list.add("n");
            String s =p.chooseOption("Voulez vous jouer cette carte action ?",list,false);
            if (s.equals("y")) {
                p.addToHand(c);
                p.playCard(c.getName());
            }
        }
        else p.discardCard(c);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}
