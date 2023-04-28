package stacks;

public class ArrayStack<T> implements Stack<T> {

  public static final int MAX_SIZE = 100;
  private T[] elements;
  private int top;
  private int size;

  public ArrayStack(int size) {
    elements = (T[]) new Object[size];
    top = -1;
    size = 0;
  }

  public ArrayStack() {
    this(ArrayStack.MAX_SIZE);
  }

  @Override
  public void push(T element) {
    if (!isFull()) {
      elements[top++] = element;
      size++;
    } else {
      System.out.println("err: stack is full");
    }
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      System.out.println("err: stack is empty");
      return null;
    }
    T elementOut = elements[top];
    elements[top] = null;
    top--;
    size--;
    return elementOut;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      System.out.println("err: stack is empty");
      return null;
    }
    return elements[top];
  }

  @Override
  public boolean isEmpty() {
    return size <= 0;
  }

  @Override
  public int size() {
    return size;
  }

  public boolean isFull() {
    return size >= elements.length;
  }
}
