public class Child extends Thread {

    /*
     * Represents a child with an id that can do one action among four:
     * go to the playgrond
     * go to the dinning room
     * go to the fountain
     * go to the bedroom
     * go to the park
     * 
     * The child starts going to the playground and then chooses randomly another
     * action
     */

    private int id;
    private int action;
    private Playground playground;
    private DinningRoom dinningRoom;
    private Fountain fountain;
    private Bedroom bedroom;
    private Park park;

    public Child(int id, Playground playground, DinningRoom dinningRoom, Fountain fountain, Bedroom bedroom,
            Park park) {
        this.id = id;
        this.playground = playground;
        this.dinningRoom = dinningRoom;
        this.fountain = fountain;
        this.bedroom = bedroom;
        this.park = park;
    }

    public void run() {
        action = 1;
        playground.enter(id);
        while (true) {
            action = (int) (Math.random() * 5) + 1;
            switch (action) {
                case 1:
                    playground.enter(id);
                    break;
                case 2:
                    dinningRoom.enter(id);
                    break;
                case 3:
                    fountain.enter(id);
                    break;
                case 4:
                    bedroom.enter(id);
                    break;
                case 5:
                    park.enter(id);
                    break;
            }
        }
    }

}
