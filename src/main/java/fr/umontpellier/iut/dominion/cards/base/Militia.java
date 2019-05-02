package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Milice (Militia)
 *
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends Card {
    public Militia() {
        super("Militia", 4);
    }

    private void doDiscard (Player opponentPlayer ,ListOfCards opponentHand){
        while (opponentHand.size() > 3){
            String s = opponentPlayer.chooseCard("Choissiez une carte à défaussé. restant: " + (opponentHand.size()-3),opponentHand,false);
            opponentPlayer.discardCard(opponentHand.getCard(s));
            opponentPlayer.removeToHand(s);
        }
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
        List<Player> listPlayer = p.getGame().otherPlayers(p);
        for (Player pla : listPlayer) {
            ListOfCards list1 = pla.getHand();
            for (Card c : list1) {
                if (c.getTypes().contains(CardType.Reaction)) {
                    if (c.react(pla)) break;
                    else doDiscard(pla, list1);
                }
            }
            doDiscard(pla, list1);
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