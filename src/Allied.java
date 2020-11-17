/**
 * this is allied army
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
public class Allied extends Army{
    /**
     * creat allied army
     */
    public Allied(){
        super();
        firstArmy();
    }

    /**
     * set first army
     */
    public void firstArmy(){
        Element e1 = new Soldier(4,1,4);
        Element e2 = new Soldier(4,6,4);
        Element e3 = new Soldier(4,8,4);
        Element e4 = new Soldier(4,11,4);
        Element e5 = new Soldier(5,3,4);
        Element e6 = new Soldier(6,7,4);
        Element e7 = new Soldier(7,0,4);
        Element e8 = new Artillery(7,1,2);
        Element e9 = new Artillery(7,5,2);
        Element e10 = new Soldier(7,9,4);
        Element e11 = new Tank(8,0,3);
        Element e12 = new Tank(8,1,3);
        Element e13 = new Tank(8,8,3);
        Element e14 = new Tank(8,12,3);
        addElement(e1);
        addElement(e2);
        addElement(e3);
        addElement(e4);
        addElement(e5);
        addElement(e6);
        addElement(e7);
        addElement(e8);
        addElement(e9);
        addElement(e10);
        addElement(e11);
        addElement(e12);
        addElement(e13);
        addElement(e14);
    }

}
