package fr.umontpellier.iut.dominion.cards.extension_Properity;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.Scanner;

public class Countinghouse extends Action {
    public Countinghouse() {
        super("Counting House", 5);
    }

    @Override
    public void play(Player p) {
        int countCopper= 0;
        for (Card c: p.getDiscard()) {
            if(c.getName().equals("Copper")) countCopper++;
        }
        ArrayList<String> list = new ArrayList<>();
        int x = countCopper;
        while (x != 0){
            list.add(0,"" + x);
            x--;
        }
        String s = p.chooseOption("choisissez une nombre de copper entre "+list.get(0)+" et "+list.get(list.size()-1),list,true);
        if(!s.equals("")){
            int number = Integer.parseInt(s);
            ListOfCards listCopper = new ListOfCards();
            for (int i = 0; i < number; i++) {
                listCopper.add(p.getDiscard().remove("Copper"));
            }
            p.getDraw().addAll(0,listCopper);
        }

    }
}
