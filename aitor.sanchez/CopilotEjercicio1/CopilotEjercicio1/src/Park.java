public class Park {

    /*
     * Represents a park with unlimited capacity of children. Every child
     * spends here between 5 or 9 seconds and then leaves
     */

    public synchronized void enter(int id) {
        System.out.println("Child " + id + " entered the park");
        try {
            Thread.sleep((int) (Math.random() * 5000) + 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child " + id + " left the park");

    }

}
