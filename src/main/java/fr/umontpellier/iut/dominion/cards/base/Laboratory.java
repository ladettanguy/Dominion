package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Laboratoire (Laboratory)
 *
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends Action {
    public Laboratory() {
        super("Laboratory", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
        p.incrementActions(1);
    }


    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}