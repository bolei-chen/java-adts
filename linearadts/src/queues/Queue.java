package queues;

public interface Queue<T> {

  public void enqueue(T item);

  public T dequeue();

  public T getFirst();

  default public boolean isEmpty() {
    return size() == 0;
  }

  public int size();

}
