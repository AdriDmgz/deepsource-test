public class Bedroom {

    /*
     * Represents a bedroom with a certain capacity of children. Every child
     * spends here between 15 or 19 seconds and then leaves
     */

    private int capacity;
    private int children;

    public Bedroom(int capacity) {
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
        System.out.println("Child " + id + " entered the bedroom");
        try {
            Thread.sleep((int) (Math.random() * 4000) + 15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        children--;
        System.out.println("Child " + id + " left the bedroom");
        notifyAll();
    }

}
