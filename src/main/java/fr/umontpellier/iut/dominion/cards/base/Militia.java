package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.ActionAttack;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Milice (Militia)
 *
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends ActionAttack {
    public Militia() {
        super("Militia", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
        List<Player> listPlayer = p.getGame().otherPlayers(p);
        for (Player pla : listPlayer) {
            pla.haveMoat();
            if(!pla.isProtected()){
                ListOfCards list1 = pla.getHand();
                while (list1.size() > 3){
                    String s = pla.chooseCard("Choissiez une carte à défaussé. restant: " + (list1.size()-3),list1,false);
                    pla.discardCard(list1.getCard(s));
                    pla.removeToHand(s);
                }
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