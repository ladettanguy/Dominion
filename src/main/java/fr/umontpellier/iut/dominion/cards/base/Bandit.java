package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.ActionAttack;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Bandit
 *
 * Gagnez un Or.
 * Chaque joueur révèle les deux premières cartes de son deck, écarte un trésor autre que Cuivre et défausse le reste.
 */
public class Bandit extends ActionAttack {
    public Bandit() {
        super("Bandit", 5);
    }

    @Override
    public void play(Player p) {
        p.gainFromSupply("Gold");

        List<Player> list = p.getGame().otherPlayers(p);
        for (Player pla : list) {
            boolean r = false;
            ListOfCards list4 = pla.getCardsInHand();
            for (Card c : list4){
                if (c.getTypes().contains(CardType.Reaction)){
                    r = c.react(pla);
                }
            }
            if(!r){
                boolean aDiscard = false;
                for (int i = 0; i < 2; i++) {
                    Card c = pla.removeToDraw(0);
                    if (c.getTypes().contains(CardType.Treasure) && !c.getName().equals("Copper") && !aDiscard){aDiscard = true;}
                    else  pla.discardCard(c);
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
