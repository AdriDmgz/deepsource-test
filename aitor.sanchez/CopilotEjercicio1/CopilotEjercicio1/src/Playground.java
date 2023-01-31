public class Playground {

    /*
     * Represents a playground with a certain capacity of children. Every child
     * spends here between 3 or 7 seconds and then leaves
     */

    private int capacity;
    private int children;

    public Playground(int capacity) {
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
        System.out.println("Child " + id + " entered the playground");
        try {
            Thread.sleep((int) (Math.random() * 5000) + 3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        children--;
        System.out.println("Child " + id + " left the playground");
        notifyAll();
    }

}
