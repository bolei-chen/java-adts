package lists;

import java.util.concurrent.locks.ReentrantLock;

public class Node<T> {

  public ReentrantLock lock = new ReentrantLock();
  private T elem;
  private Node<T> next;

  public Node(T elem) {
    this(elem, null);
  }

  public Node(T elem, Node<T> next) {
    this.elem = elem;
    this.next = next;
  }

  public T elem() {
    return elem;
  }

  public Node<T> next() {
    return next;
  }

  public void setElem(T elem) {
    this.elem = elem;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return elem.toString();
  }

}
