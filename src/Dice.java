/**
 * in this class we can create a random number for dice
 *
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
import java.util.Random;

public class Dice {

    private Random rand = new Random();

    /**
     * generate random number
     * @return dice number
     */
    public int getDice() {
        return rand.nextInt(6) + 1;
    }

    /**
     * in this method we can return custom bound random number
     * @param n bound
     * @return random number
     */
    public int getCustomDice(int n){
        return rand.nextInt(n);
    }

}
