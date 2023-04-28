package stacks;

public class Main {

  public static void main(String[] args) {
    int limit = 100;
    Thread[] runners = new Thread[limit];
    FineLinkedStack<Integer> stack = new FineLinkedStack<>();
    for (int i = 0; i < limit; i++) {
      runners[i] = new Thread(new MultiThreadStackRunner(stack));
      runners[i].start();
    }

    for (int i = 0; i < limit; i++) {
      try {
        runners[i].join(i);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

  }

}
