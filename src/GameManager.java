/**
 * in this class we can use game functions ( move , attack , score )
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
public class GameManager {

    private Army allied = new Allied();
    private Army axis = new Axis();
    private Map map;
    private Dice dice;

    public GameManager(Army allied, Army axis) {
        this.allied = allied;
        this.axis = axis;
        map = new Map(allied, axis);
        dice = new Dice();
    }

    /**
     * update score of allied army
     *
     * @return score of allied army
     */
    public int updateAlliedScore() {
        int score = 0;
        for (Element e : axis.getElements()) {
            if (e instanceof Soldier) {
                score = score + (4 - e.getCounter());
            }
            if (e instanceof Tank) {
                score = score + (4 - e.getCounter());
            }
        }
        for (Element e : allied.getElements()) {
            if (e.getX() == 2 && e.getY() == 0) {
                score = score + 1;
                break;
            }
        }
        allied.setScore(score);
        return score;
    }

    /**
     * update score of axis army
     *
     * @return score of axis army
     */
    public int updateAxisScore() {
        int score = 0;
        for (Element e : allied.getElements()) {
            if (e instanceof Soldier) {
                score = score + (4 - e.getCounter());
            }
            if (e instanceof Tank) {
                score = score + (3 - e.getCounter());
            }
            if (e instanceof Artillery) {
                score = score + (2 - e.getCounter());
            }
        }
        for (Element e : axis.getElements()) {
            if (e.getX() == 8 && e.getY() == 11) {
                score = score + 1;
                break;
            }
        }
        axis.setScore(score);
        return score;
    }

    /**
     * @return is allied winner ?
     */
    public boolean isAlliedWinner() {
        return allied.isWinner();
    }

    /**
     * @return is axis winner ?
     */
    public boolean isAxisWinner() {
        return axis.isWinner();
    }

    public boolean move(String army, int x, int y, String movement) {

        if (army.equals("Allied")) {
            for (Element e : allied.getElements()) {
                if (e.getX() == x && e.getY() == y) {
                    if (e instanceof Soldier) {
                        if (movement.equals("U") && x - 1 >= 0 && map.getNature(x - 1, y) != 3 && map.getMapElement_valid()[x - 1][y] == 0) {
                            e.setLocation(x - 1, y);
                            return true;

                        }
                        if (movement.equals("D") && x + 1 < 9 && map.getNature(x + 1, y) != 3 && map.getMapElement_valid()[x + 1][y] == 0) {
                            e.setLocation(x + 1, y);
                            return true;

                        }
                        if (movement.equals("UR") && x - 1 >= 0 && y + 1 < 13 && map.getNature(x - 1, y + 1) != 3 && map.getMapElement_valid()[x - 1][y + 1] == 0) {
                            e.setLocation(x - 1, y + 1);
                            return true;

                        }
                        if (movement.equals("UL") && x - 1 >= 0 && y - 1 >= 0 && map.getNature(x - 1, y - 1) != 3 && map.getMapElement_valid()[x - 1][y - 1] == 0) {
                            e.setLocation(x - 1, y - 1);
                            return true;

                        }
                        if (movement.equals("DR") && x + 1 < 9 && y + 1 < 13 && map.getNature(x + 1, y + 1) != 3 && map.getMapElement_valid()[x + 1][y + 1] == 0) {
                            e.setLocation(x + 1, y + 1);
                            return true;

                        }
                        if (movement.equals("DL") && x + 1 < 9 && y - 1 >= 0 && map.getNature(x + 1, y - 1) != 3 && map.getMapElement_valid()[x + 1][y - 1] == 0) {
                            e.setLocation(x + 1, y - 1);
                            return true;

                        }

                    } else {
                        if (movement.equals("U") && x - 1 >= 0 && map.getNature(x - 1, y) != 3 && map.getNature(x - 1, y) != 6 && map.getMapElement_valid()[x - 1][y] == 0) {
                            e.setLocation(x - 1, y);
                            return true;

                        }
                        if (movement.equals("D") && x + 1 < 9 && map.getNature(x + 1, y) != 3 && map.getNature(x + 1, y) != 6 && map.getMapElement_valid()[x + 1][y] == 0) {
                            e.setLocation(x + 1, y);
                            return true;

                        }
                        if (movement.equals("UR") && x - 1 >= 0 && y + 1 < 13 && map.getNature(x - 1, y + 1) != 3 && map.getNature(x - 1, y + 1) != 6 && map.getMapElement_valid()[x - 1][y + 1] == 0) {
                            e.setLocation(x - 1, y + 1);
                            return true;

                        }
                        if (movement.equals("UL") && x - 1 >= 0 && y - 1 >= 0 && map.getNature(x - 1, y - 1) != 3 && map.getNature(x - 1, y - 1) != 6 && map.getMapElement_valid()[x - 1][y - 1] == 0) {
                            e.setLocation(x - 1, y - 1);
                            return true;

                        }
                        if (movement.equals("DR") && x + 1 < 9 && y + 1 < 13 && map.getNature(x + 1, y + 1) != 3 && map.getNature(x + 1, y + 1) != 6 && map.getMapElement_valid()[x + 1][y + 1] == 0) {
                            e.setLocation(x + 1, y + 1);
                            return true;

                        }
                        if (movement.equals("DL") && x + 1 < 9 && y - 1 >= 0 && map.getNature(x + 1, y - 1) != 3 && map.getNature(x + 1, y - 1) != 6 && map.getMapElement_valid()[x + 1][y - 1] == 0) {
                            e.setLocation(x + 1, y - 1);
                            return true;

                        }
                    }
                    break;
                }
            }


        }
        if (army.equals("Axis")) {
            for (Element e : axis.getElements()) {
                if (e.getX() == x && e.getY() == y) {
                    if (e instanceof Soldier) {
                        if (movement.equals("U") && x - 1 >= 0 && map.getNature(x - 1, y) != 3 && map.getMapElement_valid()[x - 1][y] == 0) {
                            e.setLocation(x - 1, y);
                            return true;

                        }
                        if (movement.equals("D") && x + 1 < 9 && map.getNature(x + 1, y) != 3 && map.getMapElement_valid()[x + 1][y] == 0) {
                            e.setLocation(x + 1, y);
                            return true;

                        }
                        if (movement.equals("UR") && x - 1 >= 0 && y + 1 < 13 && map.getNature(x - 1, y + 1) != 3 && map.getMapElement_valid()[x - 1][y + 1] == 0) {
                            e.setLocation(x - 1, y + 1);
                            return true;

                        }
                        if (movement.equals("UL") && x - 1 >= 0 && y - 1 >= 0 && map.getNature(x - 1, y - 1) != 3 && map.getMapElement_valid()[x - 1][y - 1] == 0) {
                            e.setLocation(x - 1, y - 1);
                            return true;

                        }
                        if (movement.equals("DR") && x + 1 < 9 && y + 1 < 13 && map.getNature(x + 1, y + 1) != 3 && map.getMapElement_valid()[x + 1][y + 1] == 0) {
                            e.setLocation(x + 1, y + 1);
                            return true;

                        }
                        if (movement.equals("DL") && x + 1 < 9 && y - 1 >= 0 && map.getNature(x + 1, y - 1) != 3 && map.getMapElement_valid()[x + 1][y - 1] == 0) {
                            e.setLocation(x + 1, y - 1);
                            return true;

                        }

                    } else {
                        if (movement.equals("U") && x - 1 >= 0 && map.getNature(x - 1, y) != 3 && map.getNature(x - 1, y) != 6 && map.getMapElement_valid()[x - 1][y] == 0) {
                            e.setLocation(x - 1, y);
                            return true;

                        }
                        if (movement.equals("D") && x + 1 < 9 && map.getNature(x + 1, y) != 3 && map.getNature(x + 1, y) != 6 && map.getMapElement_valid()[x + 1][y] == 0) {
                            e.setLocation(x + 1, y);
                            return true;

                        }
                        if (movement.equals("UR") && x - 1 >= 0 && y + 1 < 13 && map.getNature(x - 1, y + 1) != 3 && map.getNature(x - 1, y + 1) != 6 && map.getMapElement_valid()[x - 1][y + 1] == 0) {
                            e.setLocation(x - 1, y + 1);
                            return true;

                        }
                        if (movement.equals("UL") && x - 1 >= 0 && y - 1 >= 0 && map.getNature(x - 1, y - 1) != 3 && map.getNature(x - 1, y - 1) != 6 && map.getMapElement_valid()[x - 1][y - 1] == 0) {
                            e.setLocation(x - 1, y - 1);
                            return true;

                        }
                        if (movement.equals("DR") && x + 1 < 9 && y + 1 < 13 && map.getNature(x + 1, y + 1) != 3 && map.getNature(x + 1, y + 1) != 6 && map.getMapElement_valid()[x + 1][y + 1] == 0) {
                            e.setLocation(x + 1, y + 1);
                            return true;

                        }
                        if (movement.equals("DL") && x + 1 < 9 && y - 1 >= 0 && map.getNature(x + 1, y - 1) != 3 && map.getNature(x + 1, y - 1) != 6 && map.getMapElement_valid()[x + 1][y - 1] == 0) {
                            e.setLocation(x + 1, y - 1);
                            return true;

                        }
                    }

                    break;
                }
            }
        }
        return false;
    }

    public boolean attack(String army , int x , int y , int xx , int yy) {

        int d;
        int distance = map.distance(x,y,xx,yy);

        if (army.equals("Allied")){

            for (Element e:allied.getElements()){
                if (e.getX()==x && e.getY() == y){
                    if (e instanceof Soldier){
                        if (distance == 1){
                            for (int i = 0 ; i < 3 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 2){
                            for (int i = 0 ; i < 2 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 3){
                            for (int i = 0 ; i < 1 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                    }
                    if (e instanceof Tank){
                        for (int i = 0 ; i < 3 ; i++){
                            d = dice.getDice();
                            if (d == 1 || d == 6){
                                for (Element temp: axis.getElements()){
                                    if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                        temp.Decrease();
                                        return true;
                                    }
                                }
                                return false;
                            }
                            if (d == 2){
                                for (Element temp: axis.getElements()){
                                    if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                        temp.Decrease();
                                        return true;
                                    }
                                }
                                return false;
                            }
                            if (d == 5){
                                for (Element temp: axis.getElements()){
                                    if (temp.getX() == xx && temp.getY() == y){
                                        temp.Decrease();
                                        return true;
                                    }
                                }
                                return false;
                            }
                            if (d == 3 || d == 4){
                                return true;
                            }
                        }
                    }
                    if (e instanceof Artillery){
                        if (distance == 1 || distance == 2){
                            for (int i = 0 ; i < 3 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 3 || distance == 4){
                            for (int i = 0 ; i < 4 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 5 || distance == 6){
                            for (int i = 0 ; i < 1 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: axis.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }

                    }
                }
            }


        }else{
            for (Element e:axis.getElements()){
                if (e.getX()==x && e.getY() == y){
                    if (e instanceof Soldier){
                        if (distance == 1){
                            for (int i = 0 ; i < 3 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 2){
                            for (int i = 0 ; i < 2 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 3){
                            for (int i = 0 ; i < 1 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                    }
                    if (e instanceof Tank){
                        for (int i = 0 ; i < 3 ; i++){
                            d = dice.getDice();
                            if (d == 1 || d == 6){
                                for (Element temp: allied.getElements()){
                                    if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                        temp.Decrease();
                                        return true;
                                    }
                                }
                                return false;
                            }
                            if (d == 2){
                                for (Element temp: allied.getElements()){
                                    if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                        temp.Decrease();
                                        return true;
                                    }
                                }
                                return false;
                            }
                            if (d == 5){
                                for (Element temp: allied.getElements()){
                                    if (temp.getX() == xx && temp.getY() == y){
                                        temp.Decrease();
                                        return true;
                                    }
                                }
                                return false;
                            }
                            if (d == 3 || d == 4){
                                return true;
                            }
                        }
                    }
                    if (e instanceof Artillery){
                        if (distance == 1 || distance == 2){
                            for (int i = 0 ; i < 3 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 3 || distance == 4){
                            for (int i = 0 ; i < 4 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }
                        if (distance == 5 || distance == 6){
                            for (int i = 0 ; i < 1 ; i++){
                                d = dice.getDice();
                                if (d == 1 || d == 6){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Soldier){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 2){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y && temp instanceof Tank){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 5){
                                    for (Element temp: allied.getElements()){
                                        if (temp.getX() == xx && temp.getY() == y){
                                            temp.Decrease();
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                                if (d == 3 || d == 4){
                                    return true;
                                }
                            }
                        }

                    }
                }
            }
        }
        return false;
    }

}
