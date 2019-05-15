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
        String s = p.chooseCard("Choissiez une carte à évoluer",p.getCardsInHand(),false);
        Card trash = p.removeToHand(s);
        ListOfCards dispo = new ListOfCards();
        for (Card c : p.getGame().availableSupplyCards()) {
            if ( c.getCost() <= (trash.getCost()+ costMaxEnPlus)) dispo.add(c);
        }
        String choix = p.chooseCard("Choissiez une carte coutant au maximum " + (trash.getCost()+ costMaxEnPlus),dispo,false);
        p.discardCard(p.getGame().removeFromSupply(choix));
    }
}
