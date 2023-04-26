package lists;

public class LinkedList<T> implements List<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public LinkedList() {
    head = new Node<>(null);
    tail = head;
    size = 0;
  }



  @Override
  public void add(T element) {
    if (size == 0) {
      head.setElem(element);
    } else {
      Node<T> curr = head;
      while (curr.next() != null) {
        curr = curr.next();
      }
      curr.setNext(new Node<>(element));
      tail = curr.next();
    }
    size++;
  }

  @Override
  public void add(T element, int position) {
    if (position >= 0 && position <= size) {
      if (position == 0) {
        Node<T> addedElement = new Node<>(element, head);
        head = addedElement;
      }
      int counter = 0;
      Node<T> current = head;
      while (counter != position - 1) {
        current = current.next();
        counter++;
      }

      Node<T> addedElement = new Node<>(element, current.next());
      current.setNext(addedElement);
      size++;

    } else {
      // error here
    }
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

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {
    List<Integer> ints = new LinkedList<>();
    for (int i = 0; i < 400; i++) {
      ints.add(i);
    }
    System.out.println(ints);

  }


}
