/**
 * in this class we can get cards for move or fight
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
import java.util.ArrayList;

public class Card {

    /**
     * kind of cards :
     * <p>
     * 1 : move 1 element
     * 2 : move 2 elements
     * 3 : move 3 elements
     * 4 : move 4 elements
     * 5 : order to 3 same elements
     * <p>
     * -------------------------------------
     * <p>
     * number of cards :
     * <p>
     * 1 : 6 cards
     * 2 : 13 cards
     * 3 : 10 cards
     * 4 : 6 cards
     * 5 : 5 cards
     */

    private ArrayList<Integer> cards;
    private ArrayList<Integer> cardsBackUp;
    private Dice dice;

    /**
     * add cards
     */
    public Card() {
        cards = new ArrayList<Integer>();
        cardsBackUp = new ArrayList<Integer>();
        dice = new Dice();
        addCardsToBackUp();
        addCardsToList();
    }

    /**
     * when cards are played reset cards list
     */
    public void addCardsToList() {
        for (int i = 0; i < 39; i++) {
            cards.add(cardsBackUp.get(i));
        }
    }

    /**
     * return card number
     *
     * @return card number
     */
    public int getCard() {
        if (cards.size() == 0) {
            addCardsToList();
        }
        int x = dice.getCustomDice(cards.size());
        int card = cards.get(x);
        cards.remove(x);
        return card;
    }

    /**
     * add cards to backup list
     */
    public void addCardsToBackUp() {
        for (int i = 0; i < 6; i++) {
            cardsBackUp.add(1);
        }
        for (int i = 0; i < 13; i++) {
            cardsBackUp.add(2);
        }
        for (int i = 0; i < 10; i++) {
            cardsBackUp.add(3);
        }
        for (int i = 0; i < 6; i++) {
            cardsBackUp.add(4);
        }
        for (int i = 0; i < 5; i++) {
            cardsBackUp.add(5);
        }
    }

}
