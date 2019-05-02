package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.ListOfCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Mine
 *
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ;
 * ajoutez cette carte à votre main.
 */
public class Mine extends Card {
    public Mine() {
        super("Mine", 5);
    }

    @Override
    public void play(Player p) {
        ListOfCards list = p.getHand();
        ListOfCards treasure = new ListOfCards();
        for (Card c: list) {
            if (c.getTypes().contains(CardType.Treasure)) treasure.add(c);
        }
        String s = p.chooseCard("Choissiez un trésor à évoluer",treasure,false);
        Card trash = p.removeToHand(s);
        ListOfCards available = p.getGame().availableSupplyCards();
        ListOfCards dispo = new ListOfCards();
        for (Card c : available) {
            if (c.getTypes().contains(CardType.Treasure) && c.getCost() <= (trash.getCost()+3)) dispo.add(c);
        }
        String choix = p.chooseCard("Choissiez un trésor coutant au maximum " + (trash.getCost()+3),dispo,false);
        p.addToHand(p.getGame().removeFromSupply(choix));
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}