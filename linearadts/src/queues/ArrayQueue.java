package queues;

public class ArrayQueue<T> implements Queue<T> {

  private int first;
  private int last;
  private T[] elements;

  private int size;

  private static final int DEFAULT_MAX = 100;

  public ArrayQueue(int maxSize) {
    elements = (T[]) new Object[maxSize];
    first = -1;
    last = -1;
    size = 0;
  }

  public ArrayQueue() {
    this(ArrayQueue.DEFAULT_MAX);
  }

  private boolean isFull() {
    return size == elements.length;
  }

  @Override
  public void enqueue(T item) {
    if (isFull()) {
      System.out.println("err");
      return;
    }
    if (isEmpty()) {
      first++;
    }
    last = (last + 1) % elements.length;
    elements[last] = item;
    size++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      return null;
    }
    T elementOut = elements[first];
    elements[first] = null;
    if (first == last) {
      first = last = -1;
    } else {
      first = (first + 1) % elements.length;
    }
    size--;
    return elementOut;
  }

  @Override
  public T getFirst() {
    return isEmpty() ? null : elements[first];
  }

  @Override
  public int size() {
    return size;
  }
}
