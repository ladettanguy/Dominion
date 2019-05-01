package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.ListOfCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Atelier (Workshop)
 *
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends Card {
    public Workshop() {
        super("Workshop", 3);
    }

    @Override
    public void play(Player p) {
        ListOfCards list = p.getGame().availableSupplyCards();
        ListOfCards list1 = p.getGame().availableSupplyCards();
        for (Card c: list1) {
            if (c.getCost() > 5) list.remove(c);
        }
        while (true) {
            p.getGame().println("Choisissez parmis ces cartes :" + list);
            String s = p.getGame().readLine();
            if (list.getCard(s) != null) {
                p.gainFromSupply(s);
                break;
            } else p.getGame().println("Erreur en entrant le nom de la carte veuillez recommencez");
        }
    }
    
    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}