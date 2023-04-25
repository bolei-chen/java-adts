package lists;

public class CNode<T> {

  private T elem;

  private CNode<T> next;

  public CNode(T elem) {
    this(elem, null);
  }

  public CNode(T elem, CNode<T> next) {
    this.elem = elem;
    this.next = next;
  }

  public T elem() {
    return elem;
  }

  public CNode<T> next() {
    return next;
  }

  public void setElem(T elem) {
    this.elem = elem;
  }

  public void setNext(CNode<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return elem.toString();
  }

}
