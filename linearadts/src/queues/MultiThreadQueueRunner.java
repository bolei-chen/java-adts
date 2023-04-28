package queues;

public class MultiThreadQueueRunner extends Thread {
    private Queue<Integer> queue;
    public MultiThreadQueueRunner( Queue<Integer> queue ) {
        this.queue = queue;
    }
    public void run() {
        for (int i = 0; i <= 100; i++) {
            this.queue.enqueue(i);
        }   
        for (int i = 100; i >= 0; i--) {
            Integer v = this.queue.dequeue();
            if (v == i) {
                System.out.println("True");
                System.out.println(v+" "+i);
            } else {
                System.out.println(v+" "+i);
                System.out.println("False");
            }
        }
    }

}