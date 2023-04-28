package stacks;

public class FineLinkedStack<T> implements Stack<T> {

  private Node<T> top;
  private volatile int size;

  public FineLinkedStack() {
    top = new Node<>(null);
    size = 0;
  }

  @Override
  public void push(T element) {
    if (size == 0) {
      top.lock.lock();
      top.item = element;
      top.lock.unlock();
    } else {
      Node<T> elementToAdd = new Node<>(element);
      elementToAdd.lock.lock();
      top.lock.lock();
      elementToAdd.next = top;
      top = elementToAdd;
      top.lock.unlock();
    }
    size++;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      System.out.println("err: stack is empty");
      return null;
    }
    top.lock.lock();
    top.next.lock.lock();
    T elementOut = top.item;
    top = top.next;
    top.lock.lock();
    size--;
    return elementOut;
  }

  @Override
  public T peek() {
    top.lock.lock();
    T element = top.item;
    top.lock.unlock();
    return element;
  }

  @Override
  public boolean isEmpty() {
    return size <= 0;
  }

  @Override
  public int size() {
    return size;
  }
}
