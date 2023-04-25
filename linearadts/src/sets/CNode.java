package sets;

import java.util.concurrent.locks.ReentrantLock;

public class CNode<T> implements Node<T>{

  private T item;
  private int key; 
  private Node<T> next;
  public ReentrantLock lock = new ReentrantLock();
  @Override
  public T item() {
    return item; 
  }

  @Override
  public Node<T> next() {
    return next;
  }

  @Override
  public int key() {
    return key;
  }

  @Override
  public void setItem(T item) {
    this.item = item; 

  }

  @Override
  public void setKey(int key) {
    this.key = key;
  }

  @Override
  public void setNext(Node<T> next) {
    this.next =  next;
  }

}
