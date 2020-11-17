/**
 * in this class we can create new Army and interact with them
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
import java.util.ArrayList;

public class Army {

    private int score;
    private ArrayList<Element> elements;

    /**
     * create new army
     */
    public Army() {
        score = 0;
        elements = new ArrayList<Element>();
    }

    /**
     * @return score of army
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score new score of army
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return elements of army
     */
    public ArrayList<Element> getElements() {
        return elements;
    }

    /**
     * update element location
     *
     * @param X previous location
     * @param Y previous location
     * @param x new location
     * @param y new location
     */
    public void updateElementLocation(int X, int Y, int x, int y) {
        for (Element sample : elements) {
            if (sample.getX() == X && sample.getY() == Y) {
                sample.setLocation(x, y);
                break;
            }
        }
    }

    /**
     * decrease counter of element
     *
     * @param x location of element
     * @param y location of element
     */
    public void decreaseNumberOfElementsInLocation(int x, int y) {
        for (Element sample : elements) {
            if (sample.getX() == x && sample.getY() == y) {
                sample.Decrease();
                break;
            }
        }
    }

    /**
     * add element to army
     *
     * @param e element that we want to add to army
     */
    public void addElement(Element e) {
        elements.add(e);
    }

    /**
     * max score is 6
     *
     * @return if army is winner or not
     */
    public boolean isWinner() {
        if (getScore() == 6) {
            return true;
        }
        return false;
    }
}
