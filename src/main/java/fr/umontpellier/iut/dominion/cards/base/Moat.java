package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.ActionReaction;

import java.util.*;

/**
 * Carte Douves (Moat)
 *
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce
 * cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ActionReaction {
    public Moat() {
        super("Moat", 2);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        list.add(CardType.Reaction);
        return list;
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
    }

    @Override
    public boolean react(Player p) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("y");list.add("n");
        String s = p.chooseOption("Voulez vous réagir a une carte ATTACK avec Moat ?",list,false);
        if (s.equals("y"))return true;
        else return false;
    }
}