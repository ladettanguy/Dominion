package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Silver;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends Card {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }

    @Override
    public void play(Player p) {
        ListOfCards listdecarte = p.getGame().availableSupplyCards();
        Card silv = listdecarte.getCard("Silver");
        p.addToDraw(silv);
        List<Player> list = p.getGame().otherPlayers(p);
        ListOfCards victory = new ListOfCards();
        for (Player pla : list) {
            ListOfCards list1 = pla.getHand();
            for (Card c : list1){
                if (c.getTypes().contains(CardType.Reaction)) if(c.react(pla)) break;
                if (c.getTypes().contains(CardType.Victory)) victory.add(c);
            }
            if (!victory.isEmpty()){
                String s = pla.chooseCard("choisissez une carte à dévoilé parmis les suivante", victory , false);
                Card c = pla.removeToHand(s);
                pla.addToDraw(c);
                p.getGame().println("le joueur " + pla.getGame() + " à défausser " + s);
            }
            else {
                p.getGame().print("le joueur " + pla.getGame() + " possède : ");
                for (Card c : list1) {
                    p.getGame().print(c.toString()+ " ");
                }
                p.getGame().print("\n");
            }
        }
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        list.add(CardType.Attack);
        return list;
    }



}