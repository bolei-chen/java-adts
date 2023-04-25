package sets;

public interface Node<T> {

  T item();

  Node<T> next();

  int key();

  void setItem(T item);

  void setKey(int key);

  void setNext(Node<T> next);//test this is writtne by steven Qi


}
