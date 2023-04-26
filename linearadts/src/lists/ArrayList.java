package lists;

public class ArrayList<T> implements List<T> {

  public static final int DEFAULT_SIZE = 100;
  private int size;
  private T[] elements;
  private int limit;

  public ArrayList() {
    elements = (T[]) new Object[DEFAULT_SIZE];
    size = 0;
    limit = DEFAULT_SIZE - 1;
  }

  public ArrayList(int size) {
    elements = (T[]) new Object[size];
    this.size = 0;
    limit = size;
  }


  private void rebuild() {
    T[] copy = (T[]) new Object[size * 2];
    limit *= 2;
    for (int i = 0; i < size; i++) {
      copy[i] = elements[i];
    }
    elements = copy;
  }

  // assumption: there is space for left shifting
  private void shiftLeft(int position) {
    for (int i = position; i < size; i++) {
      elements[i] = elements[i + 1];
    }
  }

  // assumption: there is space for right shifting
  private void shiftRight(int position) {
    for (int i = size; i > position; i--) {
      elements[i] = elements[i - 1];
    }
  }

  private boolean checkFull() {
    if (size + 1 > limit) {
      rebuild();
      return true;
    }
    return false;
  }

  @Override
  public void add(T element) {
    checkFull();
    elements[size] = element;
    size++;

  }

  @Override
  public void add(T element, int position) {
    checkFull();
    if (position >= 0 && position <= size) {
      shiftRight(position);
      elements[position] = element;
      size++;
    } else {
      // error here
    }

  }

  @Override
  public T get(int position) {
    if (position >= 0 && position <= size) {
      return elements[position];
    } else {
      // error here
      return null;
    }
  }

  @Override
  public T remove(int position) {
    if (position >= 0 && position <= size) {
      T removedElement = elements[position];
      shiftLeft(position);
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
    for (int i = 0; i < size; i++) {
      sb.append(elements[i].toString());
      if (i == size - 1) {
        break;
      }
      if (elements[i + 1] != null) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

}
