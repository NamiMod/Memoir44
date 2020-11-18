public class Main {

    public static void main(String[] args) {

        Army allied = new Allied();
        Army axis = new Axis();
        Map m = new Map(allied , axis);
        Painter p = new Painter();
        p.drawMap(m);

    }
}
