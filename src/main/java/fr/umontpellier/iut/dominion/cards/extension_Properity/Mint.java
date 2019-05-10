package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

public class Mint extends Action {
    public Mint() {
        super("Mint", 5);
    }

    @Override
    public void play(Player p) {
        ListOfCards list = new ListOfCards();
        for (Card c: p.getCardsInHand()) {
            if(c.getTypes().contains(CardType.Treasure)) list.add(c);
        }
        String s = p.chooseCard("Vous pouvez choisir de révélé une carte trésor pour gagné une copy",list,true);
        if(!s.equals(""))p.addToHand(p.getCardsInHand().getCard(s));
    }
}
