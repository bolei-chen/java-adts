package lists;

public class OrderedLinkedList<T extends Comparable<T>> implements List<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public OrderedLinkedList() {
    head = new Node<>(null);
    size = 0;
    tail = head;
  }

  @Override
  public void add(T element) {
    Node<T> nodeToAdd = new Node<>(element, null);
    if (head.elem() == null) {
      head = nodeToAdd;
    }
    if (element.compareTo(head.elem()) <= 0) {
      nodeToAdd.setNext(head);
      head = nodeToAdd;
      if (size == 1) {
        tail = nodeToAdd.next();
        // wtf is going on
        tail.setNext(null);
      }
    } else {
      Node<T> current = head;
      while (current.next() != null && current.next().elem().compareTo(element) > 0) {
        current = current.next();
      }
      if (current.next() == null) {
        tail = nodeToAdd;
      }
      nodeToAdd.setNext(current.next());
      current.setNext(nodeToAdd);
    }
    size++;
  }

  @Override
  public void add(T element, int position) {
    // not supported
  }

  @Override
  public T get(int position) {
    if (position >= 0 && position <= size) {
      int counter = 0;
      Node<T> current = head;
      while (counter != position) {
        current = current.next();
        counter++;
      }
      return current.elem();
    } else {
      // error here
      return null;
    }
  }

  @Override
  public T remove(int position) {
    if (position >= 0 && position <= size) {
      if (position == 0) {
        T removedElement = head.elem();
        head = head.next();
        return removedElement;
      }
      int counter = 0;
      Node<T> current = head;
      while (counter != position - 1) {
        current = current.next();
        counter++;
      }
      T removedElement = current.next().elem();
      current.setNext(current.next().next());
      size--;
      return removedElement;

    } else {
      // error here
      return null;
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<T> current = head;
    while (current.next() != null) {
      sb.append(current + ", ");
      current = current.next();
    }
    sb.append(tail + "]");
    return sb.toString();
  }


  public static void main(String[] args) {
    List<Integer> ints = new OrderedLinkedList<>();
    for (int i = 400; i > 1; i--) {
      ints.add(i);
    }
    System.out.println(ints);

  }
}
