/**
 * in this class we save map information like elements and kind of map elements like river , ...
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
public class Map {

    private Element[][] mapElement;
    private int[][] mapElement_valid;
    private int[][] mapNature;
    private String[][] mapElementString;
    private String[][] mapNatureString;
    private Army allied = new Allied();
    private Army axis = new Axis();

    /**
     * create new map
     */
    public Map(Army allied, Army axis) {
        mapElement = new Element[9][13];
        mapElement_valid = new int[9][13];
        mapNature = new int[9][13];
        firstMapElement(allied, axis);
        mapElementString = new String[9][13];
        mapNatureString = new String[9][13];
        firstMapNature();
        this.allied = allied;
        this.axis = axis;
    }

    /**
     * update map elements
     * @param allied Army
     * @param axis Army
     */
    public void updateMap(Army allied , Army axis){
        this.allied = allied;
        this.axis = axis;
    }

    /**
     * set elements of army in map
     */
    public void firstMapElement(Army allied, Army axis) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 13; j++) {
                mapElement_valid[i][j] = 0;
            }
        }
        for (Element e : allied.getElements()) {
            mapElement[e.getX()][e.getY()] = e;
            mapElement_valid[e.getX()][e.getY()] = 1;
        }
        for (Element e : axis.getElements()) {
            mapElement[e.getX()][e.getY()] = e;
            mapElement_valid[e.getX()][e.getY()] = 1;
        }
    }

    /*
     * nature :
     * 0 -> normal
     * 1 -> hill
     * 2 -> jungle
     * 3 -> river
     * 4 -> bridge
     * 5 -> city
     * 6 -> camp
     * 7 -> XX
     * 8 -> YY
     */

    /**
     * set nature in map
     */
    public void firstMapNature() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 13; j++) {
                mapNature[i][j] = 0;
            }
        }
        mapNature[0][0] = 1;
        mapNature[0][1] = 1;
        mapNature[0][3] = 5;
        mapNature[0][4] = 4;
        mapNature[1][1] = 3;
        mapNature[1][2] = 3;
        mapNature[1][3] = 3;
        mapNature[1][4] = 6;
        mapNature[1][6] = 1;
        mapNature[2][1] = 3;
        mapNature[2][6] = 1;
        mapNature[2][9] = 2;
        mapNature[2][12] = 2;
        mapNature[3][0] = 4;
        mapNature[3][1] = 2;
        mapNature[3][3] = 2;
        mapNature[3][11] = 2;
        mapNature[4][0] = 3;
        mapNature[4][1] = 2;
        mapNature[4][5] = 1;
        mapNature[4][6] = 5;
        mapNature[4][8] = 2;
        mapNature[4][10] = 5;
        mapNature[4][11] = 1;
        mapNature[4][12] = 2;
        mapNature[5][3] = 2;
        mapNature[5][4] = 1;
        mapNature[5][10] = 1;
        mapNature[5][11] = 2;
        mapNature[6][2] = 5;
        mapNature[6][7] = 2;
        mapNature[6][8] = 2;
        mapNature[7][3] = 2;
        mapNature[7][4] = 2;
        mapNature[7][8] = 2;
        mapNature[2][0] = 7;
        mapNature[8][11] = 8;

    }

    /**
     * @param x location
     * @param y location
     * @return kind of nature
     */
    public int getNature(int x, int y) {
        return mapNature[x][y];
    }

    /**
     * @return location of elements in map
     */
    public Element[][] getMapElement() {
        return mapElement;
    }

    /**
     * @return elements location
     */
    public int[][] getMapElement_valid() {
        return mapElement_valid;
    }

    /**
     * @param x  first location
     * @param y  first location
     * @param xx second location
     * @param yy second location
     * @return distance of (x,y) -> (xx,yy)
     */
    public int distance(int x, int y, int xx, int yy) {
        if (x == xx) {
            return java.lang.Math.abs(y - yy) - 1;
        }
        if (y == yy) {
            return java.lang.Math.abs(x - xx) - 1;
        }
        return java.lang.Math.max(java.lang.Math.abs(x - xx), java.lang.Math.abs(y - yy));
    }

    /**
     * @return name of elements in map
     */
    public String[][] getMapElementString() {
        return mapElementString;
    }

    /**
     * Update map Element String
     */
    public void fillElementStringMap(Army allied , Army axis) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 13; j++) {
                mapElementString[i][j] = "   ";
            }
        }

        for (Element e :allied.getElements()){
            if (e instanceof Soldier ){
                mapElementString[e.getX()][e.getY()] = "YS"+mapElement[e.getX()][e.getY()].getCounter();
            }
            else if (e instanceof Tank){
                mapElementString[e.getX()][e.getY()] = "YT"+mapElement[e.getX()][e.getY()].getCounter();
            }
            else if (e instanceof Artillery){
                mapElementString[e.getX()][e.getY()] = "YA"+mapElement[e.getX()][e.getY()].getCounter();
            }

        }
        for (Element e :axis.getElements()){
            if (e instanceof Soldier ){
                mapElementString[e.getX()][e.getY()] = "XS"+mapElement[e.getX()][e.getY()].getCounter();
            }
            else if (e instanceof Tank){
                mapElementString[e.getX()][e.getY()] = "XT"+mapElement[e.getX()][e.getY()].getCounter();
            }
            else if (e instanceof Artillery){
                mapElementString[e.getX()][e.getY()] = "XA"+mapElement[e.getX()][e.getY()].getCounter();
            }

        }
    }
    /**
     * @return name of nature in map
     */
    public String[][] getMapNatureString() {
        return mapNatureString;
    }
    /**
     * Update map nature String
     */
    public void fillNatureStringMap() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 13; j++) {
                switch (mapNature[i][j]) {
                    case 0 -> mapNatureString[i][j] = "No";
                    case 1 -> mapNatureString[i][j] = "Hi";
                    case 2 -> mapNatureString[i][j] = "Ju";
                    case 3 -> mapNatureString[i][j] = "Ri";
                    case 4 -> mapNatureString[i][j] = "Br";
                    case 5 -> mapNatureString[i][j] = "Ci";
                    case 6 -> mapNatureString[i][j] = "Ca";
                    case 7 -> mapNatureString[i][j] = "XX";
                    case 8 -> mapNatureString[i][j] = "YY";
                    default -> mapNatureString[i][j] = "";
                }
            }
        }
    }

}
