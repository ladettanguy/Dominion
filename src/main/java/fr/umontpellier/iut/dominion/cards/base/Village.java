package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Village
 *
 * +1 Carte.
 * +2 Actions.
 */
public class Village extends Action {
    public Village() {
        super("Village", 3);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(2);
    }

    @Override
    public List<CardType> getTypes() {
        List<CardType> list = new ArrayList<>();
        list.add(CardType.Action);
        return list;
    }
}