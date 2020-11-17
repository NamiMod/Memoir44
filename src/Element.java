/**
 * in this class we can set or get location or number of element in a location
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
public class Element {

    private int counter;
    private int x;
    private int y;

    /**
     * creat new element
     * @param x location
     * @param y location
     * @param counter number of element
     */
    public Element(int x, int y , int counter) {
        this.counter = counter;
        this.x = x;
        this.y = y;
    }


    /**
     * decrease number of element in group
     */
    public void Decrease() {
        counter--;
    }

    /**
     * get number of elements in group
     * @return number of elements in group
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @return location of element
     */
    public int getX() {
        return x;
    }
    /**
     * @return location of element
     */
    public int getY() {
        return y;
    }

    /**
     * set a new location
     * @param x location
     * @param y location
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

}