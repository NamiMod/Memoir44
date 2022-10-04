/**
 * this is axis army
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
public class Axis extends Army{
    /**
     * create axis army
     */
    public Axis(){
        super();
        firstArmy();
    }

    /**
     * set first army
     */
    public void firstArmy(){
        Element e1 = new Tank(0,0,4);
        Element e2 = new Soldier(0,1,4);
        Element e3 = new Soldier(0,2,4);
        Element e4 = new Tank(0,5,4);
        Element e5 = new Soldier(0,7,4);
        Element e6 = new Tank(0,8,4);
        Element e7 = new Soldier(0,10,4);
        Element e8 = new Tank(0,11,4);
        Element e9 = new Soldier(0,12,4);
        Element e10 = new Soldier(1,4,4);
        Element e11 = new Tank(1,5,4);
        Element e12 = new Soldier(1,8,4);
        Element e13 = new Tank(1,10,4);
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
    }


}
