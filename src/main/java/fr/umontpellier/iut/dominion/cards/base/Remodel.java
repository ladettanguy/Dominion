package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Rénovation (Remodel)
 *
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends Action {
    public Remodel() {
        super("Remodel", 4);
    }

    @Override
    public void play(Player p) {
        ListOfCards list = p.getHand();
        String s = p.chooseCard("Choissiez une carte à évoluer",list,false);
        Card trash = p.removeToHand(s);
        ListOfCards available = p.getGame().availableSupplyCards();
        ListOfCards dispo = new ListOfCards();
        for (Card c : available) {
            if ( c.getCost() <= (trash.getCost()+2)) dispo.add(c);
        }
        String choix = p.chooseCard("Choissiez une carte coutant au maximum " + (trash.getCost()+2),dispo,false);
        p.discardCard(p.getGame().removeFromSupply(choix));
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}