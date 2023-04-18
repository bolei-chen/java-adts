package lists;

public class CLinkedList<T> implements CList<T>{

  private CNode<T> head;
  private CNode<T> tail;
  private int size;

  public CLinkedList() {
    head = new CNode<>(null);
    tail = head;
    size = 0;
  }



  @Override
  public void add(T element) {
    if (size == 0) {
      head.setElem(element);
    } else {
      CNode<T> current = head;
      while (current.next() != null) {
        current = current.next();
      }
      current.setNext(new CNode<>(element));
      tail = current.next();
    }
    size++;
  }

  @Override
  public void add(T element, int position) {
    if (position >= 0 && position <= size) {
      if (position == 0) {
        CNode<T> addedElement = new CNode<>(element, head);
        head = addedElement;
      }
      int counter = 0;
      CNode<T> current = head;
      while (counter != position - 1) {
        current = current.next();
        counter++;
      }

      CNode<T> addedElement = new CNode<>(element, current.next());
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
      CNode<T> current = head;
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
      CNode<T> current = head;
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
}
