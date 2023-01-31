public class DinningRoom {

    /*
     * Represents a dinning room with a certain capacity of children. Every child
     * spends here between 2 or 6 seconds and then leaves
     */

    private int capacity;
    private int children;

    public DinningRoom(int capacity) {
        this.capacity = capacity;
        this.children = 0;
    }

    public synchronized void enter(int id) {
        while (children == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        children++;
        System.out.println("Child " + id + " entered the dinning room");
        try {
            Thread.sleep((int) (Math.random() * 4000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        children--;
        System.out.println("Child " + id + " left the dinning room");
        notifyAll();
    }

}
