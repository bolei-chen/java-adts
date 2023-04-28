package queues;

public class Main {
        public static void main(String[] args) {
            int limit = 100;
            MultiThreadQueueRunner[] run = new MultiThreadQueueRunner[limit];
            FinePriorityQueue<Integer> queue = new FinePriorityQueue<>();
            for (int i = 0; i < limit; i++) {
                run[i] = new MultiThreadQueueRunner(queue);
                run[i].run();
            }
            for (int i = 0; i < limit; i++) {
                try {
                    run[i].join(i);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
}