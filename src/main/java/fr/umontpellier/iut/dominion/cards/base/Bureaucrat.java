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
        boolean aUneCarteVictory = false;
        for (Player pla : list) {
            ListOfCards list1 = pla.getHand();
            for (Card c : list1){
                if (c.getTypes().contains(CardType.Reaction)){
                    if(c.react(pla)) break;
                }
                if (aUneCarteVictory == false && c.getTypes().contains(CardType.Victory)) aUneCarteVictory = true;
            }
            if (aUneCarteVictory == true){
                while (true) {
                    pla.getGame().println("Dévoilé une carte victory de votre main");
                    String s = pla.getGame().readLine();
                    Card ca = list1.getCard(s);
                    if (ca != null && ca.getTypes().contains(CardType.Victory) && list1.contains(ca)) {
                        p.getGame().println(pla.getName() + " " + s);
                        p.discardCard(ca);
                        p.removeToHand(s);
                        break;
                    }
                    else pla.getGame().println("erreur lors du saisi veuillez recommencer");
                }
            }
            else p.getGame().println(pla.getName() + " " + list1);
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