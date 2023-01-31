public class App {
    public static void main(String[] args) throws Exception {

        Playground playground = new Playground(10);
        DinningRoom dinningRoom = new DinningRoom(4);
        Fountain fountain = new Fountain(8);
        Bedroom bedroom = new Bedroom(10);
        Park park = new Park();

        // For loop to start 52 children
        for (int i = 1; i <= 52; i++) {
            Child child = new Child(i, playground, dinningRoom, fountain, bedroom, park);
            child.start();
        }

    }
}
