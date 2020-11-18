/**
 * this is main class of game
 * in his class we use our method to play game
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Army allied = new Allied();
        int [][] nature = new int[9][13];
        Army axis = new Axis();
        Map map = new Map(allied,axis);
        Card card = new Card();
        Painter painter = new Painter();
        GameManager manager = new GameManager(allied,axis);
        int choice = 0;
        int turn = 1;
        Scanner getChoice = new Scanner(System.in);
        System.out.println();
        System.out.println("$$##    Welcome to Memoir44    ##$$");
        System.out.println("---------------");
        while (choice != 1){
            System.out.println("1) Start Game");
            System.out.println("2) Option");
            System.out.println("3) About Me !");
            System.out.println("4) About game");
            System.out.println("---------------");
            System.out.println("Please Enter your choice :");
            choice = getChoice.nextInt();
            if (choice == 2){
                System.out.println("---------------");
                System.out.println("Enter nature of map using this construction :");
                System.out.println("nature : ");
                System.out.println("0 -> normal ");
                System.out.println("1 -> hill ");
                System.out.println("2 -> jungle ");
                System.out.println("3 -> river ");
                System.out.println("4 -> bridge ");
                System.out.println("5 -> city ");
                System.out.println("6 -> camp ");
                System.out.println("---------------");
                Scanner p = new Scanner(System.in);
                for (int i = 0 ; i < 9 ; i++){
                    for (int j = 0 ; j < 13 ; j++){
                        nature[i][j] = p.nextInt();
                    }
                }
                map.setMapNature(nature);
                System.out.println("Done");
            }
            if (choice == 3){
                System.out.println("---------------");
                System.out.println("Programmer : Seyed Nami Modarressi");
                System.out.println("Computer Engineering Student at Amirkabir University of Technology");
                System.out.println("---------------");
            }
            if (choice == 4){
                System.out.println("---------------");
                System.out.println("##  this game is first version of game  ##");
                System.out.println("Memoir '44 is a light war game, or war-themed");
                System.out.println("strategy board game, for two players created by");
                System.out.println("Richard Borg, published in 2004 by Days of Wonder");
                System.out.println("and illustrated by Julien Delval and Cyrille Daujean");
                System.out.println("---------------");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        while (!manager.isAlliedWinner() && !manager.isAxisWinner()){

            // drawing part

            if (turn % 2 == 1){
                System.out.print("Allied Turn -- ");
            }
            if (turn % 2 == 0){
                System.out.print("Axis Turn -- ");
            }
            System.out.printf("Turn %d -- Allied Score : %d -- Axis Score : %d \n",turn,allied.getScore(),axis.getScore());
            for (int i = 0 ; i < 20 ; i++){
                System.out.print("-----");
            }
            System.out.print("---");
            System.out.println();
            painter.drawMap(map,allied,axis);

            // end drawing part

            boolean flag = false;

            if (turn % 2 == 1){
                int c1 = card.getCard();
                int c2 = card.getCard();
                int c3 = card.getCard();
                int c4 = card.getCard();
                painter.drawCard4(c1,c2,c3,c4);
                System.out.print("Enter your choice :");
                choice = getChoice.nextInt();
                if (choice == c1 || choice == c2 ||choice == c3 ||choice == c4 ) {
                    if (choice == 1) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 1; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Allied", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Allied", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 2) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 2; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Allied", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Allied", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 3) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Allied", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Allied", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 4) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 4; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Allied", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Allied", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 5) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Allied", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Allied", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                }else {
                    System.out.println("Wrong choice!");
                    turn  = turn - 1 ;
                    flag = true;
                }
            }
            if (turn % 2 == 0 && !flag){
                int w1 = card.getCard();
                int w2 = card.getCard();
                painter.drawCard2(w1,w2);
                System.out.print("Enter your choice :");
                choice = getChoice.nextInt();
                if (choice == w1 || choice == w2 ) {
                    if (choice == 1) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 1; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Axis", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Axis", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 2) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 2; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Axis", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Axis", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 3) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Axis", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Axis", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 4) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 4; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Axis", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Axis", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                    if (choice == 5) {
                        int x;
                        int y;
                        int xx;
                        int yy;
                        String move = "";
                        System.out.println("Enter 0 0 E to exit");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("enter x :");
                            x = getChoice.nextInt();
                            System.out.print("enter y :");
                            y = getChoice.nextInt();
                            System.out.println("enter movement :");
                            String temp = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.move("Axis", x, y, move);
                                if (!result) {
                                    System.out.println("Cant move");
                                }
                            }
                            // attack
                            System.out.print("enter xx :");
                            xx = getChoice.nextInt();
                            System.out.print("enter yy :");
                            yy = getChoice.nextInt();
                            System.out.println("enter E to exit attacking :");
                            String temp1 = getChoice.nextLine();
                            move = getChoice.nextLine();
                            if (move.equals("E")) {
                                break;
                            } else {
                                boolean result = manager.attack("Axis", x, y, xx, yy);
                                if (!result) {
                                    System.out.println("Cant attack");
                                }
                            }
                        }
                    }
                }else {
                    System.out.println("Wrong choice!");
                    turn  = turn - 1 ;
                }
            }
            // update map and scores and turn counter
            allied.setScore(manager.updateAlliedScore());
            axis.setScore(manager.updateAxisScore());
            map.firstMapElement(allied,axis);
            turn = turn + 1 ;

        }
        if (manager.isAlliedWinner()){
            painter.winnerAlert("Allied");
        }
        if (manager.isAxisWinner()){
            painter.winnerAlert("Axis");
        }

    }
}
