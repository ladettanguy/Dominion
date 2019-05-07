package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.FactoryListOfCards;
import fr.umontpellier.iut.dominion.cards.type.Action;

public class Forge extends Action {
    public Forge() {
        super("Forge", 7);
    }

    @Override
    public void play(Player p) {
        int prix = 0;
        for (Card c : p.getCardsInHand()) {
            String s = p.chooseCard("choisissez une carte a trash jusqu'a que vous envoyer \"\"",p.getHand(),true);
            if (!s.equals("")){
                prix += p.getHand().getCard(s).getCost();
                p.removeToHand(s);
            }
            else break;
        }
        ListOfCards list = new ListOfCards();
        for (Card c: p.getGame().availableSupplyCards()) if(c.getCost()==prix) list.add(c);
        String s = p.chooseCard("choisissez une carte qui coute tres exactement "+prix,list,false);
        if (!s.equals(""))p.gainFromSupply(s);
    }
}
