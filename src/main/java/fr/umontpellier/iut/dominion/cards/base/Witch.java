package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.type.ActionAttack;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Sorcière (Witch)
 *
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends ActionAttack {
    public Witch() {
        super("Witch", 5);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
        List<Player> list = p.getGame().otherPlayers(p);
        for (Player pla : list) {
            boolean react = false;
            ListOfCards list1 = pla.getHand();
            for (Card c : list1){
                if (c.getTypes().contains(CardType.Reaction)){
                    react = c.react(pla);

                }
            }
            if(!react)pla.gainFromSupply("Curse");
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