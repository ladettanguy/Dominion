package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Silver;
import fr.umontpellier.iut.dominion.cards.type.Action;
import fr.umontpellier.iut.dominion.cards.type.ActionAttack;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends ActionAttack {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }

    @Override
    public void play(Player p) {
        p.addToDraw(p.getGame().removeFromSupply("Silver"));
        for (Player pla : p.getOtherPlayers()) {
            pla.haveMoat();
            if(!pla.isProtected()){
                ListOfCards victory = new ListOfCards();
                for (Card c: pla.getCardsInHand()) {
                    if(c.getTypes().contains(CardType.Victory)) victory.add(c);
                }
                String s = pla.chooseCard("choisissez une card victoire a dévoilé et a mettre sur votre deck",victory,false);
                pla.addToDraw(pla.removeToHand(s));
            }
        }

    }
}