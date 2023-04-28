package queues;

public class FinePriorityQueue<T extends Comparable<T>> implements Queue<T> {
    
  private Node<T> head;
  private Node<T> tail;
  private volatile int size;

  public FinePriorityQueue() {
    head = new Node<>();
    tail = head;
    size = 0;
  }

  
  public void enqueue(T item) {
    Node<T> elementToAdd = new Node<>(item);
    if (size == 0) {
      head.lock.lock();
      head.item = item;
      head.lock.unlock();
    } else {
      if (head.item.compareTo(item) < 0) {
        head.lock.lock();
        elementToAdd.lock.lock();
        try {
          elementToAdd.next = head;
          head = elementToAdd;
        } catch (Exception e) {
        } finally {
          head.lock.unlock();
        }
      } else {
        Node<T> prev = this.head;
        Node<T> curr = prev;
        prev.lock.lock();
        int cond;
        do {
          curr = curr.next;
          if (curr == null) {
            break;
          }
          curr.lock.lock();
          prev.lock.unlock();
          prev = curr;
          cond = curr.item.compareTo(item);
        } while (cond > 0);

        if (prev.next == null) {
          prev.next = elementToAdd;
          this.tail = elementToAdd;
          prev.lock.unlock();
        } else {
          prev.next.lock.lock();
          curr = prev.next;
          prev.next = elementToAdd;
          elementToAdd.next = curr;
          prev.lock.unlock();
          curr.lock.unlock();
        }
      }
    }
    size++;
  }
   
  public T dequeue() {
    if (size == 0) {
      return null;
    }
    T elementOut; 
    if (size == 1) {
      head.lock.lock();
      elementOut = head.item;
      head.item = null;
      head.lock.unlock(); 
      size--;
    } else {
        // potential cause of problem 
        Node<T> prev;
        head.lock.lock();
        head.next.lock.lock(); 
        prev = head;
        elementOut = head.item;
        head = head.next; 
        prev.lock.unlock();
        head.lock.unlock(); 
        size--;
    }
    return elementOut;
  }

  public T getFirst() {
    try{
      head.lock.lock();
      return head.item;
    } finally {
      head.lock.unlock();
    }
  }

  public int size() {
    return size;
  }
}
