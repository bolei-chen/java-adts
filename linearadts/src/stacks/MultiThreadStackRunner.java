package stacks;

public class MultiThreadStackRunner implements Runnable {

  private Stack stack;

  public MultiThreadStackRunner(Stack<Integer> stack) {
    this.stack = stack;
  }

  @Override
  public void run() {
    for (int i = 0; i <= 100; i++) {
      stack.push(i);
    }
    for (int i = 100; i >= 0; i--) {
      Integer e = (Integer) stack.pop();
      if (e == i) {
        System.out.println("True");
      } else {
        System.out.println("False");
        System.out.println(e + " " + i);
      }
    }

  }
}
