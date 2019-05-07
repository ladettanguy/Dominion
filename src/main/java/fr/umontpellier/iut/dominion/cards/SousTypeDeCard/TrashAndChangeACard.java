package fr.umontpellier.iut.dominion.cards.SousTypeDeCard;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

public abstract class TrashAndChangeACard extends Action {
    public TrashAndChangeACard(String name, int cost) {
        super(name, cost);
    }

    public void play(Player p, int costMaxEnPlus) {
        ListOfCards list = p.getHand();
        String s = p.chooseCard("Choissiez une carte à évoluer",list,false);
        Card trash = p.removeToHand(s);
        ListOfCards available = p.getGame().availableSupplyCards();
        ListOfCards dispo = new ListOfCards();
        for (Card c : available) {
            if ( c.getCost() <= (trash.getCost()+ costMaxEnPlus)) dispo.add(c);
        }
        String choix = p.chooseCard("Choissiez une carte coutant au maximum " + (trash.getCost()+ costMaxEnPlus),dispo,false);
        p.discardCard(p.getGame().removeFromSupply(choix));
    }
}
