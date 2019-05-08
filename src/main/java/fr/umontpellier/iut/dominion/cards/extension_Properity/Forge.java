package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;


public class Forge extends Action {
    public Forge() {
        super("Forge", 7);
    }

    @Override
    public void play(Player p) {
        int prix = 0;
        String s = "vide";
        for (int i = 0; i < p.getCardsInHand().size() && !s.equals(""); i++) {
            s = p.chooseCard("Choissiez une carte a trash ou faite \"\" pour passer",p.getCardsInHand(),true);
            if(!s.equals("")) {
                prix += p.getCardsInHand().getCard(s).getCost();
                p.removeToHand(s);
            }
        }
        ListOfCards list = new ListOfCards();
        for (Card c: p.getGame().availableSupplyCards()) {
            if(c.getCost() == prix) list.add(c);
        }
        s  = p.chooseCard("choisissez une carte qui coute exactement "+prix,list,false);
        if(!s.equals(""))p.gainFromSupply(s);
    }
}


