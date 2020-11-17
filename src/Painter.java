/**
 * in this class we can draw cards and map
 * @author Seyed Nami Modarressi
 * @since 2020
 * @version 1.0
 */
public class Painter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN

    /**
     * Draw card
     * @param p number of card
     */
    public void drawCard(int p) {

        if (p == 1) {
            System.out.println(BLUE_BOLD + "---------------------");
            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }

            System.out.print(".   Order 1 unit    .\n");

            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }
            System.out.println("---------------------" + ANSI_RESET);
        }
        if (p == 2) {
            System.out.println(GREEN_BOLD + "---------------------");
            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }

            System.out.print(".   Order 2 units   .\n");

            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }
            System.out.println("---------------------" + ANSI_RESET);
        }
        if (p == 3) {
            System.out.println(YELLOW_BOLD + "---------------------");
            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }

            System.out.print(".   Order 3 units   .\n");

            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }
            System.out.println("---------------------" + ANSI_RESET);
        }
        if (p == 4) {
            System.out.println(PURPLE_BOLD + "---------------------");
            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }

            System.out.print(".   Order 4 units   .\n");

            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }
            System.out.println("---------------------" + ANSI_RESET);
        }
        if (p == 5) {
            System.out.println(CYAN_BOLD + "---------------------");
            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }

            System.out.print(". Order 3 same units.\n");

            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }
            System.out.println("---------------------" + ANSI_RESET);
        }

    }

    /**
     * draw 2 cards
     * @param p first card number
     * @param q second card number
     */
    public void drawCard2(int p, int q) {
        drawCard(p);
        drawCard(q);
    }

    /**
     * draw 4 cards
     * @param p first card number
     * @param q second card number
     * @param s third card number
     * @param w fourth card number
     */
    public void drawCard4(int p, int q, int s, int w) {
        drawCard(p);
        drawCard(q);
        drawCard(s);
        drawCard(w);
    }

    /**
     * draw winner card
     * @param winner winner of game
     */
    public void winnerAlert(String winner) {
        if (winner.equals("Allied")) {
            System.out.println(RED_BOLD + "---------------------");
            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }

            System.out.print(". Allied is Winner  .\n");

            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }
            System.out.println("---------------------" + ANSI_RESET);
        }
        if (winner.equals("Axis")) {
            System.out.println(RED_BOLD + "---------------------");
            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }

            System.out.print(".   Axis is Winner  .\n");

            for (int i = 0; i < 2; i++) {
                System.out.println(".                   .");
            }
            System.out.println("---------------------" + ANSI_RESET);
        }
    }

    /**
     * draw map of game
     * @param m map
     */
    public void drawMap(Map m) {
        m.fillElementStringMap();
        m.fillNatureStringMap();

        // row 0
        for (int i = 0; i < 13; i++) {
            System.out.print(GREEN_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[0][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[0][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(GREEN_BOLD + "-------\t");
        }
        System.out.println();

        // row 1
        for (int i = 0; i < 13; i++) {
            System.out.print(RED_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[1][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[1][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(RED_BOLD + "-------\t");
        }
        System.out.println();
        // row 2
        for (int i = 0; i < 13; i++) {
            System.out.print(BLUE_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[2][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[2][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(BLUE_BOLD + "-------\t");
        }
        System.out.println();
        // row 3
        for (int i = 0; i < 13; i++) {
            System.out.print(YELLOW_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[3][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[3][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(YELLOW_BOLD + "-------\t");
        }
        System.out.println();
        // row 4
        for (int i = 0; i < 13; i++) {
            System.out.print(PURPLE_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[4][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[4][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(PURPLE_BOLD + "-------\t");
        }
        System.out.println();
        // row 5
        for (int i = 0; i < 13; i++) {
            System.out.print(GREEN_BOLD_BRIGHT + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[5][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[5][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(GREEN_BOLD_BRIGHT + "-------\t");
        }
        System.out.println();
        // row 6
        for (int i = 0; i < 13; i++) {
            System.out.print(RED_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[6][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[6][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(RED_BOLD + "-------\t");
        }
        System.out.println();
        // row 7
        for (int i = 0; i < 13; i++) {
            System.out.print(BLUE_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[7][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[7][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(BLUE_BOLD + "-------\t");
        }
        System.out.println();
        // row 8
        for (int i = 0; i < 13; i++) {
            System.out.print(YELLOW_BOLD + "-------\t");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s  .\t", m.getMapNatureString()[8][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.printf(". %s .\t", m.getMapElementString()[8][i]);
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print(YELLOW_BOLD + "-------\t");
        }
        System.out.println();

    }

}
