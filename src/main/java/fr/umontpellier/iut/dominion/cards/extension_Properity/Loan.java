package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.FactoryListOfCards;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

import java.util.ArrayList;

/**
 * +1 money
 *
 * quand cette carte est jouer, révélé des carte de la pioche jusqu'a avoir un treasure , choisissez de la discard ou de la trash.
 *
 * Discard les autres card
 */
public class Loan extends Treasure {
    public Loan() {
        super("Loan", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(1);
        ListOfCards list = new ListOfCards();
        for (Card c: p.getCardsInDraw()){
            if(!c.getTypes().contains(CardType.Treasure)) p.discardCard(p.removeToDraw(0));
            else {
                ArrayList<String> choix = new ArrayList<String>();
                choix.add("Trash");choix.add("Discard");
                String s = p.chooseOption("choisissez si vous voulez \"Trash\" ou \"Discard\" :",choix,false);
                if (s.equals("Discard"))p.discardCard(p.removeToDraw(0));
                else p.removeToDraw(0);
                break;
            }
        }
    }
}
