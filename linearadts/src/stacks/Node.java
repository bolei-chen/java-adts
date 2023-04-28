package stacks;

import java.util.concurrent.locks.ReentrantLock;

public class Node<T> {
  public T item;
  public Node<T> next;
  public ReentrantLock lock = new ReentrantLock();

  public Node(T item, Node<T> next) {
    this.item = item;
    this.next = next;
  }

  public Node(T item) {
    this(item, null);
  }


}
