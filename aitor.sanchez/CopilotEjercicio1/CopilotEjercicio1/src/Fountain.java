public class Fountain {

    /*
     * Represents a fountain with a certain capacity of children. Every child spends
     * here between 1 or 4 seconds and then leaves
     */

    private int capacity;
    private int children;

    public Fountain(int capacity) {
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
        System.out.println("Child " + id + " entered the fountain");
        try {
            Thread.sleep((int) (Math.random() * 3000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        children--;
        System.out.println("Child " + id + " left the fountain");
        notifyAll();
    }

}
