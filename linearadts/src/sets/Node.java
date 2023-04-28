package sets;

import java.util.concurrent.locks.ReentrantLock;

public class Node<T> {

  public T item;
  public int key;
  public Node<T> next;

  public Node(T item, int key, Node<T> next) {
    this.item = item;
    this.key = key;
    this.next = next;
  }

  public Node(T item) {
    this(item, 0, null);
  }

  public Node() {
    this(null, 0, null);
  }

  public T item() {
    return item; 
  }

  public Node<T> next() {
    return next;
  }

  public int key() {
    return key;
  }

  public void setItem(T item) {
    this.item = item; 

  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setNext(Node<T> next) {
    this.next =  next;
  }

}
