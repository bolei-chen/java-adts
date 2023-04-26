package queues;

public class LinkedQueue<T> implements Queue<T> {

  private int size;
  private Node<T> head;
  private Node<T> tail;

  public LinkedQueue() {
    head = new Node<>(null);
    tail = head;
    size = 0;
  }

  @Override
  public void enqueue(T item) {
    if (isEmpty()) {
      head.item = item;
    } else {
      Node<T> nodeToAdd = new Node<>(item);
      tail.next = nodeToAdd;
      tail = nodeToAdd;
    }
    size++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      return null;
    } else {
      final T elementOut = head.item;
      size--;
      if (size == 1) {
        head.item = null;
        return elementOut;
      } else {
        head = head.next;
        return elementOut;
      }
    }
  }

  @Override
  public T getFirst() {
    return head.item;
  }

  @Override
  public int size() {
    return size;
  }
}
